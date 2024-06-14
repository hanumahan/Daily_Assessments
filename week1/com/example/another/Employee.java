package week1.com.example.another;

import week1.com.example.person.Person;

public class Employee extends Person {
    public void displayDetails() {
        // setName is public, so it can be accessed
        setName("praveen kumar");

        // age is protected, so it can be accessed within a subclass
        setAge(23);

        // address is package-private, cannot be accessed in a different package
        // setAddress("123 Main St"); // This line would cause a compile error
    }
}