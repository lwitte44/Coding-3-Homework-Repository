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
    public void Append(int value)
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
    				else
    				{
    					previous = previous.nextNode;
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
    	System.out.println(this);
    }  
    @Override
    public String toString()
    {
    	if(this.isEmpty())
    	{
    		System.out.println("(0){empty}");
    	}
    	SinglyLinkedListNode node = this.header;
    	String output = "Length: (" + this.getLength() + ")" + " The List: {" + node;
    	node = this.header.nextNode;
    	while(node != null)
    	{
    		output = output + ", " + node;
    		node = node.nextNode;
    	}
    	output = output + "}";
    	return output;
    }
    //PrintReverse
    public void PrintReverse()
    {
    	if(this.isEmpty())
    	{
    		System.out.println("(0){empty}");
    	}
    	SinglyLinkedListNode node = this.header;
    	String output = node.toString();//1
    	node = this.header.nextNode;
    	while(node != null)
    	{
    		output = node + " < " + output;
    		node = node.nextNode;
    	}
    	//output is "3 < 2 < 1" -> "(3){3 < 2 < 1}"
    	//string format template is "(%d){%s}"
    	System.out.println("[Reversed] Length: " + String.format("(%d)", this.getLength())
    					+ " List: " + String.format("{%s}", output));
    }
    public void Swap(SinglyLinkedListNode pre_a, SinglyLinkedListNode a, SinglyLinkedListNode pre_b, SinglyLinkedListNode b) 
    {
        if (a == b) 
        {
        	return; // No need to swap identical nodes
       	}

        // Link previous nodes to swapped nodes
        if (pre_a != null) 
        {
        	pre_a.nextNode = b;
        }
        if (pre_b != null) 
        {
        	pre_b.nextNode = a;
       	}

        // Swap next pointers of a and b
        SinglyLinkedListNode temp = a.nextNode; // Store the next node of a in temp
        a.nextNode = b.nextNode; // Point a to b's next node
        b.nextNode = temp; // Point b to temp (originally a's next node)
    }

    public void Sort(boolean ascending) {
        if (this.header == null) return; // List is empty

        boolean swapped; 
        do {
            swapped = false; 
            SinglyLinkedListNode current = this.header; 
            SinglyLinkedListNode prev = null; 

            // Traverse the list
            while (current != null && current.nextNode != null) {
                SinglyLinkedListNode next = current.nextNode; 
                // Determine if a swap is needed based on ascending boolean
                boolean shouldSwap = ascending ? (current.payload > next.payload) : (current.payload < next.payload);

                if (shouldSwap) {
                    Swap(prev, current, current, next); // Swap nodes
                    swapped = true; // Set swapped flag to true
                    // Update header if the first node is involved in the swap
                    if (prev == null) {
                        this.header = next; 
                    }
                    prev = next; 
                } else {
                    prev = current; 
                    current = next; 
                }
            }
        } while (swapped); // Repeat until no more swaps are made
    }

    
    
    
    
//    //Swap
//    public void Swap(SinglyLinkedListNode pre_a, SinglyLinkedListNode a, SinglyLinkedListNode pre_b, SinglyLinkedListNode b)
//    {
//    	SinglyLinkedListNode tempNode = new SinglyLinkedListNode();
//    	pre_a.nextNode = b;
//    	pre_b.nextNode = a;
//    	a.nextNode = tempNode;
//    	a.nextNode = b.nextNode;
//    	b.nextNode = tempNode;
//    }
//    //Sort
//    public void Sort(boolean ascending)//insert false or true when calling the function to say either ascending or descending
//    {
//    	SinglyLinkedListNode node = new SinglyLinkedListNode();
//    	//how?
//    	//BubbleSort -> compare neighbor nodes, sort them, move on to next node
//    	if(ascending == true)
//    	{
//    		System.out.println("The list will be sorted ascending");
//    		node = this.header;
//        	while(node != null)
//        	{
//        		if(node.nextNode == null)
//        		{
//        			break;
//        		}
//        		else if(node == this.header && node.payload < node.nextNode.payload)
//        		{
//        			System.out.println("Starting swap... Current Node: " + node.payload + " Next Node: " + node.nextNode.payload);
//        			SinglyLinkedListNode tempNode = new SinglyLinkedListNode();
//        			node.payload = tempNode.payload;
//        			node.payload = node.nextNode.payload;
//        			node.nextNode.payload = tempNode.payload;
//        			System.out.println("Starting swap... Current Node: " + node.payload + " Next Node: " + node.nextNode.payload);
//        			node = node.nextNode;
//        		}
//        		else if (node.payload < node.nextNode.payload)
//        		{
//        			System.out.println("Starting swap... Current Node: " + node.payload + " Next Node: " + node.nextNode.payload);
//        			SinglyLinkedListNode tempNode = new SinglyLinkedListNode();
//        			node.payload = tempNode.payload;
//        			node.payload = node.nextNode.payload;
//        			node.nextNode.payload = tempNode.payload;
//        			System.out.println("Starting swap... Current Node: " + node.payload + " Next Node: " + node.nextNode.payload);
//        			node = node.nextNode;
//        		}
//        		else
//        		{
//        			System.out.println("Moving to next node...");
//        			node = node.nextNode;
//        		}
//        	}
//    	}
//    	else
//    	{
//    		System.out.println("The list will be sorted descending");
//    		node = this.header;
//    		while(node != null)
//        	{
//        		if(node.nextNode == null)
//        		{
//        			break;
//        		}
//        		else if(node == this.header && node.payload > node.nextNode.payload)
//        		{
//        			System.out.println("Starting swap... Current Node: " + node.payload + " Next Node: " + node.nextNode.payload);
//        			SinglyLinkedListNode tempNode = new SinglyLinkedListNode();
//        			node.payload = tempNode.payload;
//        			node.payload = node.nextNode.payload;
//        			node.nextNode.payload = tempNode.payload;
//        			System.out.println("Starting swap... Current Node: " + node.payload + " Next Node: " + node.nextNode.payload);
//        			node = node.nextNode;
//        		}
//        		else if (node.payload > node.nextNode.payload)
//        		{
//        			System.out.println("Starting swap... Current Node: " + node.payload + " Next Node: " + node.nextNode.payload);
//        			SinglyLinkedListNode tempNode = new SinglyLinkedListNode();
//        			node.payload = tempNode.payload;
//        			node.payload = node.nextNode.payload;
//        			node.nextNode.payload = tempNode.payload;
//        			System.out.println("Starting swap... Current Node: " + node.payload + " Next Node: " + node.nextNode.payload);
//        			node = node.nextNode;
//        		}
//        		else
//        		{
//        			System.out.println("Moving to next node...");
//        			node = node.nextNode;
//        		}
//        	}
//    	}
//    }
}









