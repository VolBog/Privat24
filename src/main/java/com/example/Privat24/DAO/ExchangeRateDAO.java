package com.example.Privat24.DAO;

import com.example.Privat24.models.ExchangeRate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExchangeRateDAO extends AbstractDAO<ExchangeRate> {
    public ExchangeRateDAO(Connection conn, String table) {
        super(conn, table);
    }

    public String getLastDate() {
        String date = null;
        try (Statement st = super.getConn().createStatement();
             ResultSet rs = st.executeQuery("SELECT date FROM " + super.getTable() + " ORDER BY id DESC LIMIT 1;")) {
           rs.next();
            date = rs.getString("date");
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }
        return date;
    }

    public String getFirstDate() {
        String date = null;
        try (Statement st = super.getConn().createStatement();
             ResultSet rs = st.executeQuery("SELECT date FROM " + super.getTable() + " ORDER BY id LIMIT 1;")) {
            rs.next();
            date = rs.getString("date");
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }
        return date;
    }

    public String getAverage(String begin, String end) {
        String date = null;
        try (Statement st = super.getConn().createStatement();
             ResultSet rs = st.executeQuery("SELECT AVG(saleRate) FROM " + super.getTable() + " WHERE date BETWEEN + '"+ begin +"' and '" + end + "' and currency = 'USD';")) {
            rs.next();
            date = rs.getString("AVG(saleRate)");
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }
        return date;
    }

    public double getDate(String date) {
        double data = 0;
        try (Statement st = super.getConn().createStatement();
             ResultSet rs = st.executeQuery("SELECT saleRate FROM " + super.getTable() + " WHERE date = '" + date + "' and currency = 'USD';")) {
            rs.next();
            data  = rs.getDouble("saleRate");
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }
        return data;
    }
}
