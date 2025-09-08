Java is object oriented programming language

=================================================================================
JVM -> Java virtual machine, Every OS has it own JVM, it is platform dependent.

JRE -> (Java runtime environment)Class/packages + JVM

JDK -> Java development kit (programming lang. + debugger + compiler + JRE)
It uses compiler to compile the code (file.java) which will generate byte code (file.class). It can be shared to any
OS to generate output.

Java program ->  "Compiler" -> Byte Code -> JVM -> Machine Code -> CPU -> output

javac File.java -> compile the java source code and convert to byte code(File.class).
java File -> Execute the byte code
=================================================================================

Why only one public class in a file.java?

We should have two rules to follow,
1. The public java class name should be same as java file name.
2. The main method should be inside public class.

Hence if we have only one public class this conditions are met.
========================================================================================================

                                            Data Types/ var

=========================================================================================================

byte, short, int, long, float, double, String, char, boolean


int a = 10;
float b = 20.233f; // f is used to identify decimals as float.
double d1 = 20.232323232d; // D is used to identify decimals as double which is by default.
String s = "ADBC";
char ch = 'A';
long ll = 12121323345L; // L is used to identify integers as Long.

boolean = true;

//class names can be used as variable names
int Integer = 10; //valid Syntax
Integer int = 20; // invalid as int is a keyword.

System.out.println("%d, %.2f, %s, %c",a,b,s,ch);

"VAR"
// var keyword is used to declare local variables with inferred types.

var a = 10;
var list = new ArrayList<Integer>();

// The type of the variable must be determinable at compile-time. Therefore, the variable must be initialized at the time of declaration.
var x; // Error: cannot use 'var' on variable without initializer
x = 10;


// If you want to assign null to a var, you need to specify the type explicitly.
var str = null; // Error: variable initializer is 'null'
var str = (String) null; // OK

// var cannot be used for the parameters of lambda expressions or method references.


========================================================================================================

                                                User Input/ Exception handling

=========================================================================================================

Scanner sc = new Scanner(System.in);

int a = sc.nextInt();
String s = sc.next(); // takes string till whitespace
String ss = sc.nextLine(); // takes string till newline

public class Example {
    // throws defines that there is possibility of exception
    public void readFile(String fileName) throws FileNotFoundException {
        FileReader reader = new FileReader(fileName);
    }

