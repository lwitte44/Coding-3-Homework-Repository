package driver;

public class Main 
{

	public static void main(String[] args) 
	{
		String input = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(AllUniqueChar(input));

	}
	
	public static boolean AllUniqueChar(String input)
	{
		for (int i = 0; i < input.length(); i++)
		{
			for (int j = i + 1; j < input.length(); j++)
			{
				if (input.charAt(i) == input.charAt(j))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean AllUniqueChar_1(String input)
	{
		char[] box = new char[100];
		int count = 0;
		for (int i = 0; i < input.length(); i++)
		{
			for (int j = i + 1; j < input.length(); j++)
			{
				if (input.charAt(i) == input.charAt(j))
				{
					return false;
				}
				else
				{
					box[count] = input.charAt(i);
					count++;
				}
			}
		}
		return true;
	}

}
