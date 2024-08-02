
package payroll;
/**
 * A class that models the Payroll Application.
 * We are modeling this as an Object so we must think of
 * what would represent both the state and the behaviour of 
 * the PayRoll class.
 * Used as the starting code for ICE 5 in SYST 17796, 2018
 * @author: Liz Dancy 
 * @modified by Rohitpal Singh on (2 August 2024)
 */
import java.util.Scanner;


public class Payroll
{
 private Employee employees[] = new Employee[100];//the array to hold Employee Objects
 
 /**
  * A main method where we create an instance of the payroll
  * and then call the private run method on it.
  * We also catch our Exceptions here from the Employee
  * class.
  */
 public static void main (String[] args)
 {
   try
   {
     Payroll app = new Payroll();
     app.run();
   }
   catch (NumberFormatException e)
   {
     System.out.println("A number format is incorrect " + e.getMessage() + " Please ensure hours and wage are entered as numbers and not words");
   }
   catch(Exception e)
   {
     System.out.println("An exception was caught while trying to process employees: " + e.getMessage()); 
   }
  }//end main method

 /**
  * A private run method that prompts the user for input and
  * adds each Employee to the array.
  * Finally, we call the print method to print out the payroll
  * for each employee and the total.
  */
private void run()
{
  Scanner sc= new Scanner(System.in);
  boolean shouldContinue= true;//to keep track of whether the user wants to continue
  System.out.println("Welcome to the Payroll Application.");
  int numEmployees=0;
  while (shouldContinue)
  {
    System.out.println("Please enter the Employee's name: " );
    String name = sc.nextLine();
    System.out.println("Pleae enter the Employee's number of hours worked as a number: ");
    int numHours = Integer.parseInt(sc.nextLine());
    System.out.println("Please enter the Employee's hourly wage: " );
    double wage = Double.parseDouble(sc.nextLine());
    System.out.println("Do you want to create a manager? Type yes or no");
    String manager = sc.nextLine();
    if(manager.equals("yes"))
    {
        System.out.println("Please enter a bonus for the manager");
        double bonus = sc.nextDouble();
        Manager man = new Manager(name, numHours, wage);
        man.setBonus(bonus);
        employees[numEmployees]=man;
    }
    else
    {
        System.out.println("Do you want to create a part-time Employee?");
        String partTime = sc.nextLine();
        if(partTime.equals("yes"))
        {
            PartTimeEmployee emp = new PartTimeEmployee(name, numHours,wage);//create a new Employee with the given info
            employees[numEmployees]= emp;//add the new employee to the array
        }
    }
    
    System.out.println("Would you like to enter another employee (yes or no)?");
    String yesOrNo =sc.nextLine();
    if (yesOrNo.equalsIgnoreCase("yes"))
    {
      shouldContinue=true;
    }
    else
    {
      shouldContinue=false;
    }
    numEmployees++;
  }//done entering Employees, now print out the pay for each employee, and then the pay for all
  
  double totalPaid=0;
  for (int i=0; i<numEmployees; i++)
  {
     Object e = employees[i];
     if(e instanceof Employee)
     {
         Employee emp =(Employee)employees[i];
         emp.printStatement();
        //note that this will not work correctly with Managers!
        totalPaid+=emp.calculatePay();
     }
     else if (e instanceof PartTimeEmployee)
     {
         PartTimeEmployee emp =(PartTimeEmployee)employees[i];
         //emp.printStatement();
        //note that this will not work correctly with Managers!
        totalPaid+=emp.calculatePay();
     }
   
   Employee emp =(Employee)employees[i];
   System.out.println(emp.printStatement());
   //note that this will not work with Managers!
   totalPaid+=emp.calculatePay();
  }
  System.out.println("The total amount to be paid to all employees is "  );
  System.out.printf("%s%.2f\n", " $", totalPaid);
}


}
  


 