package driver;

public class HashTableChaining {
	
	public int size;
	public List[] table;
	

	public HashTableChaining(int initialSize) {
		this.size = initialSize;
		this.table = new List[this.size];
	}
	
	public int HashingFunction(int key) {
		return key % this.size;
	}
	
	public boolean Insert(int key, String value) {
		int index = HashingFunction(key);
		Node newNode = new Node();
		newNode.key = key;
		newNode.value = value;
		this.table[index].Append(newNode);
		return false;
	}
	
	public Node Search(int key) {
		int index = HashingFunction(key);
		return this.table[index].Search(key);
	}
	public void Remove(int key) {
		int index = HashingFunction(key);
		this.table[index].Remove(key);
	}

}
