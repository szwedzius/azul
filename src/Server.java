
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Class responsible for creating a server
 */
public class Server {

    /**
     * Default constructor
     */
    public Server() {
    }

    /**
     * Socket, on which the server will be operating and listening
     * for new connection requests
     */
    private ServerSocket serverSocket;

    /**
     * The socket, which the communication with the
     * client will go through
     */
    private Socket clientSocket;

    /**
     * Method for sending out data to the clients
     * Handled by the ClientHandler class
     */
    private void sendData() {
        // TODO implement here
    }

    /**
     * Method for receiving data from the clients
     * Handled by the ClientHandler class
     */
    private void receiveData() {
        // TODO implement here
    }

    /**
     * Class for creating new clients and maintaining
     * the connections with them (on separate threads)
     */
    public class ClientHandler extends Thread{

        /**
         * Default constructor
         */
        public ClientHandler() {
        }

        /**
         * Method for sending out data to the clients
         */
        private void sendData() {
            // TODO implement here
        }

        /**
         * Method for receiving data from the clients
         */
        private void receiveData() {
            // TODO implement here
        }

    }

}