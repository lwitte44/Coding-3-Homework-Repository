package driver;

public class HashTableChaining {
	
	public int size;
	public List[] table;
	

	public HashTableChaining(int initialSize) {
		this.size = initialSize;
		this.table = new List[this.size];//what is currently on the array. null;
		//int[] integer_array = new int[10];//what are on the array. 0
		//always initiate objects and arrays in the constructor
		for(int i = 0; i < this.size; i++) {
			this.table[i] = new List();
		}
		//an empty list is different from null(unknown)
	}
	
	public int HashingFunction(int inputKey) {
		return inputKey % this.size;
	}
	
	public void Insert(int inputKey, String value) {
		int index = HashingFunction(inputKey);
		Node oldNode = this.table[index].Search(inputKey);
		if (oldNode != null) {
			oldNode.value = value;
		} else {
			Node newNode = new Node();
			newNode.key = inputKey;
			newNode.value = value;
			this.table[index].Append(newNode);
		}
	}
	
	public Node Search(int inputKey) {
		int index = HashingFunction(inputKey);
		return this.table[index].Search(inputKey);
	}
	
	public void Remove(int inputKey) {
		int index = HashingFunction(inputKey);
		this.table[index].Remove(inputKey);
	}
	
	public void Display() {
		String output = "";
		for (int i = 0; i < this.size; i++) {
			output += String.format("[%d] %s\n", i, this.table[i].toString());
		}
		System.out.println(output);
	}
	
	public void Resize() {
		HashTableChaining newTable = new HashTableChaining(1000);
		//how to loop through all items on the hash table
		for(int i = 0; i < this.size; i++) {
			List lst = this.table[i];
			Node node = lst.head;
			while(node != null) {
				newTable.Insert(node.key,  node.value);
				node = node.nextNode;
			}
		}
		this.size = newTable.size;
		this.table = newTable.table;
	}

}
