import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

// Server class
class Server {
    static ArrayList<ClientHandler> clients;

    static ConcurrentLinkedQueue<String> data = new ConcurrentLinkedQueue<>();
    static ClientHandler sender;

    public static void main(String[] args)
    {
        AllSender send = new AllSender();
        new Thread(send).start();

        clients = new ArrayList<>();
        ServerSocket server = null;

        try {
            server = new ServerSocket(12346);
            server.setReuseAddress(true);

            while (true) {
                Socket client = server.accept();

                System.out.println("New client connected: "
                        + client.getInetAddress()
                        .getHostAddress());

                ClientHandler clientSock = new ClientHandler(client);
                clients.add(clientSock);
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

                out.println("Number: " + (clients.size()-1));

                String temp;
                while((temp = in.readLine()) != null) {
                    data.add(temp);
                    sender = this;
                }
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
                if(data.peek()!=null)
                    System.out.print(data.peek());
                if (!data.isEmpty()) {
                    for (ClientHandler clt : clients) {
                        if(clt != sender) {
                            clt.out.println(data.peek());
                        }
                    }
                    data.poll();
                    sender = null;
                }
            }
        }
    }
}