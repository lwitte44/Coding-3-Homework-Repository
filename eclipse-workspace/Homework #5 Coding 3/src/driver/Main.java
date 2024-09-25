package driver;

public class Main 
{
	static int count = 0;//global variable that is static
	public static void main(String[] args) 
	{
		int FibonacciInput = 10;//will give you the sum of (Input - 1) and (Input - 2)
		//displays the sum of the last two numbers of the Input amount of Fibonacci numbers
		System.out.println("Recursive Fibonacci answer for Input(" + FibonacciInput + ") is " + Fibonacci(FibonacciInput));
		System.out.println("This Recursion ran " + count + " times.");
		System.out.println("Looping Fibonacci answer for Input(" + FibonacciInput + ") is " + Fibonacci1(FibonacciInput));

	}

	//recursive
	public static int Fibonacci(int n)
	{

		if(n == 0)
		{
			return 0;
		}
		else if(n == 1)
		{
			return 1;
		}
		count = count + 1;
		return Fibonacci(n - 1) + Fibonacci(n - 2);
		
	}
	
	//looping
	public static int Fibonacci1(int n)
	{
		int counter = 0;
		if(n == 0)
		{
			System.out.println("This Loop ran " + counter + " times.");
			return 0;
		}
		
		int previous = 0;
		int current = 1;
		int next = 0;

		for (int i = 1; i < n; i++)
		{
			
			next = previous + current;
			previous = current;
			current = next;
			counter++;
			
		}
		System.out.println("This Loop ran " + counter + " times.");
		return current;
	}
}
