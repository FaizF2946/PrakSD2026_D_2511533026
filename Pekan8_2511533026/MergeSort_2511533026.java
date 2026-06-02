package Pekan8_2511533026;

public class MergeSort_2511533026 {

    void merge(int arr[], int l_3026, int m_3026, int r_3026) {

        int n1 = m_3026 - l_3026 + 1;
        int n2 = r_3026 - m_3026;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l_3026 + i];

        for (int j = 0; j < n2; ++j)
            R[j] = arr[m_3026 + 1 + j];

        int i = 0, j = 0;

        int k = l_3026;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l_3026, int r_3026) {

        if (l_3026 < r_3026) {

            int m_3026 = (l_3026 + r_3026) / 2;

            sort(arr, l_3026, m_3026);

            sort(arr, m_3026 + 1, r_3026);

            merge(arr, l_3026, m_3026, r_3026);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[]) {

        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Sebelum Terurut:");
        printArray(arr);

        MergeSort_2511533026 ob = new MergeSort_2511533026();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSesudah Terurut Menggunakan Merge Sort:");
        printArray(arr);
    }
}