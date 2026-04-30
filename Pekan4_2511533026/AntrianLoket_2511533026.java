package Pekan4_2511533026;

import java.util.Scanner;

public class AntrianLoket_2511533026 {
    private String[] queue; // Array penyimpan data
    private int front;      // Indeks depan
    private int rear;       // Indeks belakang
    private int max;        // Kapasitas array[cite: 1]
    
    public AntrianLoket_2511533026(int kapasitas) {
        max = kapasitas;
        queue = new String[max];
        front = 0;
        rear = -1;
    }
    
    // Mengecek apakah antrian penuh[cite: 1]
    public boolean isFull() {
        return rear == max - 1;
    }
    
    // Mengecek apakah antrian kosong[cite: 1]
    public boolean isEmpty() {
        return rear < front;
    }
    
    // Menambahkan pelanggan (enqueue)[cite: 1]
    public void enqueue(String nama) {
        if (isFull()) {
            System.out.println("Antrian Penuh! Tidak dapat menambah pelanggan.");
        } else {
            rear++;
            queue[rear] = nama;
            System.out.println("Data berhasil ditambahkan ke antrian");
        }
    }
    
    // Menghapus pelanggan dari antrian (dequeue)[cite: 1]
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian Kosong! Tidak ada yang bisa dihapus");
        } else {
            System.out.println(queue[front] + " telah dilayani");
            // Menggeser antrian ke depan
            for (int i = 0; i < rear; i++) {
                queue[i] = queue[i + 1];
            }
            rear--;
        }
    }
    
    // Menampilkan seluruh isi antrian[cite: 1]
    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian Kosong.");
        } else {
            System.out.println("Isi antrian:");
            for (int i = front; i <= rear; i++) {
                System.out.println((i - front + 1) + ". " + queue[i]);
            }
        }
    }
    
    // Membalik seluruh isi antrian[cite: 1]
    public void reverse() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak bisa reverse.");
            return;
        }
        int i = front;
        int j = rear;
        while (i < j) {
            String temp = queue[i]; // Simpan nilai asli i ke temp
            queue[i] = queue[j];
            queue[j] = temp;
            i++;
            j--;
        }
        System.out.println("Antrian berhasil dibalik.");
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Inisialisasi objek loket dengan kapasitas tertentu (misal: 10)
        AntrianLoket_2511533026 loket = new AntrianLoket_2511533026(10);
        int pilihan;
        
        do {
            System.out.println("\n=== PROGRAM ANTRIAN LOKET ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Hapus Antrian");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Reverse");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // Membersihkan buffer
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = input.nextLine();
                    loket.enqueue(nama);
                    break;
                case 2:
                    loket.dequeue();
                    break;
                case 3:
                    loket.display();
                    break;
                case 4:
                    loket.reverse();
                    loket.display();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
        
        input.close();
    }
}