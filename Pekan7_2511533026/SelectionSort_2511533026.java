package Pekan7_2511533026;

public class SelectionSort_2511533026 {
    
    public static void selectionSort_3026(int[] arr_3026) {
        int n_3026 = arr_3026.length;
        
        for (int i_3026 = 0; i_3026 < n_3026; i_3026++) {
            int minIndex_3026 = i_3026;
            
            for (int j_3026 = i_3026 + 1; j_3026 < n_3026; j_3026++) {
                if (arr_3026[j_3026] < arr_3026[minIndex_3026]) {
                    minIndex_3026 = j_3026;
                }
            }
            
            // Swap
            int temp_3026 = arr_3026[i_3026];
            arr_3026[i_3026] = arr_3026[minIndex_3026];
            arr_3026[minIndex_3026] = temp_3026;
        }
    }

    public static void main(String[] args_3026) {
        int arr_3026[] = {23, 78, 45, 8, 32, 56, 1};
        int n_3026 = arr_3026.length;
        
        System.out.print("array yang belum terurut: ");
        for (int i_3026 = 0; i_3026 < n_3026; i_3026++) {
            System.out.print(arr_3026[i_3026] + " ");
        }
        System.out.println("");
        
        selectionSort_3026(arr_3026);
        
        System.out.print("array yang terurut: ");
        for (int i_3026 = 0; i_3026 < n_3026; i_3026++) {
            System.out.print(arr_3026[i_3026] + " ");
        }
        System.out.println("");
    }
}