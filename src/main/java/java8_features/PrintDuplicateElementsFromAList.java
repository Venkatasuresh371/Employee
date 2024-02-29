package java8_features;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrintDuplicateElementsFromAList
{
	public static void main(String[] args)
	{
		List<String> listOfStrings = Arrays.asList("Java","Python","Python","C#","Java","C#","Kotlin", "Python");
		
		Set<String> duplicateStrings = listOfStrings.stream()
		.filter(i->Collections.frequency(listOfStrings,i)>1)
		.collect(Collectors.toSet());
		
		System.out.println(duplicateStrings);
	}
}