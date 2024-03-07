package java8_features;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccuranceOfEachElementInAnArray
{
	public static void main(String[] args)
	{
		Integer[] a = {50,30,50,20,50,20,30,40,10};
		Map<Integer, Long> collect = Arrays.stream(a).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect);		
	}
}