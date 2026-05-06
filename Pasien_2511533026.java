package Pekan5_2511533026;

class Pasien_2511533026 {
 private String namaPasien_3026;
 private String keluhan_3026;
 private int nomorAntrian_3026;
 
 Pasien_2511533026 next_3026;

 public Pasien_2511533026(String nama_3026, String keluhan_3026, int no_3026) {
     this.namaPasien_3026 = nama_3026;
     this.keluhan_3026 = keluhan_3026;
     this.nomorAntrian_3026 = no_3026;
     this.next_3026 = null;
 }

 public String getNama_3026() { return namaPasien_3026; }
 public String getKeluhan_3026() { return keluhan_3026; }
 public int getNomor_3026() { return nomorAntrian_3026; }

 public void setNext_3026(Pasien_2511533026 next_3026) {
     this.next_3026 = next_3026;
 }
}

