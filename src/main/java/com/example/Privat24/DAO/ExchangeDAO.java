package com.example.Privat24.DAO;

import com.example.Privat24.models.Exchange;

import java.sql.Connection;

public class ExchangeDAO extends AbstractDAO<Exchange>{
    public ExchangeDAO(Connection conn, String table) {
        super(conn, table);
    }


}
