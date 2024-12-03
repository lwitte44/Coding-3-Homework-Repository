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
		return false;
	}
	
	public Item Search(int inputKey) {
		int count = 0;
		int index = Hashing(inputKey);
		Item toCheck = this.table[index];
		while(count < this.size) {
			if (toCheck.flag == ItemFlag.empty_since_start) {
				return null; //not found
			} else if (toCheck.flag == ItemFlag.common_item && toCheck.key == inputKey) {
				return toCheck; //hit
			} else {
				count++;
				index++;
				if (index == this.size) {
					index = 0;
				}
				toCheck = this.table[index];
			}
		}
		return null; //not found
	}
	
	public void Remove(int key) {
		Item item = Search(key);
		if (item != null) {
			item.flag = ItemFlag.empty_after_removal;
		}
	}

}
