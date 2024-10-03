package driver;
import java.util.Random;
public class Main
{
	public static void main(String[] args)
	{
		int[] testArray = RandomizedArray(1500, 1, 1000000);//size, range from 1-100
		int[] insertionArray = ArrayClone(testArray);
		
		long startTime = System.currentTimeMillis();
		InsertionSort(insertionArray);
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("It took InsertionSort " + timeElapsed + " milliseconds to sort an array of 1 million.");
		
//		System.out.println("This is the randomized array contents:");
//		for (int i = 0; i < testArray.length; i++)
//		{
//			System.out.print(testArray[i] + ",");
//		}
//		System.out.println("");
//		System.out.println("This is the cloned array contents:");
//        for (int i = 0; i < testArray.length; i++)
//		{
//		    System.out.print(newArray[i] + ",");
//		}
	}
	
	public static void InsertionSort (int[] arr)
	{
	    for (int i = 0; i < arr.length - 1; i++)
	    {
	        
	        int j = i + 1;
	        
	        while (j > 0 && arr[j - 1] > arr[j])
	        {
	            int temp = arr[j];
	            arr[j] = arr[j - 1];
	            arr[j - 1] = temp;
	            j = j - 1;
	        }
	    }
	}

	//size = 100, start = 1, end = 10000
	public static int[] RandomizedArray(int size, int start, int end)
	{
		if (end - start + 1 >= size)
		{
			//when size = 100, start = 1, end = 100,000
			int[] sourceArray = new int[end - start + 1];
			for (int i = 0; i < end - start + 1; i++)
			{
				sourceArray[i] = i + 1;
			}
			//shuffle 3 times
			for (int i = 0; i < 3; i++)
			{
				shuffle(sourceArray);
			}
			int[] result = new int[size];
			for (int i = 0; i < size; i++)
			{
				result[i] = sourceArray[i];
			}
			return result;
		}
		else
		{
			return null;
		}

	}

	//we will randomize the items in the array
	public static void shuffle(int[] array)
	{
		//loop for half of the amount of the array
		for (int i = 0; i < array.length / 2; i++)
		{
			//every round we pick two random locations and swap their positions
			Random r = new Random();
			int pos1 = r.nextInt(array.length - 1);
			int pos2 = r.nextInt(array.length - 1);
			int temp = array[pos1];
			array[pos1] = array[pos2];
			array[pos2] = temp;
		}

	}
	
	public static int[] ArrayClone(int[] array)
	{
		int[] result = new int[array.length];

		for (int i = 0; i < array.length; i++)
		{
			result[i] = array[i];
		}
		return result;
	}
}
