package java8_features;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWordInAString 
{
	public static void main(String[] args)
	{
		String s1 = "java is easy to learn";
		String[] words = s1.split(" ");
		String s3 = "";
		String finalString = ""; 
		for(int i=0;i<words.length;i++)
		{
			String word = words[i];
			for (int j = word.length()-1; j>=0; j--) 
			{
				s3 = s3+word.charAt(j);
			}
			finalString += s3+" ";
			s3 = "";
		}
		System.out.println(finalString);
		
		String string2 = Arrays.stream(s1.split(" ")).map(word -> new StringBuffer(word).reverse())
				.collect(Collectors.joining(" "));

		System.out.println(string2);
	}
}