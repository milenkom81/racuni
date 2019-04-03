package moji_razredi;
import java.math.BigDecimal;
import java.lang.Object;
import java.util.Date;


public class Racun implements Searchable
{
    private Artikli seznamRacun;
    private int id;
    private BigDecimal skupnaCena;
    private Date datum;
    private String izdajatelj;
    boolean originalni;
    private Podjetje podjetjeRacun;
    private BigDecimal skupniDDV;


    public Racun(Artikli seznamracun, int id, Date datum, String Izdajatelj,boolean Originalni, Podjetje Podjetjeracun) {
        this.originalni = Originalni;
        this.izdajatelj = Izdajatelj;

        this.datum = datum;
        this.id = id;
        this.seznamRacun = seznamracun;
        this.skupnaCena = new BigDecimal(0);
        this.skupniDDV = new BigDecimal(0);
        for(int i = 0; i<seznamRacun.getSeznamArtiklov().size(); i++){
            this.skupnaCena = this.skupnaCena.add(seznamRacun.getSeznamArtiklov().get(i).getSkupnaCena());
        }
        this.podjetjeRacun = Podjetjeracun;
        for(int i = 0; i<seznamRacun.getSeznamArtiklov().size(); i++){
            this.skupniDDV = this.skupniDDV.add(seznamRacun.getSeznamArtiklov().get(i).getSkupniDDV());
        }

    }

    public Artikli getSeznamRacun() {
        return seznamRacun;
    }

    public void setSeznamRacun(Artikli seznamRacun) {
        seznamRacun = seznamRacun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSkupnaCena() {
        return skupnaCena;
    }

    public void setSkupnaCena() {
        for(int i = 0; i<seznamRacun.getSeznamArtiklov().size(); i++){
            this.skupnaCena.add(seznamRacun.getSeznamArtiklov().get(i).getSkupnaCena().multiply(seznamRacun.getSeznamArtiklov().get(i).getDavcnaStopnja()));
        }
    }

    public String getIzdajatelj() {
        return izdajatelj;
    }

    public void setIzdajatelj(String Izdajatelj) {
        izdajatelj = Izdajatelj;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date Datum) {
        datum = Datum;
    }


    public boolean isOriginalni() {
        return originalni;
    }

    public void setOriginalni(boolean Originalni) {
        originalni = Originalni;
    }

    public Podjetje getPodjetjeRacun() {
        return podjetjeRacun;
    }

    public void setPodjetjeRacun(Podjetje PodjetjeRacun) {
        podjetjeRacun = PodjetjeRacun;
    }

    @Override

    public String toString() {


        String skupajVse = "";
        for (int i = 0; i < this.seznamRacun.getSeznamArtiklov().size(); i++) {
            skupajVse += this.seznamRacun.getSeznamArtiklov().get(i).toString();
        }

        return this.getPodjetjeRacun().getIme() + "\n" +
                this.getPodjetjeRacun().getNaslov() + "\n" +
                this.getPodjetjeRacun().getDavcnaStevilka() + "\n" +
                "RACUN \n" +
                datum + "\n" +

                "\n"  + skupajVse +"\n" +
                "ddv:" + skupniDDV + "\n" +
                "Skupaj z ddv: " + skupnaCena + "\n" +
                "id: " + id + "\n" +
                "Blagajnik: '" + izdajatelj + '\''

                ;
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
