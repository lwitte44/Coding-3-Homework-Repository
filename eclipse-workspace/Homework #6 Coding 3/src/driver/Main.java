package driver;
import java.util.Random;


public class Main
{
	public static void main(String[] args)
	{
		int[] testArray = RandomizedArray(1500, 1, 1000000);//size, range from 1-100
		int[] bubbleArray = ArrayClone(testArray);
		int[] selectionArray = ArrayClone(testArray);
		
		long startTime = System.currentTimeMillis();
		BubbleSort(bubbleArray);
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("It took BubbleSort " + timeElapsed + " milliseconds to sort an array of 1 million.");
		
		long startTime2 = System.currentTimeMillis();
		SelectionSort(selectionArray);
		long endTime2 = System.currentTimeMillis();
		long timeElapsed2 = endTime2 - startTime2;
		System.out.println("It took SelectionSort " + timeElapsed2 + " milliseconds to sort an array of 1 million.");
//		//System.out.println("This is the randomized array contents:");
//		for (int i = 0; i < testArray.length; i++)
//		{
//			System.out.print(testArray[i] + ",");
//		}
//	
//		//System.out.println("This is the cloned array contents:");
//        for (int i = 0; i < testArray.length; i++)
//		{
//		    System.out.print(newArray[i] + ",");
//		}
	}
	
	public static void BubbleSort(int[] arr)
	{
	    for (int i = 0; i < arr.length; i++)
	    {
	        //in each loop, we compare neighbor items, and brings the larger one to the right
	        for (int j = 0; j < arr.length - i - 1; j++)
	        {
	            if (arr[j] > arr[j + 1])
	            {
	                int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;
	            }
	        }
	    }
	}

	public static void SelectionSort(int[] arr)
	{
	    for(int i = 0; i < arr.length; i++)
	    {
	        //in each loop, we put the current smallest number in the position of i
	        for(int j = i + 1; j < arr.length; j++)
	        {
	            if(arr[j] < arr[i])
	            {
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
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