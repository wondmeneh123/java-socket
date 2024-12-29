import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        // Port number the server will listen on
        int port = 12345;
        
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            
            // Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
            
            // Input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            
            // Communication with the client
            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Received: " + message);
                output.println("Echo: " + message); // Send back the same message
            }
            
            // Close connections
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
