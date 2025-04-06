package DesignPattern;


import java.util.ArrayList;
import java.util.List;

//Component Interface
//Defines a common interface for all objects in the
// hierarchy (both individual and composite objects)
interface OrganizationComponenet{

    //Method to display details of the componenet
    // to be implementated by both leaf and composite classes.
    void showdetails();
}
// Leaf : Represents an employee
// Implements the OrganizationComponent interface and represents and indivual object
class Employee implements OrganizationComponenet{

    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
    @Override
    public void showdetails() {

        System.out.println("Employee Name " + name  + " , Position : " + position);
    }
}

//Composite: Represents a department
// Implements the OrganizationComponent interface and
// represents a composite object containing other components.
class Department implements OrganizationComponenet{

    private String name;

    // list to store child components(either employee or sub-department)
    private List<OrganizationComponenet> componenets = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    // Adds Or Removes a component (employee and sub-department) to the department

    public void addComponent(OrganizationComponenet componenet){
        componenets.add(componenet);
    }
    public void removeComponent(OrganizationComponenet componenet){
        componenets.remove(componenet);
    }

    @Override
    public void showdetails() {
        System.out.println("Department: " + name);
        for (OrganizationComponenet componenet : componenets){
            componenet.showdetails();
        }

    }
}



public class CompositePattern {

    public static void main(String[] args) {

        //Create individual employee (leaf components)
        OrganizationComponenet emp1 = new Employee("Haseeb" , "SE");
        OrganizationComponenet emp2 = new Employee("Hamza" ,"Hard En");

        //Create a engineering Department and add empolyee to it.
        Department engineering = new Department("Engineering");
        engineering.addComponent(emp1);
        engineering.addComponent(emp2);

        OrganizationComponenet emp3 = new Employee("Khan" , "Sales Man");
        Department marketing = new Department("Marketing");
        marketing.addComponent(emp3);

        //Create a top-level department and add sub-depart
        Department headOffice = new Department("Head Office");
        headOffice.addComponent(engineering);
        headOffice.addComponent(marketing);


        //Display the enitre organization structure.
        headOffice.showdetails();

    //    Component (Interface/Abstract Class):
        // Declares common methods for leaf and composite objects.
      //  Leaf (Concrete Class): Represents individual objects.
      //  Composite (Concrete Class): Represents a group of objects,
        // implementing component methods to manipulate child objects.
       // Client: Interacts with objects using the Component interface.

        //Real Case ---->> Java Spring Boot Security


    }

}
       // The Composite Design Pattern is perfect for representing tree structures
       // where individual and composite objects need uniform treatment.
      //  By encapsulating complexity and providing flexibility, it simplifies working
       // with hierarchical structures.
