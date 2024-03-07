package java8_features;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigitsInANumber 
{
	public static void main(String[] args) 
	{
		int n = 3477358;
		int temp = n;
		int sum = 0;
		while(temp!=0)
		{
			int rem = temp%10;
			sum = sum+rem;
			temp/=10;
		}
		System.out.println("Sum of digits of a number "+n+" is : "+sum);
		
		System.out.println();
		
		Integer sum1 = Stream.of(String.valueOf(n).split(""))
		.collect(Collectors.summingInt(Integer::parseInt));
		
		System.out.println("Sum of digits of a number "+n+" is : "+sum1);
	}
}