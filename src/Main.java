import moji_razredi.Artikel;
import moji_razredi.Artikli;
import moji_razredi.Racun;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        Artikli seznam1 = new Artikli();
        Artikel pivo = new Artikel("pivo", 2.2, 1.22, 1, 1234567891);
        Artikel zemlja = new Artikel("zemlja", 0.2, 1.095, 3, 1233567891);
        Artikel moka = new Artikel("moka", 1, 1.095, 1, 1233567892);
        seznam1.getSeznamArtiklov().add(pivo);
        seznam1.getSeznamArtiklov().add(zemlja);
        seznam1.getSeznamArtiklov().add(moka);

        Racun racun1 = new Racun(seznam1, 1);

        System.out.print(racun1.toString());



    }
}



