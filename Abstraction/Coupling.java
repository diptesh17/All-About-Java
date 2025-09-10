// Coupling : how much two classes depend on each other
// Tight : One class is directly dependent on another
// Loosely : classes depend on abs classes / interfaces instead of concrete implementations

// Tightly Coupled : 
// Directly dependent on specific classes
class Game {
    private Mario mario;   // tightly coupled with Mario

    public Game() {
        mario = new Mario(); // Game is forced to use Mario
    }

    public void play() {
        mario.jump();
        mario.run();
    }
}

class Mario {
    void jump() {
        System.out.println("Mario jumps!");
    }
    void run() {
        System.out.println("Mario runs!");
    }
}

// Main
public class TightCouplingExample {
    public static void main(String[] args) {
        Game game = new Game();
        game.play(); // Works only with Mario
    }
}



// Loosely Coupled : ( good design with abstraction ) 

// Abstraction (Interface)
interface Character {
    void jump();
    void run();
}

// Mario implements Character
class Mario implements Character {
    public void jump() {
        System.out.println("Mario jumps!");
    }
    public void run() {
        System.out.println("Mario runs!");
    }
}

// Sonic implements Character
class Sonic implements Character {
    public void jump() {
        System.out.println("Sonic jumps higher!");
    }
    public void run() {
        System.out.println("Sonic runs super fast!");
    }
}

// Contra implements Character
class Contra implements Character {
    public void jump() {
        System.out.println("Contra does a power jump!");
    }
    public void run() {
        System.out.println("Contra runs with a gun!");
    }
}

// Game depends on abstraction, not concrete classes
class Game {
    private Character character;

    // Constructor injection → Game doesn’t care which character
    public Game(Character character) {
        this.character = character;
    }

    public void play() {
        character.jump();
        character.run();
    }
}

// Main
public class LooseCouplingExample {
    public static void main(String[] args) {
        Game game1 = new Game(new Mario());
        game1.play();

        Game game2 = new Game(new Sonic());
        game2.play();

        Game game3 = new Game(new Contra());
        game3.play();
    }
}
