package Pekan7_2511533026;

public class Mahasiswa_2511533026 {
    private String nama_3026;
    private String nim_3026;
    private String prodi_3026;

    // Constructor
    public Mahasiswa_2511533026(String nama_3026, String nim_3026, String prodi_3026) {
        this.nama_3026 = nama_3026;
        this.nim_3026 = nim_3026;
        this.prodi_3026 = prodi_3026;
    }

    // Getter
    public String getNama_3026() { 
        return nama_3026; 
    }
    
    public String getNim_3026() { 
        return nim_3026; 
    }
    
    public String getProdi_3026() { 
        return prodi_3026; 
    }

    // Setter
    public void setNama_3026(String nama_3026) { 
        this.nama_3026 = nama_3026; 
    }
    
    public void setNim_3026(String nim_3026) { 
        this.nim_3026 = nim_3026; 
    }
    
    public void setProdi_3026(String prodi_3026) { 
        this.prodi_3026 = prodi_3026; 
    }

    @Override
    public String toString() {
        return String.format("%-25s | %-15s | %s", nama_3026, nim_3026, prodi_3026);
    }
}

