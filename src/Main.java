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

    public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {


        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;


        HikariDataSource ds = DBHelper.connect(Helper.branje("povezava.json"));
        con = ds.getConnection();
        pst = con.prepareStatement("SELECT * FROM Company");


        String[][] eksel = DBHelper.read("Grocery_UPC_Database.xls");
        DBHelper.dodajArtikleDB(eksel, con);
//       DBHelper.readTXTFile("/home/jasak/Downloads/en.openfoodfacts.org.products.csv",con);


//        PreparedStatement updateemp = con.prepareStatement(
//                "insert into Article values(?,?,?,?,?,?,?,NOW(),NOW())");
//        updateemp.setInt(1,Integer.parseInt(eksel[0][4000]));
//        updateemp.setString(2,eksel[1][4000]);
//        updateemp.setString(3, eksel[2][4000]);
//        updateemp.setInt(4,23);
//        updateemp.setInt(5,22);
//        updateemp.setInt(6, 10);
//        updateemp.setBoolean(7,false);
//        updateemp.executeUpdate();

    }
}



