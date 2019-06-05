package moji_razredi;

public class Podjetje implements Searchable {
    private int id;
    private String ime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Boolean davcniZavezanec;
    private String davcnaStevilka;
    private String maticnaStevilka;
    private String naslov;

    public Podjetje(int Id, String Ime, Boolean DavcniZavezanec, String DavcnaStevilka, String MaticnaStevilka, String Naslov) {
        id = Id;
        ime = Ime;
        davcniZavezanec = DavcniZavezanec;
        davcnaStevilka = DavcnaStevilka;
        maticnaStevilka = MaticnaStevilka;
        naslov = Naslov;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String Ime) {
        ime = Ime;
    }

    public Boolean getDavcniZavezanec() {
        return davcniZavezanec;
    }

    public void setDavcniZavezanec(Boolean DavcniZavezanec) {
        davcniZavezanec = DavcniZavezanec;
    }

    public String getDavcnaStevilka() {
        return davcnaStevilka;
    }

    public void setDavcnaStevilka(String DavcnaStevilka) {
        davcnaStevilka = DavcnaStevilka;
    }

    public String getMaticnaStevilka() {
        return maticnaStevilka;
    }

    public void setMaticnaStevilka(String MaticnaStevilka) {
        maticnaStevilka = MaticnaStevilka;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String Naslov) {
        naslov = Naslov;
    }

    @Override
    public String toString() {
        return "Podjetje{" +
                "Ime='" + ime + '\'' +
                ", DavcniZavezanec=" + davcniZavezanec +
                ", DavcnaStevilka='" + davcnaStevilka + '\'' +
                ", MaticnaStevilka='" + maticnaStevilka + '\'' +
                ", Naslov='" + naslov + '\'' +
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
