/**
 * CONNECT TO THIS CLASS USING TELNET or SampleClient class

 * For Telnet:
 * Open CMD
 * type: telnet localhost [port]
 */
package characterstreamsample;
import java.io.*;
import java.net.*;
public class SampleServer {
    public static void main(String[] args) {
        int port = 2005;
        // Perform a try-with-resources
        try (
            ServerSocket serverSocket = new ServerSocket(port); // Server Socket
            Socket client = serverSocket.accept(); // Telnet Client
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(client.getInputStream())); // Reads input from Telnet
            PrintWriter writer = new PrintWriter(
                    client.getOutputStream(), true) // Writes messages to Telnet
        ) {
            writer.println("Tell me your name."); // Send a message to the client
            String name = reader.readLine(); // Read message from client
            writer.println("How about your age."); // Send a message to the client
            int age = Integer.parseInt(reader.readLine()); // Convert message form client to an integer
            writer.println("You are " + name + ", " + age + " years old."); // Send final message to client
        } catch (IOException e) {
            System.out.println("Error :P");
        }
        System.exit(0);
    } // end of main method
} // end of SampleServer class