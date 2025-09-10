// Interface
interface Animal {
    void sound(); // abstract method by default
    void eat();
}

// Implementing class Dog
class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
    public void eat() {
        System.out.println("Dog eats bones");
    }
}

// Implementing class Cat
class Cat implements Animal {
    public void sound() {
        System.out.println("Cat meows");
    }
    public void eat() {
        System.out.println("Cat drinks milk");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.eat();

        Animal cat = new Cat();
        cat.sound();
        cat.eat();
    }
}

/* Output :
Dog barks
Dog eats bones
Cat meows
Cat drinks milk
*/


