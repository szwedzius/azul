import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

// Server class
class Server {
    static ArrayList<ClientHandler> clients;
    private static int numOfPlayers = 1000;
    private static volatile boolean start = false;
    private static volatile boolean end = false;

    static ConcurrentLinkedQueue<String> data = new ConcurrentLinkedQueue<>();
    static ClientHandler sender;

    public static void main(String[] args)
    {
        AllSender send = new AllSender();
        new Thread(send).start();

        clients = new ArrayList<>();
        ServerSocket server = null;

        try {
            server = new ServerSocket(12345);
            server.setReuseAddress(true);

            while (true) {
                Socket client = server.accept();

                System.out.println("New client connected: "
                        + client.getInetAddress()
                        .getHostAddress());

                ClientHandler clientSock = new ClientHandler(client);
                clients.add(clientSock);
                System.out.println(clients);
                new Thread(clientSock).start();

                // USUWANIE NIEPODLACZONYCH KLIENTOW
                clients.removeIf(clt -> clt.clientSocket.isClosed());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ClientHandler class
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        public PrintWriter out = null;
        public BufferedReader in = null;
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run()
        {
            try {
                // get the outputstream of client
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                // get the inputstream of client
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                if(clients.size() == 1) {
                    out.println(0);
                    numOfPlayers = Integer.parseInt(in.readLine());
                    System.out.println(numOfPlayers + String.valueOf(clients.size()));
                } else {
                    out.println((clients.size()-1)+String.valueOf(numOfPlayers));
                    in.readLine();
                }

                while(!start){Thread.onSpinWait();}
                out.println("START");

                while(!end){
                String temp = in.readLine();
                while(temp == null) temp = in.readLine();
                data.add(temp);
                sender = this;
                Thread.onSpinWait();}
            }
            catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    try {
                        in.close();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class AllSender implements Runnable {
        @Override
        public void run() {
            while(true) {
                if(data.peek()!=null) {
                    System.out.println("DATA: " + data.peek());
                    System.out.println(clients);
                }

                if (!data.isEmpty()) {
                    for (ClientHandler clt : clients) {
                        if(clt != sender) {
                            clt.out.println(data.peek());
                        }
                    }
                    data.poll();
                    sender = null;
                }

                if(clients.size() == numOfPlayers && !start)
                    start = true;
                if(clients.size() == 0)
                    start = false;

                Thread.onSpinWait();
            }
        }
    }
}