package driver;

//this is hashTable resolve using linear probe
public class HashTable {

	public int size;
	public Item[] table;
	
	public HashTable(int size) {
		this.size = size;
		this.table = new Item[size];
		//we need to give the initial array each item
		//empty-since-start flag
		//empty-after-removal
		//common item
		for(int i = 0; i < this.size; i++) {
			this.table[i] = new Item();
		}
	}
	
	public int Hashing(int inputKey) {
		return inputKey % this.size;
	}
	
	public boolean Insert(int inputKey, String inputValue) {
		int index = Hashing(inputKey);
		Item toCheck = this.table[index];
		int count = 0;
		while(count < this.size) {
			if(toCheck.flag == ItemFlag.empty_since_start || toCheck.flag == ItemFlag.empty_after_removal) {
				Item newItem = new Item(inputKey, inputValue);
				this.table[index] = newItem;
				return true;
			} else if(toCheck.key == inputKey) {
				toCheck.value = inputValue; //update
				return true;
			} else {
				index++;
				
				if(index == this.size) {
					index = 0;
				}
				toCheck = this.table[index];
			}
		}
	}
	
	public boolean Search(int inputKey) {
		//search one by one
		//jump over flag empty after removal
		
	}

}
