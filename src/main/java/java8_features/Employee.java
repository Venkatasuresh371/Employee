package java8_features;

import java.util.Objects;

public class Employee
{
	private String name;
	private double salary;
	private String dept;
	
	public Employee(String name, double salary, String dept) 
	{
		super();
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept, name, salary);
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", dept=" + dept + "]";
	}
}