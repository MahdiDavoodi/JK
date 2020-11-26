package ir.blog.mahdidavoodi;

/*
 * An example for creating a simple generic class.
 * */

class Student<E extends String> {
    private E firstName, lastName;

    public Student(E firstName, E lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public E getFirstName() {
        return firstName;
    }

    public E getLastName() {
        return lastName;
    }
}

public class MyGenericClass {
    public static void main(String[] args) {
        Student<String> student = new Student<>("Mahdi", "Davoodi");
        System.out.println("Hello " + student.getFirstName() + "!");
    }
}