    public static void main(String[] args) {
        Example example = new Example();
        try {
            example.readFile("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        System.out.println("Result: " + (a / b));
    }
}

========================================================================================================

                                        String Methods

=========================================================================================================


String -> it is immutable and non synchronized.
StringBuffer -> Mutable and synchronized
StringBuilder -> Mutable and non synchronized

String s = "ABCD";
s.length();
s.charAt(0); // s[0] not possible in java
s.toUpperCase();
s.toLowerCase();
s.trim();
s.substring(i); // from i to length();
s.substring(i,j); // [i,j)
s.replace("AB","CD");
s.replace('A', 'B');
s.startsWith("AB");
s.endsWith("CD");
s.indexOf("AB"); // first occurence of string/char from index 0 to length()
s.indexOf("AB",2) // first occurence of string/char from index 2 to length()

========================================================================================================

                                            Arrays, For Each, Variable Args, record

=========================================================================================================
int [] arr = new int[2];
int [][] mat = new int[2][3];

for(int el:arr){
    System.out.println(el);
}

int sum(int ...args){
    int res = 0;
    for(int el:args){
        res += el;
    }
    return res;
}

// Record is a class which has constructor, getter already created for it.
// Records are final classes cannot be inherited
//Any kind of method can be created using record.
// Objects of records are immutable, they don't have setters. 
record Person(String name, int age){}

========================================================================================================

                                                    Inheritance

=========================================================================================================

class Parent{
    public int a = 10;
    private int b = 20;
    
    Parent(){
        this(10); // calls the matching constructor
        System.out.println("Parent Constructor");
    }
    Parent(int b){
        this.b = b; // used as reference to object
    }

    int sum(int a, int b){ // default access specifier is public but it is package private cannot be 
                                shared within different packages. 
    }

    void exit(){
        System.out.println("Exiting Parent");
    }

    public void print(){
        System.out.println("From Parent");
    }

    public Object Hello(){
        return "";
    }

}

class Child extends Parent{
    public int c = 10;

    Child(){  // Parent class constructor is called first then derived class constructor
        super(10); // will call the constructor in parent matching this.

    }   

    @Override // The return types should be same or should be co-variant
                //  Access modifier of child should be higher or same 
                // public > protected > default > private 
    public void print(){
        System.out.println("From Child");
    }

    @Override // As string is child of Object class, we can have String in overriding method i.e. we can have any child class
                     return type of Parent class Object, even we can have Object as return type;
    public String Hello(){
        return "";
    }
   void close(){
        System.out.println("Closing Child");
    }
}


class FirsJava{
    public static void main(String [] args){ // String args include the command line args. 
        Parent p = new Parent();
        Child c = new Child();
        Parent p = new Child();
        Child c = new Parent(); // not allowed

        // For Parent p = new Child();
        p.print(); // From Child 
        p.exit(); // Exiting Parent
        p.close(); // not allowed

    }
}

========================================================================================================

                                                    Abstract Class

=========================================================================================================

abstract class Parent{
    public print(){
        System.out.println("Priting Parent");
    }

    //Abstract method -> method which is just declared without implementation
    abstract public void greet(); // needs to be overriden 
}

class Child extends Parent{

    @Override
    public void greet(){
        System.out.println("Hello from Child");
    }
}

abstarct class Child2 extends Parent{ // either implement the abstract method or declare the class as abstract
        public void bye(){
            System.out.println("bye from child2");
        }
}
// it is possible to create reference of abstract class but not object of it.
// abstrcat class can have some non-abstract methods but Interfaces not.    
========================================================================================================

                                                        Interfaces

=========================================================================================================
Group of related methods with empty bodies

public interface Animal{
    int walk = 10; // called as properties in interfaces. It is "public static final" by default
    void eats(); // it is "public abstract" by default
    public void sleeps(); // Both have same public access, eats has implicit public access and sleeps has explicit, both are same.
}


class Tiger implements Animal{
    public void eats(){ // interface methods need to be public
        System.out.println("Eats Animals");
    }
    public void sleeps(){
        System.out.println("Sleeps for 8 hrs");
    }

}

void main(){
    Tiger t = new Tiger();
    t.walk = 100; // cannot modify properties as they are final
}

*****Abstract class vs interface*****
We cannot extend multiple abstract classes but we can implement  multiple interfaces at a time.

*** Mutiple Inheritance ***

We cannot have multiple inheritance in java as two classes may have same method signature and name,
when the child class extends them we may face ambiguity, so we use interfaces to achieve this.
Interfaces can have same method name and signature but the child class defines only one method.

public interface Parent1{ // only one public interface
    void print();
}
interface Parent2{
    void print();
}

class Child implements Parent1,Parent2{
    @Override
    public void print(){
        System.out.println("For both Parent1 and Parent2");
    }
}

========================================================================================================

                                        Private/Default/Static methods in interfaces

=========================================================================================================

default methods -> An interface can have default methods which need not to be overriden by the implementing class
Private methods -> They cannot be overriden by child classes but they can be used by default methods inside interface.

public interface Animal{
    void eats();
    public void sleep();

     private void log(String message) {
        System.out.println("Log: " + message);
    }

    static void print(){ // Can we accessed directly by interface name
         System.out.println("Animal interface");
    }

    default void Shout() { // can we overriden
        log("Animal"); // private methods used in default class as private/static methods cannot not to be overriden
        System.out.println("Shouting");
    } 
}

========================================================================================================

                                        Interface Inheritance

=========================================================================================================

public interface Interface1{
    void func1();
    void func2();
}

interface Interface2 extends Interface1{ //only interface can extend interface
    void func3();
    void func4();
}

class Main implements Interface2{
        
        // Needs to implement func1,func2 as they are inherited by interface2
        void func1(){

        }
        void func2(){

        }

        void func3(){

        }
        void func4(){

        }
}

========================================================================================================

                                        Polymorphism

=========================================================================================================


interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}


class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Duck extends Animal implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck is flying.");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming.");
    }

    void quack() {
        System.out.println("Duck says quack!");
    }
}

