package com.example.Privat24.Utils;

import com.example.Privat24.Servise.ExchangeRateService;
import com.example.Privat24.models.Exchange;
import com.example.Privat24.models.ExchangeRate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Privat24API implements Runnable {
    private boolean isRun = false;

    @Override
    public void run() {
        if (isRun) {
            return;
        }
        synchronized (this) {
            isRun = true;
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);


            String lastDate = ExchangeRateService.getLastDate();
            LocalDate calendar = null;
            if (lastDate == null) {
                calendar = LocalDate.now();
            } else {
                calendar = LocalDate.parse(lastDate, format);
            }

            for (int i = 0; i < 1000; i++) {
                String formatter = format.format(calendar);
                Exchange exchange = Util.getExchange(format.format(calendar).toString());

                for (ExchangeRate er :
                        exchange.getExchangeRate()) {
                    er.setDate(format.format(calendar));
                    ExchangeRateService.add(er);
                }
                calendar = calendar.minusDays(1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            isRun = false;
        }
    }
}
