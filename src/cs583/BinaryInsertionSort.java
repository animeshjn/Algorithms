package cs583;

import java.util.Scanner;

public class BinaryInsertionSort {
	 static int complexityCount=0;
	public int BinarySearch (int array[], int item, int lowerBound, int upperBound)
	{	complexityCount++;
	    int mid;
	    int difference=upperBound-lowerBound;
	    mid = lowerBound + ((difference) / 2);
	    /* ADDITION + DIVISION + ASSIGNMENT*/
	    
	    if (lowerBound == upperBound)
	        return lowerBound;
	    if (item > array[mid])
	        return BinarySearch (array,item,mid + 1, upperBound);
	    else if (item != array[mid]){
	    	return BinarySearch (array,item, lowerBound, mid );
	    }
	    return mid;
	}
	
	public int[] BinaryInsertionSortAlgorithm (int array[])
	{
		/*INSERTION SORT STARTS HERE*/
		//FOR FIRST ASSIGNMENT TO i 
		complexityCount++;
		
		for (int i = 1; i < array.length; i++) {
			//comparison and increment
			complexityCount++;
	    /*START FROM 2ND ELEMENT SINCE FIRST IS ALREADY SORTED*/ 
	    int pos = BinarySearch (array, array[i], 0, i); //Finding the INSERT position with O(nlogn)
	    
	    int swap = array[i];
	    //FIRST ASSIGNMENT IN NEXT LOOP
	    		for (int j = i - 1; j >= pos; j--)
	    		{	/*MOVE ARRAY ELEMENTS*/
	    			complexityCount++;
	    			array[j + 1] = array[j];
	    		}
	    		//+LAST EXTRA COMPARISON - FIRST LESS INCREMENT = 0 INCREMENT TO COUNTER
	        	 array[pos] = swap;
	    
		}

		return array;
	}
	
	
	public static void main(String [] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter total number of array elements: ");
		int n= sc.nextInt();
		int arr[]=new int[n]; 
		System.out.println("Input Array elements");
		for (int i=0;i<n;i++)
		{
			arr[i]=i;
		}
		sc.close();
		//Call 
		arr=new BinaryInsertionSort().BinaryInsertionSortAlgorithm(arr);
		System.out.println("OUTPUT ARRAY");
		for (int i : arr) {
			System.out.println(i);
		}
		System.out.println(" Complexity Count: "+complexityCount);
		
	}
	
	
}