public class Main {
    public static void main(String[] args) {
        
        Animal myAnimal = new Duck();
        myAnimal.eat(); // Output: Eating...
        // myAnimal.fly(); // This will not compile as Animal reference doesn't have fly()


        Flyable myFlyable = new Duck();
        myFlyable.fly(); // Output: Duck is flying.
        // myFlyable.swim(); // This will not compile as Flyable reference doesn't have swim()

        
        Swimmable mySwimmable = new Duck();
        mySwimmable.swim(); // Output: Duck is swimming.
        // mySwimmable.fly(); // This will not compile as Swimmable reference doesn't have fly()

        Duck myDuck = new Duck();
        myDuck.eat();   // Output: Eating...
        myDuck.fly();   // Output: Duck is flying.
        myDuck.swim();  // Output: Duck is swimming.
        myDuck.quack(); // Output: Duck says quack!
    }
}

========================================================================================================

                                        Packages

=========================================================================================================

Packages in java are used to group related classes together. 
Packages help in avoiding name conflicts.
There are two types of packages 
1. Builtin Packages (Java ApIs)
2. User defined packages (Custom Packages)

Store the similar related java files in a single folder.

java -d <path_to_create_package> *.java -> will group all the class files having same package name.

========================================================================================================

                                        Acess Modifiers

=========================================================================================================

                        Public      Private   Default    Protected 
----------------------------------------------------------------------------------
Same class               yes         yes       yes         yes
----------------------------------------------------------------------------------
Same package             yes         no        yes         yes
subclass
----------------------------------------------------------------------------------
Same package             yes         no        yes         yes 
non subclass
----------------------------------------------------------------------------------
Different package        yes         no        no          yes
subclass
----------------------------------------------------------------------------------
Different package        yes         no        no          no 
non subclass
----------------------------------------------------------------------------------
public -> everywhere
default -> only the same package
protected -> same package and other package subclasses
private -> only same class

========================================================================================================

                                    Final/ finalize Keyword / Generic Programming

=========================================================================================================
final keyword is used to declare constants, prevent inheritance, and prevent method overriding. 
It can be applied to variables, methods, and classes, each with a specific purpose:

// variable is constant
final int MAX_VALUE = 100;

// method cannot be overriden by child class
public final void display() {
    // Method code
}

// Class cannot be extended by any other class
public final class UtilityClass {
    // Class code
}

final keyword cannot be applied to contrustors as they are never overridden.

//finalize 
finalize() method is a method defined in the Object class that can be overridden 
by subclasses to perform cleanup operations before an object is garbage collected. 
The method is intended to be called by the garbage collector on an object when garbage collection 
determines that there are no more references to the object.

// Generic Programming

It is used to provide type safety in the code, If we want to create an object of specific type 
and use only methods of that type, we must follow generic programming.

class Example <T> { // <T> makes the class generic, we need to specify type while creating object.
    Object publicVar; // Object is parent of all the classes, so we can have any type for publicVar
    T myVar;
    Example(T myVar){
        this.myVar;
    }

    void print(){
        if(myVar instanceOf String){
            System.out.println("It is a string with value %s", this.myVar);
        }
        else if(myVar instanceOf Integer){
            System.out.println("It is an integer with value %d", this.myVar);
        }
    }

    //generic method
    // The return type and parameter should be K.
    public static <K> K display(K k){
        return k;
    }
}

Example<Integer> e = new Example(10);
e.print(); // It is an integer  with value 10

Example<String> e = new Example("ABCD");
e.print(); // It is String with value "ABCD"


========================================================================================================

                                Inner classes

