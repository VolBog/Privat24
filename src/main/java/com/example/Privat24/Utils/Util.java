package com.example.Privat24.Utils;

import com.example.Privat24.models.Exchange;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Util {

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static Exchange getExchange(String date) {

        String json = null;
        try {
            json = readUrl(" https://api.privatbank.ua/p24api/exchange_rates?json&date=" + date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(json);
        Gson gson = new Gson();
        Exchange exchange = gson.fromJson(json, Exchange.class);

        //   System.out.println(exchange);
        return exchange;
    }

    public static boolean isCorrect(String date){
        String[] dates = date.split("[.]");

        int day;
        int mounth;
        int year;

        try {
            day = Integer.parseInt(dates[0]);
            mounth = Integer.parseInt(dates[1]);
            year = Integer.parseInt(dates[2]);
        } catch (Exception e){
            return false;
        }
        if(day > 31 || day < 1){
            return false;
        }
        if(mounth > 12 || mounth < 1){
            return false;
        }
        if(year < 2011 || year > 2022){
            return false;
        }
        return true;
    }
}
