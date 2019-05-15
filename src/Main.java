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
import java.sql.SQLException;
import java.io.*;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.crypto.spec.DHGenParameterSpec;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {


        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;


        HikariDataSource ds = DBHelper.connect(Helper.branje("povezava.json"));
        con = ds.getConnection();
        pst = con.prepareStatement("SELECT * FROM Company");
//        rs = pst.executeQuery();
//        while (rs.next()) {
//            System.out.format("%d %s", rs.getInt(1), rs.getString(2));
//        }




        String[][] eksel = DBHelper.read("Grocery_UPC_Database.xls");

        DBHelper.dodajArtikleDB(eksel,con);

//        System.out.println(Helper.checkDigit("35200261232"));



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



