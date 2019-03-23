package moji_razredi;

public class Podjetje implements Searchable {
    private String Ime;
    private Boolean DavcniZavezanec;
    private String DavcnaStevilka;
    private String MaticnaStevilka;
    private String Naslov;

    public Podjetje(String ime, Boolean davcniZavezanec, String davcnaStevilka, String maticnaStevilka, String naslov) {
        Ime = ime;
        DavcniZavezanec = davcniZavezanec;
        DavcnaStevilka = davcnaStevilka;
        MaticnaStevilka = maticnaStevilka;
        Naslov = naslov;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public Boolean getDavcniZavezanec() {
        return DavcniZavezanec;
    }

    public void setDavcniZavezanec(Boolean davcniZavezanec) {
        DavcniZavezanec = davcniZavezanec;
    }

    public String getDavcnaStevilka() {
        return DavcnaStevilka;
    }

    public void setDavcnaStevilka(String davcnaStevilka) {
        DavcnaStevilka = davcnaStevilka;
    }

    public String getMaticnaStevilka() {
        return MaticnaStevilka;
    }

    public void setMaticnaStevilka(String maticnaStevilka) {
        MaticnaStevilka = maticnaStevilka;
    }

    public String getNaslov() {
        return Naslov;
    }

    public void setNaslov(String naslov) {
        Naslov = naslov;
    }

    @Override
    public String toString() {
        return "Podjetje{" +
                "Ime='" + Ime + '\'' +
                ", DavcniZavezanec=" + DavcniZavezanec +
                ", DavcnaStevilka='" + DavcnaStevilka + '\'' +
                ", MaticnaStevilka='" + MaticnaStevilka + '\'' +
                ", Naslov='" + Naslov + '\'' +
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
}
