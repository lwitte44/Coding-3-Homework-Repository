package driver;

import java.util.Random;

public class Main {
	
	public static int numOfRandomNumbers = 10;
	public static int[] generatedIntsArray = new int[numOfRandomNumbers];
	public static int generatedArrayIndex = 0;

	public static void main(String[] args) {
		Random random = new Random();
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.Insert(generateRandomKey());
		tree.Insert(generateRandomKey());
		tree.Insert(generateRandomKey());
		tree.Insert(generateRandomKey());
		tree.Insert(generateRandomKey());
		
		tree.Insert(generateRandomKey());
		tree.Insert(generateRandomKey());
		tree.Insert(generateRandomKey());
		tree.Insert(generateRandomKey());
		tree.Insert(generateRandomKey());

	}
	public static int generateRandomKey() {
		Random random = new Random();
		int generatedInt = random.nextInt(numOfRandomNumbers + 1);
		
		for(int i = 0; i < generatedIntsArray.length; i++) {
			if(generatedInt == generatedIntsArray[i])
			{
				generateRandomKey();
			} else {
				System.out.println("I added " + generatedInt + " to the tree!");
				generatedIntsArray[generatedArrayIndex] = generatedInt;
				generatedArrayIndex++;
				return generatedInt;
			}
		}
		System.out.println("Failed to generate random int!");
		return 100;
	}
}