=========================================================================================================
1. Member inner class

When we want to create a class inside another class

public class OuterClass {
    private String outerField = "Outer field value";

    public class InnerClass {
        public void display() {
            System.out.println("Outer field: " + outerField);
        }
    }
}

OuterClass outer = new OuterClass();
OuterClass.InnerClass inner = outer.new InnerClass();
inner.display();

2. Static inner class
public class OuterClass {
    private static String staticOuterField = "Static outer field value";
    private String nonStaticOuterField = "Non-static outer field value";

    public static class StaticNestedClass {
        public void display() {

            System.out.println("Static outer field: " + staticOuterField);

            // Cannot access non-static members of the outer class
            // System.out.println("Non-static outer field: " + nonStaticOuterField); // This would cause a compile-time error
        }
    }

    public static void main(String[] args) {
        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        nested.display();
    }
}

3. Local inner class

public class OuterClass {
    private String outerField = "Outer field value";

    public void outerMethod() {
        final String localVariable = "Local variable value";

        class LocalInnerClass {
            public void display() {

                System.out.println("Outer field: " + outerField);
                System.out.println("Local variable: " + localVariable);
            }
        }
        LocalInnerClass inner = new LocalInnerClass();
        inner.display();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod();
    }
}




========================================================================================================

                                Multi-Threading

=========================================================================================================
We can achieve multi-threadin by two methods interface "Runnable" and class "Thread".
The class Thread internally implements "Runnable", which has abstract run() method.


//Using Runnable interface.
class Mythread implements Runnable{
    @Override
    public void run(){

    }
}
Mythread t1 = new Mythread();
Thread t = new Thread(t1);
t.start();


//Using Thread Class
class Mythread extends Thread{
    public void run(){
        for(int i=0;i<n;i++){
            System.out.println(i+1);
            try{ // Thread.sleep() need a try catch
                Thread.sleep(2000); // milliseconds
            }catch(Exception e){

            }
        }
    }
}

Mythread t = new Mythread();
t.start(); // start() method in parent class Thread.
// Two threads will run first will be use to execute main function, 
and second for the method called by Mythread.


//Using Lambda expression
Runnable t = ()->{
    //code for run() method.
}

Thread t1 = new Thread(t);
t1.start();

// Thread methods
currentThread(); // get name of current thread
getName(); // get the thread name
setName(); // set thread name
run(); // contains task of thread
start(); // start thread by allocating resources
long getId(); // return thread id;
setPriority(),getPriority();
sleep(), join()m interrupt(), resume(), stop()

Daemon Thread is service provider thread that provides services to user thread
setDaemon(); // make thread Daemon
isDaemon(); // check if is Daemon()

Garbage collector is example of Daemon thread.


========================================================================================================

                            Producer Consumer Problem

=========================================================================================================
// the consumer should only consume the product if producer has produced it.
class Product {
    int item;
    boolean f = false;

    synchronized void produce(int item) throws Exception {
        this.item = item;
        if (f) {
            wait();
        }
        System.out.println("Producing item : " + this.item);
        f = true;
        notify();
    }

    synchronized int consume() throws Exception {
        if (!f) {
            wait();
        }
        f = false;
        notify();
        return this.item;
    }
}

class Producer extends Thread {
    Product p;

    Producer(Product p) {
        this.p = p;
    }

    public void run() {
        int i = 1;
        while (true) {

            try {
                this.p.produce(i);
                Thread.sleep(2000);
            } catch (Exception e) {

            }
        }
    }
}

class Consumer extends Thread {
    Product p;

    Consumer(Product p) {
        this.p = p;
    }

    public void run() {

        while (true) {

            try {
                System.out.println("Consumed item : " + this.p.consume());
                Thread.sleep(1000);
            } catch (Exception e) {

            }

        }
    }
}

class First {
    public static void main(String[] args) {
        Product p = new Product();
        Producer pd = new Producer(p);
        Consumer c = new Consumer(p);
        pd.start();
        c.start();
    }
}

