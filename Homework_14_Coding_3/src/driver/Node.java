package driver;

public class Node {
	
	public Node nextNode;
	public int key;
	public Node prevNode;
	public String value;

	public Node() {
		this.nextNode = null;
		this.prevNode = null;
		this.key = 0;
		this.value = "";
	}
	
	@Override
	public String toString() {
		return String.format("(%d|%s)", this.key, this.value);
	}
}
