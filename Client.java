import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        // Server details
        String serverAddress = "127.0.0.1"; // Localhost
        int port = 12345;

        try {
            // Connect to the server
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected to server: " + serverAddress);
            
            // Input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            // Send message to server
            System.out.println("Enter message to send to server:");
            String message = input.readLine();
            output.println(message);
            
            // Receive response from server
            String response = serverInput.readLine();
            System.out.println("Server response: " + response);
            
            // Close connections
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
