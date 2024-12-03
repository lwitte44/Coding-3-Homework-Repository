package driver;

public class List {
	
	public Node head;
	

	public List() {
		this.head = null;
	}
	
	public int GetLength() {
		int length = 0;
		Node node = this.head;
		while(node != null) {
			length++;
			node = node.nextNode;
		}
		return length;			
	}

	public boolean IsEmpty() {
		return this.head == null;
	}
	
	public void Append(Node node) {
		if(this.IsEmpty()) {
			this.head = node;
		} else {
			Node cur = this.head;
			while(cur.nextNode != null) {
				cur = cur.nextNode;
			}
			cur.nextNode = node;
		}
	}
	
	public Node Search(int inputKey) {
		Node node = this.head;
		while(node != null) {
			if(node.key == inputKey) {
				return node;
			} else {
				node = node.nextNode;
			}
		}
		return null;
	}
	
	public void Remove(int inputKey) {
		if(!this.IsEmpty()) {
			if(this.head.key == inputKey && this.head.nextNode == null) {
				this.head = null;
			}
			Node preNode = this.head;
			Node node = this.head;
			while(node != null) {
				if(node.key == inputKey) {
					preNode.nextNode = node.nextNode;
					node.nextNode = null;
					break;
				} else {
					preNode = node;
					node = node.nextNode;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		if (this.IsEmpty()) {
			return "{empty}";
		} else {
			String output = "";
			Node node = this.head;
			output = "{" + node.toString();
			Node next = node.nextNode;
			while (next != null) {
				output += " -> " + next.toString();
				next = next.nextNode;
			}
			output += "}";
			return output;
		}
	}
}
