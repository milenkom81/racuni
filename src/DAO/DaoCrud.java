package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface DaoCrud<T> {

    boolean insert(T m) throws SQLException;
    boolean update(T m) throws SQLException;
    boolean delete(T m) throws SQLException;

    T extractFromResultSet(ResultSet rs) throws SQLException;
}