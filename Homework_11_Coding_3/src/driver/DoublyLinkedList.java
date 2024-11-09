package driver;

//more generic types
public class DoublyLinkedList<T> 
{
	public Node<T> header;
	public Node<T> tail;
	
	public DoublyLinkedList() 
	{
		this.header = null;
		this.tail = null;
		
	}
	
	//isEmpty
	public boolean IsEmpty()
	{
		return this.header == null;
		//or
		
	}
	//getLength
	public int GetLength()
	{
		int length = 0;
		Node<T> node = this.header;
		while(node != this.tail)
		{
			length++;
			node = node.nextNode;
			
		}
		return length;
	}
	//Append
	public void Append(Node<T> node)
	{
		if(this.IsEmpty())
		{
			this.header = node;
			this.tail = node;
		}
		else 
		{
			this.tail.nextNode = node;
			node.preNode = this.tail;
			this.tail = node;
		}
	}
	//Prepend
	public void Prepend(Node<T> node)
	{
		if(this.IsEmpty())
		{
			this.header = node;
			this.tail = node;
		}
		else 
		{
			node.nextNode = this.header;
			this.header.preNode = node;
			this.header = node;
		}
	}
	//InsertAfter
	public boolean InsertAfter(Node<T> preNode, Node<T> node)
	{
		if(preNode == this.tail)
		{
			this.Append(node);
			return true;
		}
		else if(preNode == null)
		{
			return false;
		}
		else
		{
			Node<T> next = preNode.nextNode;
			preNode.nextNode = node;
			node.nextNode = next;
			next.preNode = node;
			node.preNode = preNode;
			return true;
		}
	}
	//InsertAhead
	public boolean InsertAhead(Node<T> nextNode, Node<T> node)
	{
		if(nextNode == this.tail)
		{
			this.Prepend(node);
			return true;
		}
		else if(nextNode == null)
		{
			return false;
		}
		else
		{
			Node<T> pre = nextNode.preNode;
			pre.nextNode = node;
			node.nextNode = nextNode;
			nextNode.preNode = node;
			node.preNode = pre;
			return true;
		}
	}
	//Remove
	public void Remove(Node<T> node)
	{
		if(node == this.header && node == this.tail)
		{
			this.header = null;
			this.tail = null;
		}
		else if(node == this.tail)
		{
//			node.preNode = this.tail;
//			node.preNode.nextNode = null;
//			node.preNode = null;
			Node<T> pre = node.preNode;
			pre.nextNode = null;
			pre.preNode = null;
			this.tail = pre;
		}
		else if(node == this.header)
		{
			Node<T> next = node.nextNode;
			node.nextNode = null;
			node.preNode = null;
			this.header = next;
		}
		else
		{
			node.preNode.nextNode = node.nextNode;
			node.nextNode.preNode = node.preNode;
			node.nextNode = null;
			node.preNode = null;
		}
	}
	//Search
	public DoublyLinkedList<T> BadSearch(T value)
	{
		DoublyLinkedList<T> result = new DoublyLinkedList();
		Node<T> node = this.header;
		while(node != null)
		{
			if(node.payload == value)
			{
				result.Append(node.Clone());
			}
			node = node.nextNode;
		}
		return result;
	}
	public Node<T> Search(T value)//will find the last instance of the matching node payload
	{
		Node<T> node = this.tail;
		while(node != null)
		{
			if(node.payload == value)
			{
				return node;
			}
			node = node.preNode;
		}
		return null;
	}
	//Sort()
}
