package driver;

public class BinarySearchTree {
	
	public Node root;
	public int height;

	public BinarySearchTree() {
		this.root = null;
		this.height = 0;
	}
	
	public void Insert(Node newNode, Node node) {
		if(node.payload >= newNode.payload) {
			if(node.leftChild == null) {
				node.leftChild = newNode;
			} else {
				Insert(newNode, node.leftChild);
			}
		} else {
			if(node.rightChild == null) {
				node.rightChild = newNode;
			} else {
				Insert(newNode, node.rightChild);
			}
		}
	}
	
	//insert
	public void Insert(int inputPayload) {
		Node newNode = new Node(inputPayload);
		if(this.root == null) {
			this.root = newNode;
		} else {
			Insert(newNode, this.root);
		}
	}
	//delete
	public boolean Delete(int inputPayload) {
		//if it is the leaf, delete the node
		//if there is a leftChild, make the leftChild to be the parent
		//and move all the leftChild's children up (recursively)
		//rightChild is fine
		Node node = this.Search(inputPayload);
		if (node == null) {
			return false;
		} else {
			if (node.leftChild == null && node.rightChild == null) {
				if (node.parentNode == null) {
					this.root = null;
					return true;
				}
				Node parent = node.parentNode;
				if (parent.leftChild == node) {
					parent.leftChild = null;
				} else if (parent.rightChild == node) {
					parent.rightChild = null;
				}
				node.parentNode = null;
				return true;
			} else if (node.leftChild == null) {
				if (node.parentNode == null) {
					this.root = node.rightChild;
					node.rightChild.parentNode = null;
					node.rightChild = null;
					return true;
				}
				Node parent = node.parentNode;
				if (parent.leftChild == node) {
					parent.leftChild = node.rightChild;
				} else {
					parent.rightChild = node.rightChild;
				}
				node.rightChild.parentNode = parent;
				node.parentNode = null;
				node.rightChild = null;
				return true;
			} else if (node.rightChild == null) {
				if (node.parentNode == null) {
					this.root = node.leftChild;
					node.leftChild.parentNode = null;
					node.leftChild = null;
					return true;
				}
				Node parent = node.parentNode;
				if (parent.leftChild == node) {
					parent.leftChild = node.rightChild;
				} else {
					parent.rightChild = node.rightChild;
				}
				node.leftChild.parentNode = parent;
				node.parentNode = null;
				node.leftChild = null;
				return true;
			} else {
				if (node.rightChild.leftChild != null) {
					node.payload = node.rightChild.leftChild.payload;
					while (node != null) {
						node = RemoveNode(node.rightChild.leftChild);
					}
					return true;
				} else {
					if (node.parentNode == null) {
						this.root = node.rightChild;
						node.rightChild.parentNode = null;
						node.rightChild.leftChild = node.leftChild;
						if (node.leftChild != null) {
							node.leftChild.parentNode = node.rightChild;
						}
						node.rightChild = null;
						node.leftChild = null;
						node.parentNode = null;
						return true;
					} else {
						Node parent = node.parentNode;
						if (parent.leftChild == node) {
							parent.leftChild = node.rightChild;
						} else {
							parent.rightChild = node.rightChild;
						}
						node.rightChild.leftChild = node.leftChild;
						node.leftChild.parentNode = node.rightChild;
						node.rightChild = null;
						node.leftChild = null;
						node.parentNode = null;
						return true;
					}
				}
			}
		}
	}
	public Node RemoveNode(Node toBeRemoved) {
		if (toBeRemoved.rightChild == null) {
			if (toBeRemoved.parentNode.leftChild == toBeRemoved) {
				toBeRemoved.parentNode.leftChild = toBeRemoved.leftChild;
			} else {
				toBeRemoved.parentNode.rightChild = toBeRemoved.leftChild;
			}
			toBeRemoved.leftChild.parentNode = toBeRemoved.parentNode;
			toBeRemoved.Delete();
			return null;
		} else if (toBeRemoved.rightChild.leftChild == null) {
			toBeRemoved.payload = toBeRemoved.rightChild.rightChild.payload;
			return toBeRemoved.rightChild;
		} else {
			toBeRemoved.payload = toBeRemoved.rightChild.leftChild.payload;
			return toBeRemoved.leftChild;
		}
	}
	//search
	public Node Search(int inputPayload) {
		//recursively to compare the node, and if not hit, call the search recursively on the child
		//Go to root node
				Node node = this.root;
				
				while (node != null) {
					if (node.payload == inputPayload) {
						return node;
					} else if (inputPayload < node.payload) {
						node = node.leftChild;
					} else {
						node = node.rightChild;
					}
				}
				return null;
	}
	//balance. we don't have time to discuss

}
