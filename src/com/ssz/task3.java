package com.ssz;

import java.io.FileNotFoundException;

public class task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        }
        catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

        //NullPointerException и IndexOutOfBoundsException наследуются от классов унаследованных от
        //Throwable два последних блока никогда не сработают(программа тоже не запустится если их не переставить
        //прокидывать Exception в мейн так же нет смысла по той же причине
    }
    public static void printSum(Integer a, Integer b) {
        // нет работы с файлами в методе FileNotFoundException  не требуется
        System.out.println(a + b);
    }
}

