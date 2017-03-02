package cs583;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortRandom {
	static int complexityCount=0;
	public static void quickSort(double array[], int p, int r) {
		int q = p;
		 
		if (p < r) {
			q = partitionRandom(array, q, r);
			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);

		}
	}

	private static int partitionRandom(double[] array, int p, int r) {
		complexityCount++;
		int randomIndex = ThreadLocalRandom.current().nextInt(p, r + 1);//Taking a random index for pivot
		//SWAP OPERATION OF PIVOT AND LAST ELEMENT
		double temp = array[randomIndex];
		array[randomIndex] = array[r];
		array[r] = temp;
		//CALL TRADITIONAL PARTITION
		return partition(array, p, r);
	}

	static int partition(double[] array, int p, int r) {
		double pivot = array[r];
		int q = p;
		
		for (int i = p; i <= r - 1; i++) {
			complexityCount++; //FOR EACH RECURSIVE CALL OF PARTITION	
			if (array[i] < pivot) {
				if (i > q) {
					// swap a[q] with a[i]
					double temp = array[q];
					array[q] = array[i];
					array[i] = temp;
				}
				q++;
			}
		}
		// swap a[q] a[r]
		double temp = array[q];
		array[q] = array[r];
		array[r] = temp;
		return q;
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//Input number of elements for the array 
		System.out.println("Enter number of elements");
		int n= sc.nextInt();
		//Make array of n
		double array[] = new double[n];
		for(int i=0;i<n;i++)
		{
			//Generate a random number
			array[i]=Math.random()*100;//and assign to array[i]
		}
		
		for(int i=0;i<30;i++) //RUN 30 TIMES TO AVERAGE THE TIME COMPLEXITY
		quickSort(array, 0, array.length - 1);
		System.out.println("Sorted output");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println("Complexity count (Averaged over 30 runs): "+(complexityCount/30)); // FINAL COMPLEXITY AFTER AVERAGING FOR 30 TIMES
		sc.close();
	}

}
