package moji_razredi;
import java.math.BigDecimal;
import java.lang.Object;
import java.util.Date;


public class Racun
{
    private Artikli SeznamRacun;
    private int id;
    private BigDecimal SkupnaCena;
    private Date Datum;


    public Racun(Artikli seznamracun, int id, Date datum) {
        this.Datum = datum;
        this.id = id;
        this.SeznamRacun = seznamracun;
        this.SkupnaCena = new BigDecimal(0);
        for(int i = 0; i<SeznamRacun.getSeznamArtiklov().size(); i++){
            this.SkupnaCena = this.SkupnaCena.add(SeznamRacun.getSeznamArtiklov().get(i).getSkupnaCena());
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

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for(int i = 0; i<SeznamRacun.getSeznamArtiklov().size(); i++){
            buf.append(SeznamRacun.getSeznamArtiklov().get(i).toString()).append("s\n");
        }

        return "Racun: \n" + buf +
                " id=" + id +
                "\n SkupnaCena=" + SkupnaCena +

                "\n Datum=" + Datum +

                '}';
    }
}
