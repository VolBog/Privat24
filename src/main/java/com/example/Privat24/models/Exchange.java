package com.example.Privat24.models;

import com.example.Privat24.shared.Id;

import java.util.List;

public class Exchange {
    @Id
    private int id;
    private String date;
    private String bank;
    private int baseCurrency;
    private String baseCurrencyLit;
    private List<ExchangeRate> exchangeRate;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }


    public String getBaseCurrencyLit() {
        return baseCurrencyLit;
    }

    public void setBaseCurrencyLit(String baseCurrencyLit) {
        this.baseCurrencyLit = baseCurrencyLit;
    }

    public int getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(int baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public List<ExchangeRate> getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(List<ExchangeRate> exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "date='" + date + '\'' +
                ", bank='" + bank + '\'' +
                ", baseCurrency=" + baseCurrency +
                ", baseCurrencyLit='" + baseCurrencyLit + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
