package driver;

public class Node {

	public int payload;
	public Node leftChild;
	public Node rightChild;
	public Node parentNode;
	
	public Node(int inputPayload) {
		this.payload = inputPayload;
		this.leftChild = null;
		this.rightChild = null;	
		this.parentNode = null;
	}
	
	public void Delete() {
		this.payload = 0;
		this.leftChild = null;
		this.rightChild = null;
		this.parentNode = null;
	}

}
