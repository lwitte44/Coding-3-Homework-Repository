package driver;
import java.util.ArrayList;
import java.util.Iterator;

public class HumanBeings
{
    public ArrayList <HumanGroup> nonBelievers = new ArrayList<HumanGroup>();
    public ArrayList <HumanGroup> disciples = new ArrayList<HumanGroup>();
    public ArrayList <HumanGroup> apprentices = new ArrayList<HumanGroup>();
    public long totalPopulation;
    public long totalDisciples;
    public long totalNonBelievers;
    
    public HumanBeings()
    {
        this.apprentices = new ArrayList<HumanGroup>();
        this.disciples = new ArrayList<HumanGroup>();
        this.nonBelievers = new ArrayList<HumanGroup>();
        this.totalPopulation = 0;
        this.totalNonBelievers = 0;
        this.totalDisciples = 0;
        
    }
    
    //this function will set up the world
    public void Initiate()
    {
        this.totalPopulation = 7700000000L;
        this.totalDisciples = 13L;
        HumanGroup firstDisciples = new HumanGroup();
        firstDisciples.age = 30;
        firstDisciples.population = 13;
        firstDisciples.isDisciple = true;
        this.disciples.add(firstDisciples);
        HumanGroup allPopulation = new HumanGroup();
        allPopulation.age = 18;
        allPopulation.population = 7700000000L - firstDisciples.population;
        this.totalNonBelievers = allPopulation.population;
        this.nonBelievers.add(allPopulation);
    }
    
    //one year of the world passes
    void OneYearPass()
    {
        //all HumanGroups have babies at age 30
        long totalBabies = 0L;
        
        Iterator<HumanGroup> iApprentices = this.apprentices.iterator();
        while(iApprentices.hasNext())
        {
            HumanGroup curApprentices = iApprentices.next();
            curApprentices.Aging();
            if(curApprentices.age == 72)
            {
            	iApprentices.remove();
            	continue;
            }
            if(curApprentices.age == 30)
            {
                totalBabies = totalBabies + curApprentices.population / 2 * 2;
            }
            if(curApprentices.yearsBeingApprentice == 3)
            {
                curApprentices.isApprentice = false;
                curApprentices.yearsBeingApprentice = 0;
                curApprentices.isDisciple = true;
                iApprentices.remove();
                this.disciples.add(curApprentices);
            }
        }
        
        long totalDisciplesNum = 0L;
        Iterator<HumanGroup> iDisciples = this.disciples.iterator();
        while(iDisciples.hasNext())
        {
            HumanGroup curDisciples = iDisciples.next();
            curDisciples.Aging();
            if(curDisciples.age == 72)
            {
            	iDisciples.remove();
            	continue;
            }
            if(curDisciples.age == 30)
            {
                totalBabies = totalBabies + curDisciples.population / 2 * 2;
            }
        }
        
        long nonBelieversNum = 0;
        Iterator<HumanGroup> inonBelievers = this.nonBelievers.iterator();
        while(inonBelievers.hasNext())
        {
            HumanGroup curnonBelievers = inonBelievers.next();
            curnonBelievers.Aging();
            if(curnonBelievers.age == 72)
            {
            	inonBelievers.remove();
            	continue;
            }
            if(curnonBelievers.age == 30)
            {
                totalBabies = totalBabies + curnonBelievers.population / 2 * 2;
            }
            nonBelieversNum = nonBelieversNum + curnonBelievers.population;
        }
        
        iApprentices = this.apprentices.iterator();
        while(iApprentices.hasNext())
        {
            HumanGroup curApprentices = iApprentices.next();
            if(curApprentices.yearsBeingApprentice == 3)
            {
                curApprentices.isApprentice = false;
                curApprentices.yearsBeingApprentice = 0;
                curApprentices.isDisciple = true;
                iApprentices.remove();
                this.disciples.add(curApprentices);
            }
        }
        
        iDisciples = this.disciples.iterator();
        while(iDisciples.hasNext())
        {
            HumanGroup curDisciples = iDisciples.next();
            if(curDisciples.yearsInTeaching == 3)
            {
                curDisciples.yearsInTeaching = 0;
                curDisciples.isTeaching = false;
            }
            if(!curDisciples.isTeaching)
            {
                //disciples find nonbelievers to teach
                totalDisciplesNum = totalDisciplesNum + curDisciples.population;
                curDisciples.isTeaching = true;
            }
        }
        
        long capOfNewApprentice = totalDisciples * 2;
        inonBelievers = this.nonBelievers.iterator();
        while(inonBelievers.hasNext())
        {
            HumanGroup curNonBelievers = inonBelievers.next(); 
            if(capOfNewApprentice == 0)
            {
            	break;
            }   
            else if(curNonBelievers.population == capOfNewApprentice)
            {
            	curNonBelievers.isApprentice = true;
            	inonBelievers.remove();
            	this.apprentices.add(curNonBelievers);
            	break;
            }
            else if(curNonBelievers.population < capOfNewApprentice)
            {
            	curNonBelievers.isApprentice = true;
            	inonBelievers.remove();
            	this.apprentices.add(curNonBelievers);
            	capOfNewApprentice = capOfNewApprentice - curNonBelievers.population;
            }
            else 
            {
            	curNonBelievers.population = curNonBelievers.population = capOfNewApprentice;
            	HumanGroup newApprentices = new HumanGroup();
            	newApprentices.population = capOfNewApprentice;
            	newApprentices.age = curNonBelievers.age;
            	newApprentices.isApprentice = true;
            	this.apprentices.add(newApprentices);
            	
            }
        }
        
        //all apprentices will become disciples after 3 years of teaching
        
        if(totalBabies > 0)
        {
            HumanGroup babies = new HumanGroup();
            babies.age = 1;
            babies.population = totalBabies;
            this.nonBelievers.add(babies);
        }
    }
    
    void Report()
    {
        long totalDisciples = 0;
        for(int i = 0; i < this.disciples.size(); i++)
        {
        	totalDisciples =totalDisciples + this.disciples.get(i).population;
        	
        }
        this.totalDisciples = totalDisciples;
        
        long TotalPopulation = 0;
        this.totalNonBelievers = 0;
        TotalPopulation = TotalPopulation + totalDisciples;
        for(int i = 0; i < this.nonBelievers.size(); i++)
        {
        	TotalPopulation = TotalPopulation + this.nonBelievers.get(i).population;
        	this.totalNonBelievers = this.totalNonBelievers + this.nonBelievers.get(i).population;
        }
        for(int i = 0; i < this.apprentices.size(); i++)
        {
        	TotalPopulation = TotalPopulation + this.apprentices.get(i).population;
        }
        this.totalPopulation = TotalPopulation;
        
        System.out.println("Total population is: " + this.totalPopulation);
        System.out.println("Total population of disciples is: " + this.totalDisciples);
    }
    
}