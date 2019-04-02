/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

/**
 * A class that represents part-time employees
 * @author dancye
 */
public class PartTimeEmployee 
{
        private String name;
	private double numHours;
	private double hourlyWage;
        
        public PartTimeEmployee(String givenName, double givenHours, double givenWage)
        {
            name = givenName;
            numHours = givenHours;
            hourlyWage = givenWage;
        }
        
        /**
         * Part-time employees get an extra
         * 10% of their wage to put towards
         * benefits
         * @return the pay 
         */
        public double calculatePay()
        {
            double extra = (numHours*hourlyWage)*0.1;
            return (numHours*hourlyWage)+extra;
        }
}
