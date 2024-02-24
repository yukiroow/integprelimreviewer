/**
 * Client App for SampleServer class in the same package
 */
package characterstreamsample;
import java.util.Scanner;
import java.io.*;
import java.net.*;
public class SampleClient
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 2005; // Must be same port as SampleServer
        try (
            Socket client = new Socket("localhost", port);
            BufferedReader reader = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(client.getOutputStream()))
        ) {
            System.out.println(reader.readLine()); // Read the "Tell me your name" message
            writer.write(sc.nextLine() + "\n"); // Write the keyboard input to Server
            writer.flush(); // Clean the writer
            System.out.println(reader.readLine()); // Read the "How about your age" message
            writer.write(sc.nextLine() + "\n"); // Write the keyboard input to Server
            writer.flush(); // Clean the writer
            System.out.println(reader.readLine()); // Read the "Your name is <>, <> years old" message
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    } // end of main method
} // end of SampleClient class