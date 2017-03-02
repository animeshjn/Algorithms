package cs583;

public class QuickSort {

	public static void quickSort(double array[], int p, int r) {
		int q = p;
		if (p < r) {
			q = partition(array, q, r);
			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);

		}
	}

	static int partition(double[] array, int p, int r) {

		double pivot = array[r];
		int q = p;
		for (int i = p; i <= r - 1; i++) {
			if (array[i] < pivot) {
				if (i > q) {
					//swap a[q] with a[i]
					double temp= array[q];
					array[q]=array[i];
					array[i]=temp;
					
				}
			q++;
			
			}
			
		}
		//swap a[q] a[r]
		double temp= array[q];
		array[q]=array[r];
		array[r]=temp;
		return q;
	}

	
	public static void main(String[] args) {
	
		double array[]={12,40,50,30,20,10,9};
		quickSort(array, 0, array.length-1);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			
		}
		
	}
	
	
	
}
