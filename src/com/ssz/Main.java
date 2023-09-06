package com.ssz;

import java.util.Scanner;

public class Main {

    public static String readConsole(String consoleMessage){
        if (consoleMessage == null){
            consoleMessage="";
        }
        System.out.println(consoleMessage);
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        if ("".contains(inputString)){
            throw new NoSuchEmptyInputException("Пустые строки вводить нельзя");
        }
        /**
         * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
         * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
         */
        return inputString;
    }

    public static void readFloatToConsole(){
        /**
         * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float)
         * , и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
         * приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
         */
        while (true) {
            try {
                String inputString = readConsole("Введите дробное число типа float");
                float f = Float.parseFloat(inputString);
                System.out.println("вы ввели числло " + f);
                return;
            } catch (NumberFormatException ignored) {}
        }
    }
    public static void task2(){
        /**
         *Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
         * нехватало объявления массива ну и IndexOutOfBoundsException
         */
        int [] intArray = {0,1,2,3,4,5,6,7,8};
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    public static void main(String[] args) {
        readFloatToConsole();
    }

}
