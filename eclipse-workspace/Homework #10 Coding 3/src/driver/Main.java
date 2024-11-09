package driver;

public class Main 
{

	public static void main(String[] args) 
	{
		SinglyLinkedList list = new SinglyLinkedList();
		System.out.println("Hello List");
		list.Append(17);
		list.Prepend(9);
		list.Append(5);
		//System.out.println("The List's Current Length is: " + list.getLength());
		SinglyLinkedListNode node = list.Search(17);
		if(node != null)
		{
			list.InsertAfter(node,  16);
			list.InsertAfter(node, 15);
		}
		SinglyLinkedListNode toBeRemoved = list.Search(16);
		list.Remove(toBeRemoved);
		list.Remove(list.header);
		//list.Print();
		//list.PrintReverse();
		list.Append(44);
		list.Append(12);
		list.Append(100);
		list.Append(3);
		list.Prepend(99);
		list.Print();
		list.Sort(false);
		list.Print();
	}

}


//public class Main
//{
//	public static void main(String[] args) 
//	{
//		System.out.println("Sort");
//		int[] testArray = new int[] {5, 7, 2, 13, 10, 23};
//		BubbleSort(testArray);
//		for(int i = 0; i < testArray.length; i++)
//		{
//		    System.out.println(testArray[i]);
//		}
//		
//	}
//	
//	public static void BubbleSort(int[] arr)
//	{
//	    for (int i = 0; i < arr.length; i++)
//	    {
//	        //in each loop, we compare neighbor items, and brings the larger one to the right
//	        for (int j = 0; j < arr.length - i - 1; j++)
//	        {
//	            if (arr[j] > arr[j + 1])
//	            {
//	                int temp = arr[j];
//	                arr[j] = arr[j + 1];
//	                arr[j + 1] = temp;
//	            }
//	        }
//	    }
//	}
//}