========================================================================================================

                            Collection Framework

=========================================================================================================

Hierarchy
interface - Collection

            interface List
                        Class ArrayList // asynchronized methods
                        Class LinkedList
                        Class Stack
                        *Class Vector* //synchronized methods not used mostly
            interface Set
                        *Class EnumSet* // not used mostly
                        Class HashSet
                        Class LinkedHashSet
                        Class TreeSet
            interface Queue
                        Class ArrayDeque
                        Class LinkedList
                        Class PriorityQueue
interface Map
        Class HashMap
        Class TreeMap
        Class LinkedHashMap
        *Class EnumMap* // not used mostly
        *Class WeakHashMap* // not used mostly
        
============================================================
"List -> ArrayList, Doubly Linkedlist"

List<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.add(1);
list.size();
list.contains(20);

list.remove(1); // will remove value at index 1
list.remove(Integer.valueOf(1)); // will remove element 1

list.addAll(list2); // adds all the elements of list2 at the end
list.removeAll(list2); // remove all the elements from list1 which are present in list2
list.retainAll(list); // only intersection of list1,list2
list.clear();

"Stack" it inherites Vector class so not so efficient
Stack<Integer> st = new Stack<>();
st.push(1);
int popped = st.pop();
int top = st.peek();

"Queue"

Queue<Integer> q = new Queue<>();

q.add(1); // return error if queue is full
q.offer(1); // returns false if queue is full, no error

q.remove(); // remove and return element from front
q.poll(); // returns null if queue is empty

q.peek(); // returns null if queue is empty

"ArrayDeque"

ArrayDeque<Integer> dq = new ArrayDeque<>();
dq.offerFirst(10);
dq.offerLast(20);
dq.pollFirst();
dq.pollLast();
dq.peekFirst();
dq.peekLast();

ArrayDeque is used as Stack and Queue instead of other classes as it is fast

// Stack operations
dq.push();
dq.pop();
dq.peek();

// Queue operations
dq.offer();
dq.poll();

"PriorityQueue"

//min-heap
Queue<Integer> pq = new PriorityQueue<>();

// max heap
Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

"Set -> no duplicates"
"HashSet" stores in random order
"LinkedHashSet" stores in the order they are added 
"TreeSet" stores in sorted order


Set<Integer> st = new HashSet<>();
st.add();
st.remove();
st.clear();
st.contains();
st.size();

"Map"

HashMap -> stores in random order
TreeMap -> stores in sorted order
LinkedHashMap -> store in the order they are added

Map<Integer, String> mp = new HashMap<>();
mp.put(1,"abc");
mp.put(2,"qwqw");

mp.remove(2);
mp.containsKey(1);
mp.get(1); // value of key 1
mp.replace(1,"bcd");

ArrayList<Integer> keys = new ArrayList<>(mp.keySet()); // return set of all the keys
Collection<Integer> values = mp.values(); // returns set of all the values
Set<Map.Entry<Integer, String>> entries = mp.entrySet(); // returns set of all key/value pairs

for(Map.Entry<Integer,String> entry:entries){
    System.out.println(entry.getKey() + ", " + entry.getValue());
}

Q1 Which Data structure does HashMap represent? ->HashTable

Q2 Which Data structures are used to create HashMap in java? -> Array, LinkedList.
Working, 
mp.put(k,v); -> hash = hash(k); index = hash&(n-1);
It is the index of the array, where every element of the arrray is a linkedlist.
If there are alot of collisions, it will internally get converted to BST.

mp.get(k); -> hash = has(k); index = hash&(n-1);
Go to the index travel the LinkedList and compare the Key and return the value;
The Node of LinkedList has a structure of (Hash, Key, Value, NextAddress);

Q3 Is HashMap thread safe?-> No
Q4 What is load factor? -> It is a number which controls the re-sizing of the HashMap.

Q5 How many values does hashmap stores? -> There is no limit for it.
size() it will return integer, but mappingCount() returns long 
capacity() -> The capacity of the hashmap.

