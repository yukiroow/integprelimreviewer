/**
 * Run this if students.dat is not present in package
 */
package objectstreamsample;
import java.io.*;
import java.util.*;
public class ConvertObjectToBytestream
{
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(2230000, "John Doe", 18));
        list.add(new Student(2230001, "Jane Doe", 19));
        list.add(new Student(2230002, "Juan Doe", 20));

        try(
                FileOutputStream fos = new FileOutputStream("src/students.dat"); // Creates new File
                ObjectOutputStream ois = new ObjectOutputStream(fos) // Converter to Bytestream
                )
        {
            ois.writeObject(list); // Write ArrayList to File
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
} // end of sc
