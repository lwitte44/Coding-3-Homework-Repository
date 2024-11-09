package driver;

//T is a generic type
public class Node<T> 
{
	public T payload;
	public Node<T> preNode;
	public Node<T> nextNode;
	
	//Node a = new Node();
	//Node<int> a = new Node();
	public Node() 
	{
		this.preNode = null;
		this.nextNode = null;
		
	}
	
	public Node<T> Clone()
	{
		Node<T> newNode = new Node<T>();
		newNode.payload = this.payload;
		return newNode;
	}
	
	//if this is equal to another, return 0
	//if this is larger than another, return 1(positive)
	//if this is smaller than another, return -1(negative)
	@Override
	public int compareTo(Node<T> another)
	{
		if(another.payload instanceof Integer)
		{
			if((int)this.payload > (int)another.payload)
			{
				return 1;
			}
			else if((int)this.payload < (int)another.payload)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
		else if(this.payload instanceof String)
		{
			return (String)this.payload.compareTo((String)another.payload);
		}
		else
		{
			return 0;
		}
	}

}
