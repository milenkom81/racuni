package si.um.feri.database;

import com.google.gson.Gson;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.*;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import moji_razredi.Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.*;


public class DBHelper {

    public static Connection con;
    public static HikariDataSource h;
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public static HikariDataSource getH() {
        return h;
    }

    public static void setH(HikariDataSource h) {
        DBHelper.h = h;
    }

    public static HikariDataSource connect(String json) throws SQLException {
        HikariConfig config = new HikariConfig();

        Naslov connection = FromJson(json);
        //"jdbc:mysql://localhost:3306/sakila"
        config.setJdbcUrl(connection.getUrl());
        config.setUsername(connection.getUsername());
        config.setPassword(connection.getPassword());
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        con = ds.getConnection();
        h=ds;
        return ds;
    }

    public static Naslov FromJson(String json) {
        Gson gson = new Gson();
        Naslov target2 = gson.fromJson(json, Naslov.class);
        return target2;

    }

    public static void dodajArtikleDB(String[][] data, Connection con) throws SQLException {
        con.setAutoCommit(false);


        String SQL = "insert into Article values(?,?,?,?,?,?,?,NOW(),NOW())";
//
//// Create PrepareStatement object
//        PreparedStatemen pstmt = conn.prepareStatement(SQL);
//


        PreparedStatement updateemp = con.prepareStatement(
                SQL);

            for (int i = 1; i < data[0].length; i++) {


                if (data[2][i].length() < 12) {
                    for (int a = 0; a < 12-data[0].length; a++) {
                        data[2][i] = "0" + data[2][i];
                    }
                }

                boolean test = Helper.checkDigit(data[2][i]);

                if (test == false) {
                    System.out.println(data[2][i]);
                    System.out.println("Artikel z idjem " + Integer.parseInt(data[0][i]) + " ima napacno kodo");
                }


                if(test == true) {
                    updateemp.setInt(1, Integer.parseInt(data[0][i]));
                    updateemp.setString(2, data[2][i]);
                    updateemp.setString(3, data[4][i]);
                    updateemp.setInt(4, (int) (Math.random() * 100 + 1));
                    updateemp.setInt(5, 10);
                    updateemp.setInt(6, 1000);
                    updateemp.setBoolean(7, false);

                    updateemp.addBatch();
                }
                int[] count = updateemp.executeBatch();

                if (i % 1000 == 0) {
                    con.commit();
                }
            }
        con.commit();
    };




    public static String[][] read(String inputFile) throws IOException  {
        String[][] data = null;
        File inputWorkbook = new File(inputFile);
        Workbook w;

        try {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            data = new String[sheet.getColumns()][sheet.getRows()];
            // Loop over first 10 column and lines
            //     System.out.println(sheet.getColumns() +  " " +sheet.getRows());
            for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    data[j][i] = cell.getContents();
                    //  System.out.println(cell.getContents());
                }
            }

         /*   for (int j = 0; j < data.length; j++)
            {
                for (int i = 0; i <data[j].length; i++)
                {

                    System.out.println(data[j][i]);
                }
            } */

        } catch (BiffException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static List<List<String>> readCSVFile(String csvFileName,Connection con) throws IOException, SQLException {

        con.setAutoCommit(false);
        String SQL = "insert into Article values(?,?,?,?,?,?,?,NOW(),NOW())";


        String line = null;
        BufferedReader stream = null;
        List<List<String>> csvData = new ArrayList<List<String>>();
        List<String> tmp;
        try (PreparedStatement updateemp = con.prepareStatement(SQL);){
            stream = new BufferedReader(new FileReader(csvFileName));
            boolean flag = false;
            int i = 0;
            while ((line = stream.readLine()) != null) {
                String[] vrstica = line.split("\\s+");
                boolean test = Helper.checkDigit(vrstica[0]);

                if (test == false) {
                    System.out.println("Artikel z idjem " + vrstica[0] + " ima napacno kodo");
                }
                if (vrstica[0].length() < 13) {
                    for (int a = 0; a < 12-vrstica[0].length(); a++) {
                        vrstica[0] = "0" + vrstica[0];
                    }
                }



                if(flag == false && test ==true) {
                    flag = true;
                    updateemp.setInt(1, Integer.parseInt(vrstica[0]));
                    updateemp.setString(2, vrstica[0]);
                    updateemp.setString(3, vrstica[1]);
                    updateemp.setInt(4, (int) (Math.random() * 100 + 1));
                    updateemp.setInt(5, 10);
                    updateemp.setInt(6, 1000);
                    updateemp.setBoolean(7, false);

                    updateemp.addBatch();

                    int[] count = updateemp.executeBatch();
                    i++;
                    if (i % 1000 == 0) {
                        con.commit();
                    }
                }
                con.commit();
            }
        } finally {
            if (stream != null)
                stream.close();
        }

        return csvData;

    }




}
