/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

/**
 * A class that represents part-time employees
 * @author dancye
 * @modified by Rohitpal Singh on (2 August 2024)
 */
public class PartTimeEmployee extends Employee
{
     
        
        public PartTimeEmployee(String givenName, double givenHours, double givenWage)
        {
            super(givenName, givenHours,givenWage);
        }
        
        /**
         * Part-time employees get an extra
         * 10% of their wage to put towards
         * benefits
         * @return the pay 
         */
        public double calculatePay()
        {
            double extra = (getHours()*getHourlyWage())*0.1;
            return (getHours()*getHourlyWage())+extra;
        }
}
