package domprocessing;
import org.w3c.dom.*; // Import DOM classes
import javax.xml.parsers.*; // Import SAX parsers
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomExampleProcesses
{
    // Create an XML File with a given Filename
    public static void createXMLFile(String filename) {
        try {
            // Builder Setup
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // Create the root element of the XML
            Element root = document.createElement("Employees");
            document.appendChild(root); // Add root node to file

            // Create child nodes
            Element employee1 = document.createElement("Employee");
            root.appendChild(employee1);
            Element employee2 = document.createElement("Employee");
            root.appendChild(employee2);

            // Add child nodes in Employee Nodes
            Element id1 = document.createElement("ID");
            Element name1 = document.createElement("Name");
            employee1.appendChild(id1);
            employee1.appendChild(name1);

            Element id2 = document.createElement("ID");
            Element name2 = document.createElement("Name");
            employee2.appendChild(id2);
            employee2.appendChild(name2);

            // Add Content inside child nodes of Employees
            id1.appendChild(document.createTextNode("001"));
            name1.appendChild(document.createTextNode("John Doe"));
            id2.appendChild(document.createTextNode("002"));
            name2.appendChild(document.createTextNode("Jane Doe"));

            // File Saving Setup
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Add indention to the nodes
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("src/"+filename));

            // Save Created DOM into specified File
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println("Error :P");
        }
    } // end of createXMLFile method

    public static void deleteEmployee(String employeeID) {
        try {
            // Setup to Read the XML File
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("src/sample.xml"));

            NodeList children = document.getElementsByTagName("Employee"); // Store all the Employee Nodes to a list

            // Iterate and find employeeID in NodeList
            for(int i = 0; i < children.getLength(); i++) {
                Element currentNode = (Element) children.item(i); // Convert Current Employee to Element to get all the Nodes (ID, Name)
                String id = currentNode.getElementsByTagName("ID").item(0).getTextContent(); // Get the content of the ID Node in the XML
                if (currentNode.getNodeType() == Node.ELEMENT_NODE)
                    if(id.equalsIgnoreCase(employeeID)) { // If Employee ID matches given ID
                        currentNode.getParentNode().removeChild(currentNode); // Remove Entirety of Employee Node
                        break;
                    }
            }

            // Save Changes to File Setup
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // Add indention to the nodes
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("src/sample.xml"));

            // Save Updated DOM into sample.xml
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println("Error :P");
        }
    }

    public static void addEmployee(String ID, String name) {
        try {
            // Setup Reading of Document
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("src/sample.xml");

            Element root = document.getDocumentElement();

            // Create a new Employee
            Element newEmployee = document.createElement("Employee");
            root.appendChild(newEmployee);

            // Add in Details
            Element fileId = document.createElement("ID");
            Element fileName = document.createElement("Name");
            fileId.setTextContent(ID);
            fileName.setTextContent(name);
            newEmployee.appendChild(fileId);
            newEmployee.appendChild(fileName);

            // Save Changes
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("src/sample.xml"));

            // Save Changes to File
            transformer.transform(source, streamResult);
        } catch (Exception e) {
            System.out.println("Error :P");
        }
    }
} // end of DomExampleProcesses