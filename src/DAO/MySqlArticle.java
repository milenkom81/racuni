package DAO;


import moji_razredi.Artikel;
import si.um.feri.database.DBHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MySqlArticle implements ArticleDao {
    final String TABLE_NAME = "Article";


    final String SQL_GET_ALL = "SELECT * FROM " + TABLE_NAME;
    final String SQL_GET_BY_CODE = "SELECT * FROM " + TABLE_NAME + " WHERE barcode = ? LIMIT 1";
    final String SQL_INSERT = "insert into Article values(?,?,?,?,?,?,?,NOW(),NOW())";
    final String SQL_UPDATE = " UPDATE Article SET name = ? , price = ? , vat = ? , stock = ? WHERE barcode = ? ";
    final String SQL_DELETE = "DELETE FROM " + TABLE_NAME + " WHERE barcode = ? LIMIT 1";

    public List<Artikel> getAll(List<Artikel> lista) {

        try (Connection conn = DBHelper.getH().getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_GET_ALL)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Artikel temp = extractFromResultSet(rs);
                lista.add(temp);
            }
        return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Artikel getByBarcode(String code) {
        try (Connection conn = DBHelper.getH().getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_GET_BY_CODE)) {
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();

            if (rs.first())
                return extractFromResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Artikel ar) throws SQLException {
        try (Connection conn = DBHelper.getH().getConnection();
             PreparedStatement updateemp = conn.prepareStatement(SQL_INSERT)) {
            updateemp.setInt(1, 400000);
            updateemp.setString(2, ar.getEan());
            updateemp.setString(3, ar.getIme());
            updateemp.setInt(4, 1);
            updateemp.setInt(5, 1);
            updateemp.setInt(6, ar.getKolicina());
            updateemp.setBoolean(7, false);
            boolean rs = updateemp.execute();

            if (rs == true)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(Artikel ar) {
        try (Connection conn = DBHelper.getH().getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {

            ;
            ps.setString(1, ar.getIme());
            ps.setBigDecimal(2, ar.getCena());
            ps.setBigDecimal(3, ar.getDavcnaStopnja());
            ps.setInt(4, ar.getKolicina());
            ps.setString(5, "121"); // article_id BINARY(16) NOT NULL

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Artikel a) {
        try (Connection conn = DBHelper.getH().getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_DELETE)) {

            ps.setString(1, a.getEan()); // article_id BINARY(16) NOT NULL

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Artikel extractFromResultSet(ResultSet rs) throws SQLException {
        String barcode = rs.getString("barcode");
        String name = rs.getString("name");
        BigDecimal price = rs.getBigDecimal("price");
        BigDecimal vat = rs.getBigDecimal("vat");
        int stock = rs.getInt("stock");
        return new Artikel(name, price, vat, stock, barcode);
//        String ime, BigDecimal cena, BigDecimal davcnaStopnja, int kolicina, String ean
    }
}
