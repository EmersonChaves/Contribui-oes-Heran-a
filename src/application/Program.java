
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		
		for (int i =0; i<n; i++) {
			System.out.println("Tax payer #" + (i+1) + " data:");
			System.out.print("Individual or company (i/c): ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double income = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double health = sc.nextDouble();
				TaxPayer tax = new Individual(name, income, health);
				list.add(tax);
			}
			else {
				System.out.print("Number of employees: ");
				int numberEmployees = sc.nextInt();
				TaxPayer tax = new Company(name, income, numberEmployees);
				list.add(tax);		
			}
		}	
		
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		double sum = 0;
		for(TaxPayer x : list) {
			System.out.println( x.getName() + ": $ " + String.format("%.2f", x.tax()));
			sum += x.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		

		
		sc.close();
	}

}
