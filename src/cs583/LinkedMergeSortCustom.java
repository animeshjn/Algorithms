package cs583;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedMergeSortCustom {
	static int counter=0;
	public void merge​ (double[] a, int p, int q, int r) {
		 int leftSize = q - p + 1;
		
		 int rightSize = r - q;
		 LinkedList<Double> left = new LinkedList<Double>();
		 LinkedList<Double> right = new LinkedList<Double>();
		 for (int i=0; i<leftSize; i++)
		{	left.add(a[p+i]);
		}
		 for (int i=0; i<rightSize; i++)
		 {right.add(a[q+1+i]);
		 }
		 int leftPos = 0;
		 int rightPos = 0;
		 left.add(Double.MAX_VALUE);
		 right.add(Double.MAX_VALUE);
		 for (int i=p; i<=r; i++) {
			 counter++;
		 if (left.get(leftPos) < right.get(rightPos))
		 {a[i] = left.get(leftPos++);
		 }
		 else
		 {
		 a[i] = right.get(rightPos++);
		 }
		 
		 }
	
	}
	
	public void mergeSort(double a[], int p, int r){
		counter++;
		if(p<r)
		{	
			int q=(p+r)/2;
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge​(a,p,q,r);
		}
		
	}
	public static void main(String [] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter total number of array elements: ");
		int n;
		n=sc.nextInt();
		double arr[]=new double[n]; 
		//System.out.println("Input Array elements");
		sc.close();	
		for(int i=0;i<n;i++)
		{
		arr[i]=(double)(i);
		}
		new LinkedMergeSortCustom().mergeSort(arr, 0, arr.length-1);
		System.out.println("OUTPUT ARRAY");
		for (double i : arr) {
			System.out.println(i);
		}
	System.out.println(" Complexity Count: "+counter);
		
	}

}
