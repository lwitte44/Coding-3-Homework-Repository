package driver;

public class SinglyLinkedListNode
{
    public SinglyLinkedListNode nextNode;
    public int payload;
    
    public SinglyLinkedListNode()
    {
        this.nextNode = null;
        this.payload = 0;
    }
    public SinglyLinkedListNode(int value)
    {
        this.nextNode = null;
        this.payload = value;
    }
    //what is the default result of ToString() of an object?
    @Override
    public String toString()
    {
    	return String.valueOf(this.payload);
    }
    
}