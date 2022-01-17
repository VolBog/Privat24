package com.example.Privat24;

import com.example.Privat24.Servise.ExchangeRateService;
import com.example.Privat24.Utils.Privat24API;
import com.example.Privat24.Utils.Util;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Privat24API getDataThread = new Privat24API();
        Thread thread = new Thread(getDataThread);
        thread.start();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Опція 1 вивести за певну дату");
            System.out.println("Опція 2 вивести за проміжок");
            if (sc.nextInt() == 1) {
                System.out.println("Для того щоб вивести ціну за дату від " + ExchangeRateService.getLastDate() + "до дати " + ExchangeRateService.getFirstDate());
                System.out.println("Введіть першу дату в форматі DD.MM.YEAR");
                String date = sc.next();
                if (Util.isCorrect(date) ) {
                    System.out.println("ціна долара в той день: " + ExchangeRateService.getDate(date));
                } else {
                    System.out.println("Формат введених даних не Правильний");
                }
            } else {

                System.out.println("Для того щоб вивести середнє з будь яких дат для  курсу валют від дати " + ExchangeRateService.getLastDate() + "до дати " + ExchangeRateService.getFirstDate());
                System.out.println("Введіть першу дату в форматі DD.MM.YEAR");
                String begin = sc.next();
                System.out.println("Введіть другу дату в форматі DD.MM.YEAR");
                String end = sc.next();
                if (Util.isCorrect(begin) && Util.isCorrect(end)) {
                    System.out.println(ExchangeRateService.getAverage(begin, end));
                } else {
                    System.out.println("Формат введених даних не Правильний");
                }
            }
        }
    }
}
