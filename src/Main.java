import moji_razredi.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Artikli seznam1 = new Artikli();
//        Artikel pivo = new Artikel("pivo", new BigDecimal("2"), new BigDecimal("1.2"), 3, "1234567891");
        Artikel voda = new Artikel("voda", new BigDecimal("1"), new BigDecimal("1.2"), 1, "1234567891");
//
        Artikel krompir = new Artikel("krompir", new BigDecimal("1.1"), new BigDecimal("1.2"), 1, "212456789001");


        Artikel jabolko = new Artikel("jabolko", new BigDecimal("0.8"), new BigDecimal("1.2"), 1, "211456719001");

        Artikel prsut = new Artikel("prsut", new BigDecimal("9.8"), new BigDecimal("1.2"), 1, "211456749001");
//
        seznam1.getSeznamArtiklov().add(krompir);
        seznam1.getSeznamArtiklov().add(jabolko);
        seznam1.getSeznamArtiklov().add(prsut);
        seznam1.getSeznamArtiklov().add(voda);
//
        Companies seznam2 = new Companies();
//
	    Podjetje Union = new Podjetje("Pivovarna Laško Union d.o.o.", true,"90355580","5049318000","Pivovarniška ulica 2, Ljubljana, 1000 Ljubljana");

	    Podjetje Akrapovic = new Podjetje("Akrapovič d.d.", true,"95023828","1387570000","Malo Hudo 8A, Malo Hudo, 1295 Ivančna Gorica");
//
//        seznam2.getSeznamPodjetji().add(Union);
//
        Date trenutno = new Date();
        Racun skupaj = new Racun(seznam1,1,trenutno, "Janez novak", false,Union);
//
//        System.out.println(seznam1.toJSON());
//        String aa = seznam1.toJSON();
//
//        String bb = seznam2.toJSON();
//        Artikli testi = seznam1.fromJSON(aa);
//
//        Helper ja = new Helper("helper");
//        ja.pisanje(bb,"bb.json");
//
//
//        boolean test = ja.checkDigit("1291041500287");
//


        System.out.println(skupaj.toString());
    }
}



