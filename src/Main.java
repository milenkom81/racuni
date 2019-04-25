import moji_razredi.*;
import si.um.feri.database.*;

import java.sql.Connection;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Date;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, SQLException {

//        Artikli seznam1 = new Artikli();
//
//        Artikel voda = new Artikel("voda", new BigDecimal("1"), new BigDecimal("1.2"), 1, "1234567891");
////
//        Artikel krompir = new Artikel("krompir", new BigDecimal("1.1"), new BigDecimal("1.2"), 1, "212456789001");
//
//
//        Artikel jabolko = new Artikel("jabolko", new BigDecimal("0.8"), new BigDecimal("1.2"), 1, "211456719001");
//
//        Artikel prsut = new Artikel("prsut", new BigDecimal("9.8"), new BigDecimal("1.2"), 1, "211456749001");
////
//        seznam1.getSeznamArtiklov().add(krompir);
//        seznam1.getSeznamArtiklov().add(jabolko);
//        seznam1.getSeznamArtiklov().add(prsut);
//        seznam1.getSeznamArtiklov().add(voda);
////
//        Companies seznam2 = new Companies();
////
//        Podjetje Union = new Podjetje("Pivovarna Laško Union d.o.o.", true, "90355580", "5049318000", "Pivovarniška ulica 2, Ljubljana, 1000 Ljubljana");
//
//        Podjetje Akrapovic = new Podjetje("Akrapovič d.d.", true, "95023828", "1387570000", "Malo Hudo 8A, Malo Hudo, 1295 Ivančna Gorica");
////
////        seznam2.getSeznamPodjetji().add(Union);
////
//        Date trenutno = new Date();
//        Racun racun = new Racun(seznam1, 1, trenutno, "Janez novak", false, Union);
////
//        ;
////
////
////        boolean test = ja.checkDigit("1291041500287");
////
//
//        Kupon deset = new Kupon("9120050550");
//
////        System.out.println(racun.toString());
//
//        racun.setPopust(deset);
//
//
//        System.out.println(racun.toString());
//
//        String json = seznam1.toJSON();
//
//        System.out.println(json);
//
//        Helper helper = new Helper("helper");
//
//        helper.pisanje(json, "primer.json");
//
//        String json_string = helper.branje("primer.json");
//
//
//        Artikli kopija_seznama = new Artikli().fromJSON(json_string);

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;


        HikariDataSource ds = DBHelper.connect(Helper.branje("povezava.json"));
        con = ds.getConnection();
        pst = con.prepareStatement("SELECT * FROM actor");
        rs = pst.executeQuery();
        System.out.println(rs);

        String sql = "SELECT * FROM Cars";




    }
}



