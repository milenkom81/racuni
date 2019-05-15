package si.um.feri.database;

import com.google.gson.Gson;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import moji_razredi.Helper;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBHelper {

    public static HikariDataSource connect(String json) {
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

                boolean test = Helper.checkDigit(data[1][i]);

//                if (test == true) {
//                    System.out.println(data[1][i]);
//                    System.out.println("Artikel z idjem " + Integer.parseInt(data[0][i]) + " ima napacno kodo");
//                }
                if (data[1][i].length() < 14) {
                    for (int a = 0; a < 14-data[0].length; a++) {
                        data[1][i] = "0" + data[1][i];
                    }
                }

                    updateemp.setInt(1, Integer.parseInt(data[0][i]));
                    updateemp.setString(2, data[1][i]);
                    updateemp.setString(3, data[4][i]);
                    updateemp.setInt(4, (int) (Math.random() * 100 + 1));
                    updateemp.setInt(5, 10);
                    updateemp.setInt(6, 1000);
                    updateemp.setBoolean(7, false);

                    updateemp.addBatch();


                int[] count = updateemp.executeBatch();

                if (i % 1000 == 0) {
                    con.commit();
                }
            }
        con.commit();
    };




    public static String[][] read(String inputFile) throws IOException {
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


}
