package moji_razredi;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Artikel {
    private int kolicina;
    private String ime;
    private BigDecimal cena;
    private BigDecimal davcnaStopnja;
    private String ean;
    private BigDecimal skupnaCena;


    public BigDecimal getSkupnaCena() {
        return skupnaCena;
    }

    public void setSkupnaCena(BigDecimal skupnaCena) {
        this.skupnaCena = skupnaCena;
    }

    public Artikel(String ime, BigDecimal cena, BigDecimal davcnaStopnja, int kolicina, String ean) {
        this.ime = ime;
        this.cena = cena;
        this.davcnaStopnja = davcnaStopnja;
        this.kolicina = kolicina;
        this.ean = ean;
        this.skupnaCena = BigDecimal.valueOf(kolicina).multiply(cena);
    }

    public BigDecimal getDavcnaStopnja() {
        return davcnaStopnja;
    }

    public void setDavcnaStopnja(BigDecimal davcnaStopnja) {
        this.davcnaStopnja = davcnaStopnja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public BigDecimal getCena() {
        return cena;
    }



    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
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
