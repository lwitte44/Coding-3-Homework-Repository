package driver;

public class Salesman 
{
	//fields
	public String Name;
	public int Revenue;
	
	//constructor
	public Salesman (String name, int revenue)
	{
		this.Name = name;
		this.Revenue = revenue;
	}
	
	//getters
	public String getName()
	{
		return this.Name;
	}
	public int getRevenue()
	{
		return this.Revenue;
	}
	
	//display method
	public String display()
	{
		return this.Name + ": " + this.Revenue;
	}
	
	public static Salesman[] topFive(Salesman[] Sales, int topCount) 
    {

        if (Sales.length < topCount) 
        {
            topCount = Sales.length; 
        }

        Salesman[] topSalesmen = new Salesman[topCount];
        
        for (int i = 0; i < topCount; i++) 
        {
        	//starts at the end of the array -1 for starting from 0 and the minus the topCount for how many you want displayed
            topSalesmen[i] = Sales[Sales.length - 1 - i];
        }
        return topSalesmen;
    }

}
