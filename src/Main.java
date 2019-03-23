import moji_razredi.Artikel;
import moji_razredi.Artikli;
import moji_razredi.Podjetje;
import moji_razredi.Racun;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Artikli seznam1 = new Artikli();
        Artikel pivo = new Artikel("pivo", new BigDecimal("2"), new BigDecimal("1.2"), 3, "1234567891");
        Artikel voda = new Artikel("pivo", new BigDecimal("1"), new BigDecimal("1.2"), 1, "1234567891");
        seznam1.getSeznamArtiklov().add(pivo);
        seznam1.getSeznamArtiklov().add(voda);

        Podjetje sava = new Podjetje("HENKEL MARIBOR d.o.o.", true,"58665765","6261752000","Industrijska ulica 23, Maribor, 2000 Maribor");


        Date trenutno = new Date();
        Racun skupaj = new Racun(seznam1,1,trenutno, "Janez novak", false,sava);

        boolean test = pivo.checkDigit("1291041500287");

        System.out.println(skupaj.toString());




    }
}