Q6 What is ConcurrentHashMap? It is thread safe hashMap.

Q7 Can we store duplicate key? No. value? Yes.


========================================================================================================

                            Lambda expression/ Method and Constructor reference / Stream Api

=========================================================================================================

Syntax
(a,b)->{ return a+b; }

"Functional Interface"
If the interface contains only one abstract method then it is functional interface
Eg:- Runnable, Callable, Comparable etc.

To call lambda we require functional interface
Lambda is used to implement functinoal interface in very simple and short manner.

Whenever we want to use an interface in main class, we need to create
another class which will implement the interface and use the object of that class in Main.

Instead we can use anonymous class. 

class MyClass{
    MyClass(){

    }
    public static void display(){
        System.out.println("function from method reference");
    }

    public void show(){
        System.out.println("function from method reference");
    }
}

Myinter obj = new Myinter() { // this is anonymous class
     @Override
    public void print(){
        System.out.println("function from interface");
    }
}

// using lambda expression as the interface is functional interface.

Myinter obj = ()->{
    System.out.println("function from interface");
};

// using lambda for Threading
Runnable thread1 = () ->{
    for(int i=1;i<=10;i++){
        System.out.println("This is thread " + i);
        try{Thread.sleep(2000);}catch(Exception e){}
    }
}
Thread t = new Thread(thread1);
t.start();

// when we want to use some other function implementation instead of creating our own
we can use method reference and if an functional interface method returns a object we can use constructor reference.

//method reference
Myinter obj = MyClass::display;
obj.print(); //function from method reference1

OR // non static method reference
MyClass c = new MyClass();
Myinter obj = c::show;
obj.print(); //function from method reference2

//Constructor reference
Myinter myinter = MyClass::new;
Myclass c = myinter.getClass(); //getClass should have return type of MyClass
c.show();


"Stream API"

ArrayList<Interger> list = Arrays.asList(6,5,42,1);

int []arr = {12,23,4,34,34};
int sum = Arrays.stream(arr).sum();

Stream<Integer> stream1 = list.stream();
or 
list.stream()
             .filter(n -> n%2==1)
             .sorted()
             .map(n -> n*n)
             .forEach(n -> System.out.println(n));
             
long value = list.stream().reduce(0, (c,e)->c+e);
List<Integer> streamlist = stream1.collect(Collection.toList());

streamlist.parallelStream() // used to run mutliprocessing operations.
========================================================================================================

                          File Handling 

=========================================================================================================
// Reading from BufferedReader
BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
String line;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
}
reader.close();

// Writing with BufferedWriter
BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
writer.write("Hello, World!");
writer.newLine();
writer.close();
========================================================================================================

                           Comparable/ Comparator

=========================================================================================================
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student>{
    private int id;
    private String name;

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.id;
    }
    Student(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override // Using comparable cannot be used for multiple comparisons.
    public int compareTo(Student st){
        return this.id-st.id;
    }

    @Override
    public String toString(){
        return "Student[id= " + id + ", name= " + name;
    }
}

class HelloWorld {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student(2,"Bhushan"));
        arr.add(new Student(1,"Bhuvan"));
        Collections.sort(arr);

        //Comparator (Can we be used to create multiple comparable methods)
        Collections.sort(arr, (st1, st2)->{
            return st1.getId() - st2.getId();
        });

        Collections.sort(arr,(st1,st2)->{
            return st2.getId()-st1.getId();
        });


        for(Student s:arr){
            System.out.println(s.getId());
        }
    }
}
=====================================================================================================
                                      CODES
=====================================================================================================

private int lowerBound(int[] nums, int start, int end,int target){
        while(start<end){
            int mid = start+ (end-start)/2;
            if(nums[mid]>=target)end = mid;
            else start = mid+1;
        }
        return start;
    }

    private int upperBound(int[] nums, int start, int end,int target){
        while(start<end){
            int mid = start+ (end-start)/2;
            if(nums[mid]>target)end = mid;
            else start = mid+1;
        }
        return start;
    }
