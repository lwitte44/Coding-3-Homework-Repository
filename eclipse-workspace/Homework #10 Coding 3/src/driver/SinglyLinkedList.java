package driver;

public class SinglyLinkedList
{
    public SinglyLinkedListNode header;
    public int length;//not necessary
    
    
    
    //linked list is a collection/list of nodes
    public SinglyLinkedList()
    {
        this.header = null;
        this.length = 0;
    }
    
    public int getLength()
    {
    	return this.length;//this way of doing it is 
        //can we do this without length? Yes
//        int len = 0;
//        SinglyLinkedListNode node = this.header;
//        while(node != null)
//        {
//            len++;
//            node = node.nextNode;
//        }
    }
    
    
    public boolean isEmpty()
    {
    	return this.header == null;
    }
    
    //Append: add newNode to the end of the list
    public void append(int value)
    {
    	SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
    	if (this.isEmpty())//when the list is empty
    	{
    		this.header = newNode;
    		this.length++;
    	}
    	else
    	{
    		//find the tail node
            SinglyLinkedListNode tail = this.header;
            while(tail.nextNode != null)
            {
                tail = tail.nextNode;
            }
            //make the tail node's nextNode to be the newNode 
            tail.nextNode = newNode;
            this.length++;
    	}
    }
    //Prepend: add newNode to the front of the list
  //Time Complexity: O(1)
    public void Prepend(int value)
    {
    	SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
    	//you could write this without the if and else because it does not matter 
    	//if the header is null, it will still be moved over and the header will 
    	//be replaced with the newNode.
    	if(isEmpty())
    	{
    		this.header = newNode;
    		this.length++;
    	}
    	else 
    	{
    		newNode.nextNode = this.header;
    		this.header = newNode;
    		this.length++;
    	}
    }
    //InsertAfter: insert a newNode after a given node
    //Time Complexity: O(1)
    public void InsertAfter(SinglyLinkedListNode a, int value)
    {
    	SinglyLinkedListNode b = a.nextNode;
    	SinglyLinkedListNode newNode = new SinglyLinkedListNode(value);
    	a.nextNode = newNode;
    	newNode.nextNode = b;
    	this.length++;
    }
    //Remove: remove a node from the list
    //Time Complexity: O(n)
    public boolean Remove(SinglyLinkedListNode node)
    {
    	//Several Steps:
    	//0. when this is an empty list
    	if(this.isEmpty())
    	{
    		return false;
    	}
    	else
    	{
    		if(this.header == node)
    		{
    			if(this.header.nextNode == null)
    			{
    				this.header = null;
    				this.length = 0;
    			}
    			else
    			{
    				this.header = this.header.nextNode;
    				this.length--;
    			}
    			node.nextNode = null;
    			return true;
    		}
    		else
    		{
    			SinglyLinkedListNode previous = this.header;
    			while(previous.nextNode != null)
    			{
    				if(previous.nextNode == node)
    				{
    					previous.nextNode = previous.nextNode.nextNode;
    					this.length--;
    					node.nextNode = null;
    					return true;
    				}
    			}
    			return false;
    		}
    	}
    	//1. Locate the previous node of the node
    	//2. connect the previous node to the next node
    	//3. make the node point to null
    	
    }
    //Search: return the first node that matches the value to search
    //Time Complexity: O(1)
    public SinglyLinkedListNode Search(int value)
    {
    	SinglyLinkedListNode node = this.header;
    	while(node != null)
    	{
    		if(node.payload == value)
    		{
    			return node;
    		}
    		else
    		{
    			node = node.nextNode;
    		}
    	}
    	return null;
    }
    //Print
    public void Print()
    {
    	String output = "";
    	SinglyLinkedListNode node = this.header;
    	while(node != null)
    	{
    		output = output + ", " + node;
    	}
    	output = output + ";";
    	System.out.println(output);
    }
    //PrintReverse
    //Sort
    //isEmpty
}









