package moji_razredi;

public class Artikel {
    private String ime;
    private double cena;

    public Artikel(String ime, double cena) {
        this.ime = ime;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
