package application;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class ComposicaoApp {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		Department dp = new Department(department);	// department instanciado
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Level: ");
		String level = sc.next();
		WorkerLevel wl = WorkerLevel.valueOf(level);
		
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
				
		Worker w = new Worker(name,wl,baseSalary,dp);	// worker instanciado
		
		System.out.print("How many contracts to this worker? ");
		int numberContracts = sc.nextInt();
		
		for (int i = 0; i < numberContracts; i++) {
			System.out.println();
			System.out.println("Enter contract #" 
			+ (i + 1) 
			+ " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			String date = sc.next();
			Date d =new  Date();		// por enquanto fazer assim
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int duration = sc.nextInt();
			
			w.addContract(new HourContract(d,valuePerHour,duration));	
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY: ");
		String dateToSum = sc.next();
		
		// vai chamar o imcome()
		System.out.println("Name: " + name);
		System.out.println("Department: " + department);
		System.out.println("Income for " 
		+ dateToSum 
		+ ": "); // vai chamar o imcome()
		
		
		sc.close();

	}

}
