package com.example.Privat24.Utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl( "jdbc:mysql://localhost/privat" );
        config.setUsername( "root" );
        config.setPassword( "321456" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "10" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.addDataSourceProperty("useSSL",false);
        ds = new HikariDataSource( config );
    }

    private DataSource() {}

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
