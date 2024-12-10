package driver;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		HashTable HashTable = new HashTable(10);
		Random random = new Random();
		
		HashTable.Insert(generateRandomKey(), "Optimus Prime");
		HashTable.Insert(generateRandomKey(), "Clyde");
		HashTable.Insert(generateRandomKey(), "Brandon");
		HashTable.Insert(generateRandomKey(), "Moreland");
		HashTable.Insert(generateRandomKey(), "Ramge");
		System.out.println("");
		HashTable.Display();
		HashTable.Insert(generateRandomKey(), "Bostrom");
		HashTable.Insert(generateRandomKey(), "Marks");
		HashTable.Insert(generateRandomKey(), "Nietzsche");
		HashTable.Insert(generateRandomKey(), "Kant");
		HashTable.Insert(generateRandomKey(), "Aristotle");
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
		
		int searchKey = random.nextInt(21);
		System.out.println("Searching for..." + searchKey);
		Item theItem = HashTable.Search(searchKey);
		if(theItem == null) {
			System.out.println("Not found...");
		} else {
			System.out.println("I found " + searchKey + " and it has the name: " + theItem.value + "!");
		}
		
		
		System.out.println("");
		
		HashTable.Display();
	}
	
	public static int generateRandomKey() {
		Random random = new Random();
		int generatedInt = random.nextInt(21);
		//System.out.println("I Generated " + generatedInt + "!");
		return generatedInt;
	}

}
