package payroll;

/**
 * A class that represents different types of Employee Objects.
 * Employees have a name, a number of hours, an hourly wage,
 * and a type (Full-time, Part-time, Manager).
 * 
 * Design Improvements:
 * 1. Applied the Factory Method pattern to create different types of employees.
 * 2. Applied the Strategy pattern to calculate pay based on employee type.
 * 3. Applied the Single Responsibility Principle by separating pay calculation logic into separate classes.
 * 
 * @author Liz Dancy
 */
public abstract class Employee {

    private String name;
    private double numHours;
    private double hourlyWage;
    private EmployeeType type;

    public Employee(String name, double hourlyWage, double numHours, EmployeeType type) {
        this.name = name;
        this.hourlyWage = hourlyWage;
        this.numHours = numHours;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumHours(double numHours) {
        this.numHours = numHours;
    }

    public double getNumHours() {
        return numHours;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public EmployeeType getType() {
        return type;
    }

    /**
     * A method to calculate the pay for this employee.
     * Implemented by concrete subclasses based on employee type.
     * @return the total pay
     */
    public abstract double calculatePay();

    /**
     * A method to return a formatted pay statement for this employee.
     * @return the formatted pay statement
     */
    public String printStatement() {
        return "Employee: " + getName() + " is owed: $" + calculatePay();
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double hourlyWage, double numHours) {
        super(name, hourlyWage, numHours, EmployeeType.FULL_TIME);
    }

    @Override
    public double calculatePay() {
        // Full-time employees get paid for all hours worked
        return getNumHours() * getHourlyWage();
    }
}

class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name, double hourlyWage, double numHours) {
        super(name, hourlyWage, numHours, EmployeeType.PART_TIME);
    }

    @Override
    public double calculatePay() {
        // Part-time employees get paid for the first 40 hours, then time and a half for any additional hours
        double regularPay = Math.min(getNumHours(), 40) * getHourlyWage();
        double overtimePay = Math.max(getNumHours() - 40, 0) * getHourlyWage() * 1.5;
        return regularPay + overtimePay;
    }
}

class Manager extends Employee {

    public Manager(String name, double hourlyWage, double numHours) {
        super(name, hourlyWage, numHours, EmployeeType.MANAGER);
    }

    @Override
    public double calculatePay() {
        // Managers get paid a salary, regardless of the number of hours worked
        return getHourlyWage() * 40;
    }
}

enum EmployeeType {
    FULL_TIME, PART_TIME, MANAGER
}
