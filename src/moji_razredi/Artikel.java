package moji_razredi;

public class Artikel {
    private int kolicina;
    private String ime;
    private double cena;
    private double davcnaStopnja;
    private int ean;


    public Artikel(String ime, double cena, double davcnaStopnja, int kolicina, int ean) {
        this.ime = ime;
        this.cena = cena;
        this.davcnaStopnja = davcnaStopnja;
        this.kolicina = kolicina;
        this.ean = ean;
    }

    public double getDavcnaStopnja() {
        return davcnaStopnja;
    }

    public void setDavcnaStopnja(double davcnaStopnja) {
        this.davcnaStopnja = davcnaStopnja;
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

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "kolicina=" + kolicina +
                ", ime='" + ime + '\'' +
                ", cena=" + cena +
                ", davcnaStopnja=" + davcnaStopnja +
                ", ean=" + ean +
                '}';
    }
}
