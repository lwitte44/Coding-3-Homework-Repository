package driver;

public class Human extends Object
{
    public int maxAge;
    public int ageAsApprentice;
    public int yearsOfApprenticeship;
    public int ageOfGivingBirth;
    public int capOfApprentice;
    public int capOfBaby;
    
    //you could define each variable when you contruct an instance, but theres no need in this case because they are constant
    public Human ()
    {
        this.maxAge = 72;
        this.ageAsApprentice = 18;
        this.yearsOfApprenticeship = 3;
        this.ageOfGivingBirth = 30;
        this.capOfApprentice = 2;
        this.capOfBaby = 2;
    }
}