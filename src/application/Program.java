package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		String path = "C:\\temp\\in.txt";
		List<Employee> employeeList = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(","); 
				employeeList.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}	 
		
			Collections.sort(employeeList);
			for (Employee obj : employeeList) {
				System.out.println(obj.getName() + ", " + obj.getSalary());
			}
	    }
		catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
    }
}
