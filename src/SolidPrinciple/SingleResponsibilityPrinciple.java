package SolidPrinciple;


 class Employee {
    private String name;
    private double salary;

    // Getter and setter methods
}

 class SalaryCalculator {
    public void calculateSalary(Employee employee) {
        // Salary calculation logic
    }
}

 class ReportGenerator {
    public void generateReport(Employee employee) {
        // Report generation logic
    }
}

 class EmployeeRepository {
    public void save(Employee employee) {
        // Database interaction logic
    }
}
// Each class now has a single responsibility:
//
// Employee: Holds employee data
//
// SalaryCalculator: Handles salary calculation
//
// ReportGenerator: Generates reports
//
// EmployeeRepository: Manages database interactions

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {

    }
}
