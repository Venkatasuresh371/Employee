package java8_features;

import java.util.Arrays;

public class LastElementInAnArray
{
	public static void main(String[] args) 
	{
		String[] a = {"suresh","karthik","venu","sree","vamsi","sai"};
		String string = Arrays.stream(a).skip(a.length-1).findFirst().get();
		String string2 = Arrays.stream(a).findAny().get();
		System.out.println(string);
		System.out.println(string2);
	}
}