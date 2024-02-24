package objectstreamsample;
import java.io.Serial;
import java.io.Serializable;
public class Student implements Serializable
{ // An object needs to be serializable before it can be passed
    @Serial
    private static final long serialVersionUID = 7809412324348391305L; // To match the
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age;
    }

    public int getId() {
        return id;
    }
} // end of Student