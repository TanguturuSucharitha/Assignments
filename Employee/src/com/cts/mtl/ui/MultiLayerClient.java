 package com.cts.mtl.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.cts.mtl.exception.EmployeeDetailsException;
import com.cts.mtl.model.EmployeeDetails;
import com.cts.mtl.model.EmployeeMenu;
import com.cts.mtl.service.ServiceInterface;
import com.cts.mtl.service.ServiceInterface2;

public class MultiLayerClient {
	
	private static ServiceInterface si;
	private static Scanner scan;
	private static DateTimeFormatter dtFormater;


	public static void main(String[] args) throws ClassNotFoundException {

		try {
			si = new ServiceInterface2();
		} catch (EmployeeDetailsException e) {
			e.printStackTrace();
		}


		scan = new Scanner(System.in);
		dtFormater = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		EmployeeMenu menu = null;

		while (menu != EmployeeMenu.QUIT) {

			System.out.println("Choice\tMenu Item");
			System.out.println("===========================");
			
			for (EmployeeMenu m : EmployeeMenu.values()) {
				System.out.println(m.ordinal() + "\t" + m.name());
			}
			System.out.print("Choice: ");
			int choice = -1;
			if (scan.hasNextInt())
				choice = scan.nextInt();
			else {
				scan.next();
				System.out.println("Please choose a choice displayed");
				continue;
			}

			if (choice < 0 || choice >= EmployeeMenu.values().length) {
				System.out.println("Invalid Choice");
			} else {
				menu = EmployeeMenu.values()[choice];
				switch (menu) {
				case ADD:
					doAdd();
					break;
				case LIST:
					doList();
					break;
				case SEARCH:
					doSearch();
					break;
				case REMOVE:
					doRemove();
					break;
				case QUIT:
					System.out.println("ThanQ Come Again!");
					break;
				}
				
			}
			}
		scan.close();
		try {
			si.persist();
		} catch (EmployeeDetailsException e) {
			e.printStackTrace();
		}
	}

		
		
		private static void doAdd() {
			try {
				EmployeeDetails emp = new EmployeeDetails();
				System.out.print("id: ");
				emp.setId(scan.next());
				System.out.print("name: ");
				emp.setName(scan.next());
				System.out.print("date(dd-MM-yyyy): ");
				String pubDtStr = scan.next();

				try {
					emp.setDoj(LocalDate.parse(pubDtStr, dtFormater));
				} catch (DateTimeException exp) {
					throw new EmployeeDetailsException("Date must be in the format day(dd)-month(MM)-year(yyyy)");
				}
				System.out.print("salary: ");
				if (scan.hasNextInt())
					emp.setSalary(scan.nextInt());
				else {
					scan.next();
					throw new EmployeeDetailsException("Price is a number");
				}

				String id = si.add(emp);
				System.out.println("employee added with id: " + id);
			} catch (EmployeeDetailsException exp) {
				System.out.println(exp.getMessage());
			}
		}

		private static void doList() {
			List<EmployeeDetails> empDetails;
			try {
				empDetails = si.getAll();
				if (empDetails.size() == 0) {
					System.out.println("No details To display");
				} else {
					for (EmployeeDetails b : empDetails)
						System.out.println(b);
				}
			} catch (EmployeeDetailsException exp) {
				System.out.println(exp.getMessage());
			}
		}

		private static void doSearch() {
			System.out.print("id: ");
			String id = scan.next();

			try {
				EmployeeDetails emp = si.get(id);
				if (emp != null) {
					System.out.println(emp);
				} else {
					System.out.println("No Such employee");
				}
			} catch (EmployeeDetailsException exp) {
				System.out.println(exp.getMessage());
			}
		}

		private static void doRemove() {
			System.out.print("id: ");
			String bcode = scan.next();
			try {
				boolean isDone = si.delete(bcode);
				if (isDone) {
					System.out.println("employee is Deleted");
				} else {
					System.out.println("No Such employee");
				}
			} catch (EmployeeDetailsException exp) {
				System.out.println(exp.getMessage());
			}
		}
		

	}


