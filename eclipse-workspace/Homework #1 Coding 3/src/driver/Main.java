package driver;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Salesman John = new Salesman("John", 101);
		Salesman Billy = new Salesman("Billy", 1100);
		Salesman Nick = new Salesman("Nick", 100);
		Salesman James = new Salesman("James", 300);
		Salesman Dom = new Salesman("Dom", 1101);
		Salesman Trevor = new Salesman("Trevor", 80);
		Salesman Josh = new Salesman("Josh", 500);
		//int topSalesmanNum = 5;
		Salesman[] allSales = new Salesman[] {John, Billy, Nick, James, Dom, Trevor, Josh};
		bubbleSort(allSales);
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of top salesmen to display (max 5): ");
        int userInputCount = scanner.nextInt();
        
        if (userInputCount < 1 || userInputCount > 5) 
        {
            System.out.println("Invalid input. Displaying top 5 salesmen instead.");
            userInputCount = 5;
        }
        
        Salesman[] topSalesmen = Salesman.topFive(allSales, userInputCount);
        
        
        System.out.println("Top Salesmen:");
        for (Salesman salesman : topSalesmen) 
        {
            System.out.println(salesman.display());
        }
        
        scanner.close();
		
	    //Salesman[] topSalesmen = Salesman.topFive(allSales, topSalesmanNum);
		//Salesman[] topFiveSalesman = new Salesman[] {Salesman.topFive(allSales, topSalesmanNum)};
		//allSales.topFive(allSales, topSalesmanNum);
        /*
		for (Salesman salesman : allSales)
		{
			System.out.println(salesman.display());
		}
		*/
	}
	
	public static void bubbleSort(Salesman[] Sales) 
    {
		
		int S = Sales.length;
	
		for (int i = 0; i < S - 1; i++) 
		{
			for (int j = 0; j < S - i - 1; j++) 
			{
				if (Sales[j].getRevenue() > Sales[j + 1].getRevenue()) 
				{
					Salesman temp = Sales[j];
					Sales[j] = Sales[j + 1];
					Sales[j + 1] = temp;
				}
			}
		}
    }
}
