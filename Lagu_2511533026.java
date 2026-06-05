package Pekan8_2511533026;

public class Lagu_2511533026 {
    private String judul_3026;
    private String penyanyi_3026;
    private int durasi_3026;  // dalam detik

    public Lagu_2511533026(String judul_3026, String penyanyi_3026, int durasi_3026) {
        this.judul_3026 = judul_3026;
        this.penyanyi_3026 = penyanyi_3026;
        this.durasi_3026 = durasi_3026;
    }

    public String getJudul_3026() {
        return judul_3026;
    }

    public String getPenyanyi_3026() {
        return penyanyi_3026;
    }

    public int getDurasi_3026() {
        return durasi_3026;
    }

    @Override
    public String toString() {
        return judul_3026 + " - " + penyanyi_3026 + " (" + durasi_3026 + " detik)";
    }
}

