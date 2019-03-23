package moji_razredi;
import java.math.BigDecimal;
import java.lang.Object;
import java.util.Date;


public class Racun implements Searchable
{
    private Artikli SeznamRacun;
    private int id;
    private BigDecimal SkupnaCena;
    private Date Datum;
    private String Izdajatelj;
    boolean Originalni;
    private Podjetje PodjetjeRacun;
    private BigDecimal SkupniDDV;


    public Racun(Artikli seznamracun, int id, Date datum, String izdajatelj,boolean originalni, Podjetje podjetjeracun) {
        this.Originalni = originalni;
        this.Izdajatelj = izdajatelj;

        this.Datum = datum;
        this.id = id;
        this.SeznamRacun = seznamracun;
        this.SkupnaCena = new BigDecimal(0);
        this.SkupniDDV = new BigDecimal(0);
        for(int i = 0; i<SeznamRacun.getSeznamArtiklov().size(); i++){
            this.SkupnaCena = this.SkupnaCena.add(SeznamRacun.getSeznamArtiklov().get(i).getSkupnaCena());
        }
        this.PodjetjeRacun = podjetjeracun;
        for(int i = 0; i<SeznamRacun.getSeznamArtiklov().size(); i++){
            this.SkupniDDV = this.SkupniDDV.add(SeznamRacun.getSeznamArtiklov().get(i).getSkupniDDV());
        }

    }

    public Artikli getSeznamRacun() {
        return SeznamRacun;
    }

    public void setSeznamRacun(Artikli seznamRacun) {
        SeznamRacun = seznamRacun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSkupnaCena() {
        return SkupnaCena;
    }

    public void setSkupnaCena(BigDecimal skupnaCena) {
        for(int i = 0; i<SeznamRacun.getSeznamArtiklov().size(); i++){
            this.SkupnaCena.add(SeznamRacun.getSeznamArtiklov().get(i).getSkupnaCena().multiply(SeznamRacun.getSeznamArtiklov().get(i).getDavcnaStopnja()));
        }
    }

    public String getIzdajatelj() {
        return Izdajatelj;
    }

    public void setIzdajatelj(String izdajatelj) {
        Izdajatelj = izdajatelj;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }


    public boolean isOriginalni() {
        return Originalni;
    }

    public void setOriginalni(boolean originalni) {
        Originalni = originalni;
    }

    public Podjetje getPodjetjeRacun() {
        return PodjetjeRacun;
    }

    public void setPodjetjeRacun(Podjetje podjetjeRacun) {
        PodjetjeRacun = podjetjeRacun;
    }

    @Override
    public String toString() {
        return  this.getPodjetjeRacun().getIme() + "\n" +
                this.getPodjetjeRacun().getNaslov() + "\n" +
                this.getPodjetjeRacun().getDavcnaStevilka() + "\n" +
                "RACUN \n" +
                Datum + "\n" +

                "SeznamRacun=" + SeznamRacun + "\n" +
                "ddv=" + SkupniDDV + "\n" +
                "Skupaj z ddv=" + SkupnaCena + "\n" +
                "id=" + id + "\n" +
                "Blagajnik='" + Izdajatelj + '\''

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
