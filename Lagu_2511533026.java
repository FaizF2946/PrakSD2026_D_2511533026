package Pekan6_2511533026;

public class Lagu_2511533026 {
	private String judul_3026;
    private String penyanyi_3026;
    

    Lagu_2511533026 next_3026;
    Lagu_2511533026 prev_3026;

    public Lagu_2511533026(String judul_3026, String penyanyi_3026) {
        this.judul_3026 = judul_3026;
        this.penyanyi_3026 = penyanyi_3026;
        this.next_3026 = null;
        this.prev_3026 = null;
    }

    public String getJudul_3026() { return judul_3026; }
    public String getPenyanyi_3026() { return penyanyi_3026; }
}

