package DAO;

import moji_razredi.Artikel;
import moji_razredi.Podjetje;
import si.um.feri.database.DBHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlPodjetje implements CompanyDao {
    final String TABLE_NAME = "Company";


    final String SQL_GET_ALL = "SELECT * FROM " + TABLE_NAME;
    final String SQL_GET_BY_DAVCNA = "SELECT * FROM " + TABLE_NAME + " WHERE taxpayer = ? LIMIT 1";
    final String SQL_INSERT = "insert into Company values(?,?,?,?,?,?,?,?,NOW(),NOW())";
    final String SQL_UPDATE = " UPDATE Company SET name = ? , adress = ? , registration_number = ? , taxpayer = ? WHERE tax_number = ? ";
    final String SQL_DELETE = "DELETE FROM " + TABLE_NAME + " WHERE tax_number = ? LIMIT 1";

    public List<Podjetje> getAll(List<Podjetje> lista) {

        try (Connection conn = DBHelper.con;
             PreparedStatement ps = conn.prepareStatement(SQL_GET_ALL)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Podjetje temp = extractFromResultSet(rs);
                lista.add(temp);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Podjetje getByDavcna(String code) {
        try (Connection conn = DBHelper.getH().getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_GET_BY_DAVCNA)) {
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
    public boolean insert(Podjetje ar) throws SQLException {
        try (Connection conn = DBHelper.getH().getConnection();
             PreparedStatement updateemp = conn.prepareStatement(SQL_INSERT)) {
            updateemp.setInt(1, ar.getId());
            updateemp.setString(2, ar.getIme());
            updateemp.setString(3, ar.getDavcnaStevilka());
            updateemp.setString(4, ar.getMaticnaStevilka());
            updateemp.setString(5, ar.getNaslov());

            updateemp.setBoolean(6, ar.getDavcniZavezanec());
            updateemp.setString(7, ar.getNaslov());
            updateemp.setBoolean(8, false);
            boolean rs = updateemp.execute();

            if (rs == true)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(Podjetje ar) {
        try (Connection conn = DBHelper.getH().getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, ar.getIme());
            ps.setString(2, ar.getNaslov());
            ps.setString(3, ar.getMaticnaStevilka());
            ps.setBoolean(4, ar.getDavcniZavezanec());
            ps.setString(5, ar.getDavcnaStevilka()); // article_id BINARY(16) NOT NULL

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Podjetje a) {
        try (Connection conn = DBHelper.getH().getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_DELETE)) {

            ps.setString(1, a.getDavcnaStevilka()); // article_id BINARY(16) NOT NULL

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Podjetje extractFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("idCompany");
        String ime = rs.getString("name");
        boolean davcni = rs.getBoolean("taxpayer");
        String davcna = rs.getString("tax_number");
        String maticna = rs.getString("registration_number");
        String naslov = rs.getString("address");
        return new Podjetje(id,ime, davcni, davcna, maticna, naslov);
//        String ime, BigDecimal cena, BigDecimal davcnaStopnja, int kolicina, String ean
    }
}
