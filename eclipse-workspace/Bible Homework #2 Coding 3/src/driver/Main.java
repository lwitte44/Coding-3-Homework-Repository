package driver;

public class Main {

	public static void main(String[] args) 
	{
		HumanBeings earth = new HumanBeings();
		earth.Initiate();
		int year = 2024;
		System.out.println("Game starts at year: " + year);
		boolean end = false;
		while(!end)
		{
			year++;
			System.out.println("One year passed. Game is at year: " + year);
			earth.OneYearPass();
			earth.Report();
			if(earth.totalDisciples > earth.totalNonBelievers)
			{
				end = true;
			}
			
		}

	}

}
