/**
 * Server for ObjectClient class
 */
package objectstreamsample;
import java.net.*;
import java.io.*;
import java.util.*;
public class ObjectServer {
    public static void main(String[] args) {
        int port = 2005;
        try (
            ServerSocket server = new ServerSocket(port); // Server Socket
            Socket client = server.accept(); // Instance of Client Socket
            ObjectOutputStream writer = new ObjectOutputStream(
                    client.getOutputStream());
            ObjectInputStream reader = new ObjectInputStream(
                    client.getInputStream())
        ) {
            System.out.println("Client Connected!");
            List<Student> list = (ArrayList<Student>) reader.readObject(); // Get Student list from Client
            list.sort(Comparator.comparing(Student::getId).reversed()); // Sort List according to ID Number
            writer.writeObject(list);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    } // end of main method
} // end of ObjectServer class