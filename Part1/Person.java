package Part1;

public class Person {

    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }


    public static void main(String[] args) {
        Person person = new Person("Kshitij Deole", 26);
        person.displayDetails();
    }
}