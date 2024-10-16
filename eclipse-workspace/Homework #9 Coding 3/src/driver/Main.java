package driver;
import java.util.Random;

public class Main 
{

	public static void main(String[] args) 
	{
		int[] arr = new int[15];
	    Random r = new Random();
	    for(int i = 0; i < arr.length; i++)
	    {
	        arr[i] = r.nextInt(100);
	    }
	    Main.display(arr);
 	    Main.mergeSort(arr, 0, arr.length-1);
 	    Main.display(arr);
	}
	

 	//write mergesort as we did in class on 1/12/24 (see video)
 	static void mergeSort(int[] arr, int begin, int end)
 	{
    if (begin == end)// if begin is equal to end they are trivially sorted  
    { 
        return;
    }
    int middle = (begin + end) / 2;//equation to find the middle of the original array
    
    mergeSort(arr, begin, middle);//first half
    
    mergeSort(arr, middle + 1, end);//second half
    
    merge(arr, begin, middle, end);//merges both halves again
 	}
 	
    static void merge(int[] arr, int begin, int middle, int end)//going to be used within mergeSort to split into halves and then merge back
    {
    
    int firstHalf[] = new int[middle - begin + 1];//firstHalf = begin1
    int secondHalf[] = new int[end - middle];//secondHalf = begin2
    
    
    for (int i = 0; i < firstHalf.length; i++)//firstHalf.length = end1
        {
            firstHalf[i] = arr[begin + i]; 
        }
    for (int i = 0; i < secondHalf.length; i++)//secondHalf.length = end2
        {
            secondHalf[i] = arr[middle + i + 1];//add 1 because you need to start 1 higher than the 
                                               //middle because the middle is the end of the first half
        }
        
    //creates positions to keep track of which values have been copied back to the original
    int pos1 = 0;
    int pos2 = 0;
    //these positions will bump over when the value from their respective half has been copied
    
     // Copies the halves back into the original array
    for (int i = begin; i < end + 1; i++) 
        {
        // while the pos1 and pos2 are behind the ends of the half arrays, copy the lowest numbers back to the original array
        if (pos1 < firstHalf.length && pos2 < secondHalf.length)//the && symbol is used to show that both conditions must be true to fulfill the "if statement" 
            {
            if (firstHalf[pos1] < secondHalf[pos2])
                {
                    arr[i] = firstHalf[pos1];
                    pos1++;//bumps pos1 over
                } 
            else 
                {
                    arr[i] = secondHalf[pos2];
                    pos2++;//bumps pos2 over
                }
            } 
        else if (pos1 < firstHalf.length) 
            {
                // If all of the numbers in the second half are copied, copy the rest of the first half
                arr[i] = firstHalf[pos1];
                pos1++;//bumps pos1 over
            } 
        else if (pos2 < secondHalf.length) 
            {
                // If all of the numbers in the first half are copied, copy the rest of the second half
                arr[i] = secondHalf[pos2];
                pos2++;//bumps pos2 over
            }
        }
    }
 	
	
	static void display(int[] arr)//used to display the array
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
