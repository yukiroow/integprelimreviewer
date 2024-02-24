package mvcsample;

public class PersonControl {
    private PersonModel person;
    private PersonView view;

    PersonControl(PersonModel person, PersonView view) {
        this.person = person;
        this.view = view;
    }

    public void setName(String name) {
        person.setName(name);
    }

    public void setAge(int age) {
        person.setAge(age);
    }

    public String getName() {
        return person.getName();
    }

    public int getAge() {
        return person.getAge();
    }

    public void useView() {
        view.printPersonalDetails(getName(), getAge());
    }
} // end of PersonControl class