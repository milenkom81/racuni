import DAO.ArticleDao;
import DAO.DaoCrud;
import DAO.MySqlArticle;
import DAO.MySqlPodjetje;
import moji_razredi.*;
import si.um.feri.database.*;

import java.io.IOException;
import java.sql.Connection;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        Artikel voda = new Artikel("voda", new BigDecimal("1"), new BigDecimal("1.2"), 10, "1234567891");

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;


        HikariDataSource ds = DBHelper.connect(Helper.branje("povezava.json"));
        con = ds.getConnection();
//        pst = con.prepareStatement("SELECT * FROM Company");
//
//
//        String[][] eksel = DBHelper.read("Grocery_UPC_Database.xls");
//        DBHelper.dodajArtikleDB(eksel, con);


        MySqlArticle s = new MySqlArticle();
        MySqlPodjetje p = new MySqlPodjetje();
//        Artikel NOVI = s.getByBarcode("035200264013");

        //List<Artikel> lista = new ArrayList<>();

        //List<Artikel> rezultati = s.getAll(lista);

        Podjetje Union = new Podjetje(1,"Pivovarna Laško Union d.o.o.", true,"90355580","5049318000","Pivovarniška ulica 2");
        Podjetje sava = new Podjetje(2,"HENKEL MARIBOR d.o.o.", true,"58665765","6261752000","Industrijska ulica 23,");
        Podjetje Akrapovic = new Podjetje(3,"Akrapovič d.d.", true,"95023828","1387570000","Malo Hudo 8A");
        Podjetje Nektar = new Podjetje(4,"Nektar d.d.", true,"95023828","1387570000","Malo Hudo 8A");
        Podjetje Delo = new Podjetje(5,"delo d.d.", true,"95023828","1387570000","Malo Hudo 8A");
        p.insert(Union);
        p.insert(sava);
        p.insert(Akrapovic);
        p.insert(Nektar);
        p.insert(Delo);


        // s.update(voda);


    }
}



