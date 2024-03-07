package java8_features;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfEachCharacter
{
	public static void main(String[] args)
	{
		String s1 = "aasjjikkk";
		String s2;
		char c;
		while(s1.length()>0)
		{
			c = s1.charAt(0);
			s2 = s1.replace(c+"","");
			int count = s1.length()-s2.length();
			System.out.println(c+" ---> "+count);
			s1=s2;
		}
		System.out.println();
		
		String s3 = "suresh";
		Map<Character, Long> collect = s3.chars()
					.mapToObj(c1->(char)c1)
					.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(collect);
	}
}