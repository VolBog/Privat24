package com.example.Privat24.Servise;

import com.example.Privat24.DAO.ExchangeRateDAO;
import com.example.Privat24.Utils.DataSource;
import com.example.Privat24.models.ExchangeRate;

import java.sql.SQLException;

public class ExchangeRateService {
    private static ExchangeRateDAO exchangeRateDAO = new ExchangeRateDAO(DataSource.getConnection(), "Exchange");
    public static String getLastDate(){
        String date = "";
        date = exchangeRateDAO.getLastDate();
        return date;
    }

    public static void add(ExchangeRate er){
            // exchangeRateDAO.createTable(ExchangeRate.class);
            exchangeRateDAO.add(er);
    }

    public static String getFirstDate(){
        String date = "";
        date = exchangeRateDAO.getFirstDate();
        return date;
    }

    public static String getAverage(String begin, String end){
        String date = "";
        date = exchangeRateDAO.getAverage(begin, end);
        return date;
    }

    public static double getDate(String date){
        return exchangeRateDAO.getDate(date);
    }
}
