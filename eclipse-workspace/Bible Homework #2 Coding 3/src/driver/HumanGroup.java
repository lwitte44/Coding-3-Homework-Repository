package driver;


public class HumanGroup
{
    public long population;
    public int age;
    public int yearsBeingApprentice;
    public int yearsInTeaching;
    public boolean isDisciple;
    public boolean isApprentice;
    public boolean isTeaching;
    public Human humanSettings;
    
    //create blank instance of HumanGroup, will need to set variables later
    //it is not necessary to set the default value for all properties, but it is recommended to set it explicitly
    public HumanGroup ()
    {
        this.population = 0;
        this.age = 0;
        this.yearsBeingApprentice = 0;
        this.yearsInTeaching = 0;
        this.isDisciple = false;
        this.isApprentice = false;
        this.isTeaching = false;
        this.humanSettings = new Human();
    }
    
    public boolean CanBeApprentice()
    {
        return this.age >= this.humanSettings.ageAsApprentice 
        		&& !this.isApprentice 
        		&& !this.isDisciple;
    }
    
    public boolean HasBecomeDisciple()
    {
        return this.isDisciple;
    }
    
//    public boolean IsGivingBirth()
//    {
//    	this.age = this.humanSettings.ageOfGivingBirth
//    
//    }
    //fix
    public boolean CanTrainApprentice()
    {
        return this.isDisciple && this.yearsInTeaching == this.humanSettings.yearsOfApprenticeship;
    }
    
    public void Aging()
    {
        this.age++;
        
        if(this.isApprentice)
        {
            this.yearsBeingApprentice++;
        }
        if(this.isTeaching && this.isDisciple)
        {
            this.yearsInTeaching++;
        }
    }
    
    
    
    
    
    
}