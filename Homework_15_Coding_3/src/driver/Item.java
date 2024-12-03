package driver;

public class Item {
	
	public ItemFlag flag;
	public int key;
	public String value;

	public Item(int key, String value) {
		this.key = key;
		this.value = value;
		this.flag = ItemFlag.common_item;
	}
	
	public Item() {
		this.key = 0;
		this.value = "";
		this.flag = ItemFlag.empty_since_start;
	}
	@Override 
	public String toString() {
		return String.format("{%d | %s}", key, value);
	}

}
