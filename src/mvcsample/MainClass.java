/**
 * Overcomplicated MVC application that prints a person's details
 */
package mvcsample;

public class MainClass {
    public static void main(String[] args) {
        PersonModel person = new PersonModel("John Doe", 999); // Make the Model
        PersonView view = new PersonView(); // Instantiate the View
        PersonControl control = new PersonControl(person, view); // Instantiate the controller
        control.setName("Harry?");
        control.setAge(18);
        control.useView(); // Display everything
    } // end of main method
} // end of MainClass