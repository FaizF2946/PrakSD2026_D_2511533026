package Pekan8_2511533026;

public class QuickSort_2511533026 {
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[j];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	// Metode tambahan untuk mengatur pibot menggunakan Median-of-Three
	static void medianOfThree(int[] arr, int low, int high)
	{
		int mid = low + (high - low) / 2;
		
		// Urutkan elemen low, mid, dan high
		if (arr[low] > arr [mid]) {
			swap (arr, low, mid);
		}
		if (arr[mid] > arr[high]) {
			swap(arr, mid, high);
		}
		swap (arr, mid, high);
	}
	static int partition(int[] arr, int low, int high)
	{
		// Panggil fungsi medianOfThree sebelum menentukan pivot
		medianOfThree(arr, low, high);
		
		int pivot = arr[high]; // Sekarang arr[high] sudah berisi nilai median
		int i = (low - 1);
		
		for (int j = low; j <= high - 1; j++) {
			// Jika elemen saat ini lebih kecil dari atau sama dengan pivot
			if (arr[j] < pivot) {
				// Increment indeks elemen yang lebih kecil
				i++;
				swap(arr, i, j);
			}
		}
		swap (arr, i + 1, high);
		return (i +1);
	}

	static void quickSort_2511533026 (int[] arr, int low, int high)
	{
			if (low < high) {
				int pi = partition(arr, low, high);
				quickSort_2511533026(arr, low, pi - 1);
				quickSort_2511533026(arr, pi + 1, high);
			}
	}
	
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
}

public static void main (String[] args){
	int[] arr = { 10, 7, 8, 9, 1, 5 };
	int N = arr.length;
	System.out.print("Data sebelum diurutkan: ");
	printArr(arr);
	
	quickSort_2511533026(arr, 0, N - 1);
	
	System.out.println("Data Terurut quicksort: ");
	printArr(arr);
	}
}