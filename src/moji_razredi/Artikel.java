package moji_razredi;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Artikel implements Searchable {
    private int kolicina;
    private String ime;
    private BigDecimal cena;
    private BigDecimal davcnaStopnja;
    private String ean;

    public BigDecimal getSkupniDDV() {
        return skupniDDV;
    }

    public void setSkupniDDV(BigDecimal skupniDDV) {
        this.skupniDDV = skupniDDV;
    }

    private BigDecimal skupnaCena;
    private BigDecimal skupniDDV;

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
        this.skupnaCena = BigDecimal.valueOf(kolicina).multiply(cena.multiply(davcnaStopnja));
        this.skupniDDV = BigDecimal.valueOf(kolicina).multiply(cena.multiply(davcnaStopnja.divide(new BigDecimal(10))));
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
                ", ean='" + ean + '\'' +
                ", skupnaCena=" + skupnaCena +
                '}';
    }
    public boolean search(String niz) {
        int isExists = this.toString().indexOf(niz);
        if (isExists >= 0){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkDigit(String preveri) {
        int intArray[] = new int[preveri.length()];
        int vsota = 0;
        for (int i = 0; i < preveri.length(); i++) {
            intArray[i] = Character.digit(preveri.charAt(i), 10);
            if(i % 2 == 1){
                intArray[i] = 3 * intArray[i];
            }
            if(i != preveri.length() -1) {
                vsota = vsota + intArray[i];
            }
        }
        int zaokrozeno = vsota;
        int zadnastevilka = intArray[preveri.length()-1];
        if(vsota % 10 != 0){
            int a = vsota % 10;
            int ab =  10 - a;
            zaokrozeno = vsota +ab;

        }

        if(zadnastevilka == zaokrozeno - vsota) {
            return true;
        }
        else{
            return false;
        }
    }





}
