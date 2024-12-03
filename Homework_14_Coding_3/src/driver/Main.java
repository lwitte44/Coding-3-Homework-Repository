package driver;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		HashTableChaining HashTable = new HashTableChaining(10);
		Random random = new Random();
		
		HashTable.Insert(generateRandomKey(), "Herbert");
		HashTable.Insert(generateRandomKey(), "Sven");
		HashTable.Insert(generateRandomKey(), "Brandon");
		HashTable.Insert(generateRandomKey(), "Allie");
		HashTable.Insert(generateRandomKey(), "Troy");
		System.out.println("");
		HashTable.Display();
		HashTable.Insert(generateRandomKey(), "Kyle");
		HashTable.Insert(generateRandomKey(), "Ben");
		HashTable.Insert(generateRandomKey(), "Barry");
		HashTable.Insert(generateRandomKey(), "Blade");
		HashTable.Insert(generateRandomKey(), "Wendy");
		System.out.println("");
		HashTable.Display();
		HashTable.Insert(generateRandomKey(), "Bob");
		HashTable.Insert(generateRandomKey(), "Chester");
		HashTable.Insert(generateRandomKey(), "Dretske");
		HashTable.Insert(generateRandomKey(), "Socrates");
		HashTable.Insert(generateRandomKey(), "Plato");
		System.out.println("");
		HashTable.Display();
		HashTable.Insert(generateRandomKey(), "Aquinas");
		HashTable.Insert(generateRandomKey(), "Augustine");
		HashTable.Insert(generateRandomKey(), "Menuge");
		HashTable.Insert(generateRandomKey(), "Turing");
		HashTable.Insert(generateRandomKey(), "Jackson");
		System.out.println("");
		HashTable.Display();
		
		int removedInt = random.nextInt(21);
		System.out.println("Removing..." + removedInt);
		HashTable.Remove(removedInt);
		
		removedInt = random.nextInt(21);
		System.out.println("Removing..." + removedInt);
		HashTable.Remove(removedInt);
		
		int searchInt = random.nextInt(21);
		System.out.println("Searching for..." + searchInt);
		Node theNode = HashTable.Search(searchInt);
		if(theNode == null) {
			System.out.println("Not found...");
		} else {
			System.out.println("I found " + searchInt + " and it has the name: " + theNode.value + "!");
		}
		
		
		System.out.println("");
		
		HashTable.Display();
	}
	
	public static int generateRandomKey() {
		Random random = new Random();
		int generatedInt = random.nextInt(21);
		System.out.println("I Generated " + generatedInt + "!");
		return generatedInt;
	}
}
