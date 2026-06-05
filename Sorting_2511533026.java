package Pekan8_2511533026;

public class Sorting_2511533026 {
    
    private Lagu_2511533026[] dataLagu_3026;
    private int jumlah_3026;

    public Sorting_2511533026() {
        dataLagu_3026 = new Lagu_2511533026[20];
        jumlah_3026 = 0;
    }

    public void inputData_3026() {
        tambahLagu_3026("Mio Cristo Piange Diamanti", "Mina", 270);
        tambahLagu_3026("La Rumba Del Perdon", "Gipsy Kings", 252);
        tambahLagu_3026("La Perla", "Gipsy Kings", 196);
        tambahLagu_3026("Besame Mucho", "Andrea Bocelli", 320);
        tambahLagu_3026("Shape of You", "Ed Sheeran", 233);
        tambahLagu_3026("Perfect", "Ed Sheeran", 263);
        tambahLagu_3026("Thinking Out Loud", "Ed Sheeran", 295);
        tambahLagu_3026("All of Me", "John Legend", 269);
        tambahLagu_3026("Photograph", "Ed Sheeran", 259);

        System.out.println("Data awal berhasil diinput (" + jumlah_3026 + " lagu)\n");
    }

    private void tambahLagu_3026(String judul, String penyanyi, int durasi) {
        if (jumlah_3026 < 20) {
            dataLagu_3026[jumlah_3026] = new Lagu_2511533026(judul, penyanyi, durasi);
            jumlah_3026++;
        }
    }


    public void quickSort_3026() {
        quickSortHelper_3026(0, jumlah_3026 - 1);
    }

    private void quickSortHelper_3026(int low, int high) {
        if (low < high) {
            int pi = partition_3026(low, high);
            quickSortHelper_3026(low, pi - 1);
            quickSortHelper_3026(pi + 1, high);
        }
    }

    private int partition_3026(int low, int high) {
        int pivot = dataLagu_3026[high].getDurasi_3026();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (dataLagu_3026[j].getDurasi_3026() < pivot) {
                i++;
                // Swap
                Lagu_2511533026 temp = dataLagu_3026[i];
                dataLagu_3026[i] = dataLagu_3026[j];
                dataLagu_3026[j] = temp;
            }
        }
        // Swap pivot
        Lagu_2511533026 temp = dataLagu_3026[i + 1];
        dataLagu_3026[i + 1] = dataLagu_3026[high];
        dataLagu_3026[high] = temp;

        return i + 1;
    }

    // Menampilkan data
    public void tampilData_3026(String keterangan) {
        System.out.println(keterangan);
        for (int i = 0; i < jumlah_3026; i++) {
            System.out.println((i + 1) + ". " + dataLagu_3026[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sorting_2511533026 program = new Sorting_2511533026();
        
        System.out.println("=== Sorting Playlist NIM: 2511533026 ===");
        
        program.inputData_3026();
        
        program.tampilData_3026("Data Sebelum Sorting:");
        
        program.quickSort_3026();
        
        program.tampilData_3026("Data Setelah Quick Sort (Durasi Asc):");
        
        System.out.println("Sorting selesai! Terima kasih.");
    }
}

