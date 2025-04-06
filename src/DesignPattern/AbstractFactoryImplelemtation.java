package DesignPattern;


class AbstractFactoryImplelemtation {



    public static void main(String[] args) {

        //Create an instance of the LinuxEditorFactory

        EditorFactory factory = new LinuxEditoryFactory();
        Button button = factory.createButton();
        Menu menu = factory.createMenu();
        ScrollBarr scrollbar = factory.createScrollBar();

        button.click();
        menu.display();
        scrollbar.scrolldown();

    }


    //Component Interfaces

     public static interface Button {

        public void click();
     }

     public static interface ScrollBarr {

         public void scrolldown();

     }

     public static interface Menu {

         public void display();
     }
//Abstract Factory Interfaces
// EditorFactory is an interface that declares creation methods for each component type.
     interface EditorFactory{

        Button createButton();
        Menu createMenu();
    ScrollBarr createScrollBar();

     }

     static class LinuxButton implements Button {

         @Override
         public void click() {
             System.out.println("Linux-styled-button-clicked");
         }
     }

     static class LinuxScrollBar implements ScrollBarr {

         @Override
         public void scrolldown() {
             System.out.println("Linux-Scroller");
         }
     }

     static class LinuxMenu implements Menu {
         @Override
         public void display() {
             System.out.println("Linux-Display");
         }
     }

     //Concrete Factory

    static class LinuxEditoryFactory implements EditorFactory{
         @Override
         public Button createButton() {
             return new LinuxButton();
         }

         @Override
         public Menu createMenu() {
             return new LinuxMenu();
         }

         @Override
         public ScrollBarr createScrollBar() {
             return new LinuxScrollBar();
         }
     }
 }

 //The Abstract Factory Pattern is a creational design pattern that provides an interface for creating
// families of related or dependent objects without specifying their concrete classes.

// ->>>>>>>>>>> BENFITS <<<<<<<<<<<<<<<-

// Single Responsibility Principle
// Open/Closed Principle
// Consistency Across Components

//Encapsulation of Object Creation:
//
//Hides the complexity of object creation from the client.
//
//Clients interact with interfaces instead of directly instantiating objects.
//
//Promotes Loose Coupling:
//
//Reduces dependency on specific classes, making the system more flexible.
//
//Changes in object creation logic don’t affect client code.
//
//Ensures Consistency Among Related Objects:
//
//Ensures that a family of related objects is used together.
//
//Prevents mixing of incompatible objects.
//
//Scalability and Extensibility:
//
//Easily add new families of products by introducing new factory classes.
//
//Adapting to new requirements becomes easier.



