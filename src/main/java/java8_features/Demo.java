package java8_features;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo 
{
	public static void main(String[] args)
	{
		List<Employee> l = new ArrayList<>();
		
		l.add(new Employee("suresh",50000,"mech"));
		l.add(new Employee("karthik",30000,"cse"));
		l.add(new Employee("venu",20000,"civil"));
		l.add(new Employee("sree",80000,"eee"));
		l.add(new Employee("sharan",40000,"eee"));	
		
	    Map<String, List<Employee>> map = l.stream().filter(e->e.getSalary()>=40000).collect(Collectors.groupingBy(Employee::getDept));
		System.out.println(map);
	}
}