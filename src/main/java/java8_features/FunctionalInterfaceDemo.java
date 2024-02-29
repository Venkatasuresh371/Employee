package java8_features;

@FunctionalInterface
interface FunctionalInterface1
{
	public void am();
	
	public static void sm()
	{
		System.out.println("Static method from FunctionalInterface1");
	}
	
	public default void dm()
	{
		System.out.println("Default method from FunctionalInterface1");
	}
}
class FunctionalInterface1Impl implements FunctionalInterface1
{
	@Override
	public void am() 
	{
		System.out.println("Overriden abstract method from FunctionalInterface1");
	}
}
public class FunctionalInterfaceDemo
{
	public static void main(String[] args)
	{
		//create separate class and implements functional interface
		FunctionalInterface1 impl = new FunctionalInterface1Impl();
		impl.am();
		impl.dm();
		FunctionalInterface1.sm();
		
		//Anonymous Class
		FunctionalInterface1 interface1 = new FunctionalInterface1() 
		{
			@Override
			public void am()
			{
				System.out.println("Overriden method from FunctionalInterface1");
			}
		};
		interface1.am();
		interface1.dm();
		FunctionalInterface1.sm();
		
		
		//Lambda Expressions
		FunctionalInterface1 interface2 = ()->System.out.println("Overriden method from FunctionalInterface1");
		interface2.am();
		interface2.dm();
		FunctionalInterface1.sm();
	}
}