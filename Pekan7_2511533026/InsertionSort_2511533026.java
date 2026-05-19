package Pekan7_2511533026;

public class InsertionSort_2511533026 {
    
    public static void insertionSort_3026(int[] arr_3026) {
        int n_3026 = arr_3026.length;
        
        for (int i_3026 = 1; i_3026 < n_3026; i_3026++) {
            int key_3026 = arr_3026[i_3026];
            int j_3026 = i_3026 - 1;
            
            while (j_3026 >= 0 && arr_3026[j_3026] > key_3026) {
                arr_3026[j_3026 + 1] = arr_3026[j_3026];
                j_3026--;
            }
            arr_3026[j_3026 + 1] = key_3026;
        }
    } 

    public static void main(String[] args_3026) {
        int arr_3026[] = { 23, 78, 45, 8, 32, 56, 1 };
        int n_3026 = arr_3026.length;
        
        System.out.printf("array yang belum terurut:\n");
        for (int i_3026 = 0; i_3026 < n_3026; i_3026++)
            System.out.print(arr_3026[i_3026] + " ");
        
        System.out.println("");
        
        insertionSort_3026(arr_3026);
        
        System.out.printf("array yang terurut:\n");
        for (int i_3026 = 0; i_3026 < n_3026; i_3026++)
            System.out.print(arr_3026[i_3026] + " ");
        
        System.out.println("");
    }
}