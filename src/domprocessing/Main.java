/**
 * DOM Processing Examples
 */
package domprocessing;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Create DOM:");
        DomExampleProcesses.createXMLFile("sample.xml"); // Invoke this first to Create XML file
        //System.out.println("Delete Employee 002:");
        //DomExampleProcesses.deleteEmployee("002"); // Deletes Employee 002
        //System.out.println("Add Employee 002 back:");
        //DomExampleProcesses.addEmployee("002","Jane Doe"); // Adds back Employee 002
    } // end of main method
} // end of Main class
