package JavaSE_Senior.DesignPattern.JavaCodes.behavioral;

import java.util.ArrayList;
import java.util.List;

public class Iterator {

	public static void main(String[] args) {
		IEmployees employees = new Employees();
		employees.add("Jack", 24, 8000);
		employees.add("Peter", 25, 9000);
		employees.add("Lerned", 26, 10000);
		employees.add("Sheradon", 27, 11000);
		employees.add("Fuck", 28, 12000);
		EmployeeIterator iterator = employees.iterator();
		while(iterator.hasNext()){
			Employees employee = iterator.next();
			System.out.println(employee.getEmployeesInfo());
		}
		
	}

}

interface IEmployees{
	void add(String name,int age,int salary);
	String getEmployeesInfo();
	EmployeeIterator iterator();
}


class Employees implements IEmployees{
	private String name;
	private int age;
	private int salary;
	private List<Employees> employeesList = new ArrayList<>();

	public Employees(){

	}

	private Employees(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public void add(String name, int age, int salary) {
		Employees employees = new Employees(name,age,salary);
		employeesList.add(employees);
	}

	@Override
	public String getEmployeesInfo() {
		String str = "员工："+ this.name +", 年龄："+ this.age+", 薪水："+this.salary;
		return str;
	}

	@Override
	public EmployeeIterator iterator() {
		return new EmployeeIterator(employeesList);
	}

}

class EmployeeIterator implements java.util.Iterator<Employees>{
	private List<Employees> employeesList;
	private int currentItem = 0;
	public EmployeeIterator(List<Employees> employeesList) {
		this.employeesList = employeesList;
	}

	@Override
	public boolean hasNext() {
		boolean hasNext = true;
		if(currentItem >= employeesList.size() || employeesList.get(this.currentItem) == null){ 
			hasNext =false;
		}
		return hasNext;
	}

	@Override
	public Employees next() {
		return employeesList.get(currentItem++);
	}

}