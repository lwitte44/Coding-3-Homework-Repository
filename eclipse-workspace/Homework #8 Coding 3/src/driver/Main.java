package driver;
import java.util.Random;

public class Main 
{

	public static void main(String[] args) 
	{
		System.out.println("Randomized Array:");
		int[] testArray = RandomizedArray(10000000, 1, 10000000);//size, range from 1-100
		
//		for(int i = 0; i < testArray.length; i++)
//		{
//		    //Random r = new Random();
//		    //testArray[i] = r.nextInt(20);
//		    System.out.print(testArray[i] + " ");
//		}
//		System.out.println(" ");
		
		int[]shellClone = ArrayClone(testArray);
		int[]quickClone = ArrayClone(testArray);
		
		long startTime = System.currentTimeMillis();
		quickSort(quickClone, 0, testArray.length - 1);
		//System.out.println("Pivot is at " + p + " the value is " + testArray[p]);
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("It took QuickSort " + timeElapsed + " milliseconds to sort an array of 1 million.");
	
		//int[] gaps = new int[] {3, 2, 1};
		for (int gap = shellClone.length / 2; gap > 0; gap /= 2)
		{ 
		    System.out.println("Doing shell sort at gap length: " + gap);
		    InsertionSortOnGap(shellClone, gap);
		}
		startTime = System.currentTimeMillis();
		ShellSort(shellClone);
		endTime = System.currentTimeMillis();
		timeElapsed = endTime - startTime;
		System.out.println("It took ShellSort " + timeElapsed + " milliseconds to sort an array of 1 million.");
		
//		System.out.println("Quick Sort: ");
//		for(int i = 0; i < quickClone.length; i++)
//		{
//		    System.out.print(quickClone[i] + " ");
//		}
//		
//		System.out.println(" ");
//		System.out.println("Shell Sort: ");
//		for(int i = 0; i < shellClone.length; i++)
//		{
//		    System.out.print(shellClone[i] + " ");
//		}
	}

	// The QuickSort function implementation
    static void quickSort(int[] arr, int low, int high) 
    {
        if (low < high) 
        {
            
            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    // Partition function
    static int partition(int[] arr, int low, int high) 
    {
        
        // Choose the pivot
        int pivot = arr[high];
        
        // Index of smaller element and indicates 
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to 
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);  
        return i + 1;
    }
    
    // Swap function
    static void swap(int[] arr, int i, int j) 
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
  //the new insertionSort uses a round robin fashion to partition the array into gap groups.
    //the first item starts with startIndex.
    //then, we apply sort on this specific partition, (partition startIndex, with gap amount of item separated)
	public static void InsertionSort(int[] arr, int startIndex, int gap)
	{
        for(int i = startIndex; i < arr.length - gap; i = i + gap)
	    {
	        
	        int j = i + gap;
	        
	        while (j > startIndex && arr[j - gap] > arr[j])
	        {
	            int temp = arr[j];
	            arr[j] = arr[j - gap];
	            arr[j - gap] = temp;
	            j = j - gap;
	        }
	    }
	}
	
	//apply insertion sort on each group when we partition the array into (gap) groups
    public static void InsertionSortOnGap (int[] arr, int gap)
	{
	    for (int i = 0; i < gap; i++)
	    {
	       InsertionSort(arr, i, gap);
	    }
    }
    
    //shell sort with gap from 2^k, 2^k-1, 2^k-2, ..., 4, 2, 1. 2^k V length, and 2^k+1 >= length
    public static void ShellSort (int[] arr)
    {
        int k = 1;
        int gaps = 2;
        while (gaps < arr.length)
        {
            gaps = gaps * 2;
            k = k + 1;
        }
        gaps = gaps / 2;
        k = k - 1;
        for (int i = k; i >= 1; i--)
        {
            int gap = pow(2, i);
            InsertionSortOnGap(arr, gap);
        }
    }
    
    public static int pow(int base, int power)
    {
        int result = 1;
        for(int i = 0; i < power; i++)
        {
            result = result * base;
        }
        return result;
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
