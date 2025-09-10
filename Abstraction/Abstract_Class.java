// Hide internal details & just show the features 

/* 
- Can be acheived via two ways :
- Abstract Class : 100% abstraction possible nahi hai
- Interfaces : 
*/

// Abstract class
abstract class Vehicle {
    abstract void start();

    // Normal method → can have implementation
    void stop() {
        System.out.println("Vehicle stopped.");
    }
}

// Concrete class Car extending Vehicle
class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with a key.");
    }
}

// Concrete class Bike extending Vehicle
class Bike extends Vehicle {
    @Override
    void start() {
        System.out.println("Bike starts with a self-start button.");
    }
}

// Main class
public class AbstractionExample {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.start();   // Car-specific implementation
        car.stop();    // Common method

        Vehicle bike = new Bike();
        bike.start();  // Bike-specific implementation
        bike.stop();   // Common method
    }
}


// Output : 

/* 
Car starts with a key.
Vehicle stopped.
Bike starts with a self-start button.
Vehicle stopped.

*/
