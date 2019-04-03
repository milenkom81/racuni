package moji_razredi;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;





public class Artikel implements Searchable {
    private int kolicina;
    private String ime;
    private BigDecimal cena;
    private BigDecimal davcnaStopnja;
    private String ean;
    private boolean internaKoda;
    private BigDecimal teza;

    public BigDecimal getTeza() {
        return teza;
    }

    public void setTeza(BigDecimal teza) {
        this.teza = teza.divide(new BigDecimal(1000));
        String stringTeza = teza.toString();
        this.setEan(ean.substring(0,6)+stringTeza+ean.substring(11));

        this.skupnaCena = teza.divide(new BigDecimal(1000)).multiply(cena).multiply(davcnaStopnja).setScale(2, RoundingMode.CEILING);
    }

    String[][] oddelki = new String[][]{
            { "211", "Sadje"},
            { "212", "Zelenjava"},
            { "213", "Kruh"},
            { "214", "Meso"}

    };



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
        this.skupnaCena = BigDecimal.valueOf(kolicina).multiply(cena.multiply(davcnaStopnja)).setScale(2, RoundingMode.CEILING);;

        if(this.preveriInterni()){
            teza = new BigDecimal(this.getEan().substring(7,11)).divide(new BigDecimal(1000));
            this.skupnaCena = teza.multiply(cena).multiply(davcnaStopnja).setScale(2, RoundingMode.CEILING);

            this.skupniDDV = teza.multiply(cena).multiply(davcnaStopnja).setScale(2, RoundingMode.CEILING).subtract(teza.multiply(cena).setScale(2, RoundingMode.CEILING));
        }
        else {
            this.skupniDDV = BigDecimal.valueOf(kolicina).multiply(cena.multiply(davcnaStopnja.divide(new BigDecimal(10))));
        }
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
        if(preveriInterni()){
            return teza + " kg " +
                    ime  +
                    " " + cena + "€ " +

                    "Skupaj+DDV " + skupnaCena + "€ \n";


        }
        else {

            return
                    kolicina +
                            "x " + ime +
                            " " + cena + "€ " +

                            "Skupaj+DDV " + skupnaCena + "€ \n";
        }
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

    public boolean preveriInterni(){

        String b = this.getEan().substring(0,3);
        for(int i=0; i< 4; i++){
            if(b.equals(oddelki[i][0])){
                return true;

            }
        }
        return false;

    }







}
