package si.um.feri.database;
import com.google.gson.Gson;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;




public class DBHelper {

    public static HikariDataSource connect(String json){
        HikariConfig config = new HikariConfig();

        Naslov connection =FromJson(json);
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

    public static Naslov FromJson(String json){
        Gson gson = new Gson();
            Naslov target2 = gson.fromJson(json, Naslov.class);
        return target2;

    }


}
