package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Pessoa> p = new ArrayList<>();
		
		System.out.print("Number of tax payers:");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <=n; i++) {
			System.out.print("Tax payer#"+i);
			System.out.print("Individual or company (i/c)?");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Annual income ");
			Double annualIncome = sc.nextDouble();
			
			switch (ch) {
			case 'i':
				System.out.print("Health expenses: ");
				Double healthExpenses = sc.nextDouble();
				p.add(new PessoaFisica(name, annualIncome, healthExpenses));
				break;
			case 'c':
				System.out.print("Employee number: ");
				int numFuncionarios = sc.nextInt();
				sc.nextLine();
				p.add(new PessoaJuridica(name, annualIncome, numFuncionarios));
				break;
			default:
				break;
			}
		}
		
		System.out.print("Taxes: ");
		double totalTax=0;
		for (Pessoa pessoa : p) {
			System.out.println(pessoa.getName()+" $ "+String.format("%.2f", pessoa.taxes()));
			totalTax+=pessoa.taxes();
		}
		System.out.println("Total Taxes: "+ totalTax);
		sc.close();
	}

}
