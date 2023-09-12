package com.ssz;

import java.util.Scanner;

public class HW3 {
    public static String[] FIRST_NAME;
    public static String[] LAST_NAME;
    public static String[] MIDDLE_NAME;
    public  static void readConsole(){
        while (true) {
            System.out.println
                    ("__________________________________________\n" +
                    "Введите данные\n" +
                    "Фамилия Имя Отчество датарождения номертелефона пол\n" +
                    "Форматы данных:\n" +
                    "фамилия, имя, отчество - строки\n" +
                    "датарождения - строка формата dd.mm.yyyy\n" +
                    "номертелефона - целое беззнаковое число без форматирования\n" +
                    "пол - символ латиницей f или m.\n" +
                    "-------------------------------------------\n");
            Scanner scanner = new Scanner(System.in);
            String inputSting = scanner.nextLine();
            if ("exit".equalsIgnoreCase(inputSting)) {
                System.exit(0);
            }
            inputSting = removeFirstEndAndDoubleSpace(inputSting);
            String[] dataArray = inputSting.toUpperCase().split(" ");
            checkDataArray(dataArray);
        }
    }

    public static String removeFirstEndAndDoubleSpace(String str)
    {
        if (str == null || str.length() == 0) {
            return str;
        }

        while (str.startsWith(" ") || str.endsWith(" ") || str.contains("  ")) {
            if (str.startsWith(" ")) {
                str = str.substring(1);
            }
            if (str.endsWith(" ")) {
                str = str.substring(0, str.length() - 1);
            }
            str = str.replaceAll("  ", " ");
        }
        return str.toUpperCase();
    }

    public static void checkDataArray(String[] dataArray) {
        try {
            Person person = new Person(dataArray);
            ReadWriteFile.writeFile(person.getPersonLastname(), person.toString()+"\r\n");
        } catch (UserDataError ignored) {}

    }




    public static void main(String[] args) {
        /**
         * Можно было сделать валидацию по окончаниям но решил сделать максимально по тупому
         * Валидация окончаний не всегда корректно отработает
         */
        //имя
        FIRST_NAME = ReadWriteFile.readSettings("first.properties", "first_name");
        //фамилия
        LAST_NAME = ReadWriteFile.readSettings("last.properties", "last_name");
        //отчество
        MIDDLE_NAME = ReadWriteFile.readSettings("middle.properties", "middle_name");
        readConsole();

        //test string
        //Зеленцов Сергей Сергеевич 29.07.1985 89626666663 M
        //Зеленцов  29.07.1985 89626666663 M Сергей
        //Иванов 1.02.1320 F Иванович  4343
    }


}
