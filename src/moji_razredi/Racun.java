package moji_razredi;

import java.lang.Object;

public class Racun
{
    Artikli SeznamRacun;
    private int id;
    private double SkupnaCena;



    public Racun(Artikli seznamracun, int id) {
        this.id = id;
        this.SeznamRacun = seznamracun;
        this.SkupnaCena = 0;
        for(int i = 0; i<SeznamRacun.getSeznamArtiklov().size(); i++){
            this.SkupnaCena += (SeznamRacun.getSeznamArtiklov().get(i).getCena() * SeznamRacun.getSeznamArtiklov().get(i).getKolicina() * SeznamRacun.getSeznamArtiklov().get(i).getDavcnaStopnja()) ;
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

    public double getSkupnaCena() {
        return SkupnaCena;
    }

    public void setSkupnaCena(double skupnaCena) {
        for(int i = 0; i<SeznamRacun.getSeznamArtiklov().size(); i++){
            this.SkupnaCena += (SeznamRacun.getSeznamArtiklov().get(i).getCena() * SeznamRacun.getSeznamArtiklov().get(i).getKolicina() * SeznamRacun.getSeznamArtiklov().get(i).getDavcnaStopnja()) ;
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

                '}';
    }
}
