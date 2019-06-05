import DAO.ArticleDao;
import DAO.DaoCrud;
import DAO.MySqlArticle;
import moji_razredi.*;
import si.um.feri.database.*;

import java.io.IOException;
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
//        Artikel NOVI = s.getByBarcode("035200264013");

        s.update(voda);


    }
}



