package java8_features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrderTheList
{
	public static void main(String[] args)
	{
		List<Integer> list = List.of(40,30,20,70,10,60);	
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println();
		list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		System.out.println();
		Integer[] a = {40,20,50,10,90};
		Arrays.sort(a);
		for (Integer integer : a)
		{
			System.out.println(integer);
		}
	}
}