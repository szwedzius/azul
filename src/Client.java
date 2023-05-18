import java.io.*;
import java.net.*;

// Client class
class Client {

    private String address;
    private int port;
    private PrintWriter out;
    private BufferedReader in;
    private Socket socket = null;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }
    public void start() throws IOException {
        socket = new Socket(address, port);
        // writing to server
        out = new PrintWriter(socket.getOutputStream(), true);
        // reading from server
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendData(String mess) {
        out.println(mess);
        out.flush();
    }

    public String receiveData() throws IOException {
        return in.readLine();
    }

    public void end() throws IOException {
        if(socket != null)
            socket.close();
    }
    // driver code
    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 12346);
        client.start();
        System.out.println("Server:: " + client.receiveData()); // number
        System.out.println("Server:: " + client.receiveData()); // info od innych
        client.sendData("test");
        client.end();
    }
}