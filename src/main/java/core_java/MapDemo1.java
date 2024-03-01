package core_java;

import java.util.HashMap;
import java.util.Map;

/*If two objects are equal to each other based on equals() method,then hash code must be the same.
but if the hashcode is the same,then equals() can return false;*/
public class MapDemo1 
{
	public static void main(String[] args) 
	{
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(2,"suresh");
		map.put(1,"karthik");
		System.out.println(map);
		
		
		String s1 = new String("abc");
		String s2 = new String("abc");
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put(s1,"1");
		map2.put(s2,"2");
		System.out.println(map2.size()+" "+map2);
		
		
		Map<Employee,String> map1 = new HashMap<>();
		/*
		 * e1 and e2 objects are same and employee class is override hashcode and equals
		 * method. so that while inserting the second employee,the first employee will be 
		 * overriden by second employee.
		 */
		Employee e1 = new Employee(1,"abc");
		Employee e2 = new Employee(1,"abc");
		
		System.out.println(e1.hashCode()+" "+e2.hashCode());
		
		map1.put(e1,"abc");
		map1.put(e2,"abc");
		
		System.out.println(map1.size()+" "+map1);
	}
}