/**
 * Connects to ObjectServer class
 */
package objectstreamsample;
import java.io.*;
import java.net.*;
import java.util.*;
public class ObjectClient {
    public static void main(String[] args) {
        int port = 2005;
        try (
            ObjectInputStream fileReader = new ObjectInputStream(
                        new FileInputStream("src/students.dat")); // File reader for students.dat
            Socket client = new Socket("localhost", port); // Socket to server
            ObjectOutputStream streamWriter = new ObjectOutputStream( // Sender of data
                    client.getOutputStream());
            ObjectInputStream streamReader = new ObjectInputStream( // Reader of data
                        client.getInputStream())
        ) {
            System.out.println("Connected to Server!");
            List<Student> students = (ArrayList<Student>) fileReader.readObject(); // Read students.dat to the students List
            System.out.println("Original List::");
            printStudents(students); // Display all students in .dat file
            streamWriter.writeObject(students); // Send students list to server
            System.out.println("---------");
            students = (ArrayList<Student>) streamReader.readObject(); // Read sorted students list
            System.out.println("New List::");
            printStudents(students); // Display sorted students list
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    } // end of main method

    private static void printStudents(List<Student> students) { // Display all the students
        int count = 0;
        for(Student student: students) {
            System.out.println("Student #" + count++);
            System.out.println(student);
        }
    } // end of printStudents
} // end of ObjectClient class