package DesignPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SingletonClass implements Cloneable {

     //static variable to hole the single instance of the class.
     //using vulatile to ensure visibility of changes to instances acroos threads in multithraeding env.
     private static volatile SingletonClass instance;


     //private constructor to prevent instantiation from outside
     private SingletonClass() {
         System.out.println("singleton instance created");
     }

     //static method to get the single instance of the class
     public static SingletonClass getInstance() {

         // Prevent reflection
         if (instance != null) {
             throw new RuntimeException("Use getInstance() to create Singleton");
         }
         System.out.println("Fetching instance");
         return instance;
     }

//     In Java, cloning creates a duplicate object using the clone() method from the Object class. However,
//     cloning can break the Singleton Pattern by creating multiple instances,
//     violating its core principle of having only one instance.
//     Solution: Prevent Cloning in Singleton
//     Override the clone() method to prevent cloning:

//    When readResolve is used, the deserialized object is replaced by the existing instance,
//    maintaining Singleton behavior.

    // Ensures the same instance during deserialization

//    Serializable and Deserializable Concepts in Java
//    Serialization and deserialization are mechanisms in Java to convert objects to byte streams and recreate objects
//    from byte streams. They are essential for tasks like saving object states,
//    deep cloning, and data transfer over networks.

    protected Object readResolve() {
        return getInstance();
    }

     @Override
     protected Object clone() throws CloneNotSupportedException {
         throw new CloneNotSupportedException("Cloning not allowed for Singleton");
     }


 }


 //enum implementatioon for singleton
// Enums are classes in disguise with additional features, including fields, methods, and constructors.
enum Singleton{
    INSTANCE;

    public void showMessage(){
        System.out.println("Hello from Singleton!");
    }
}

 public class SingletonPatternExample {

     public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


         Singleton singleton = Singleton.INSTANCE;
         singleton.showMessage();
         // Using Reflection to create a new instance
//         Constructor<SingletonClass> constructor = SingletonClass.class.getDeclaredConstructor();
//         constructor.setAccessible(true); // Breaks private access
//         SingletonClass instance2 = constructor.newInstance();
         SingletonClass singletonClass = SingletonClass.getInstance();

         System.out.println("Instance 1 HashCode: " + singletonClass.hashCode());
         System.out.println("Instance 2 HashCode: " + singletonClass.hashCode());

     }
 }

//Best Practice: Use Enum for Singleton
//Java Enums are the most effective way to create Singleton instances,
//        preventing reflection, cloning, and serialization attacks.


//Why Enum is Best for Singleton:
//Reflection-Proof: Enums cannot be instantiated using reflection.
//
//Serialization-Safe: JVM ensures single instance during deserialization.
//
//Thread-Safe by Default: Enum constants are inherently thread-safe.