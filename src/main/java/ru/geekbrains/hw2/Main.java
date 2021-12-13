package ru.geekbrains.hw2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1");
        // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]
        int[] array4Task1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray(array4Task1);
        reverseArray(array4Task1);
        printArray(array4Task1);

        System.out.println("Задание №2");
        //Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] array4Task2 = new int[8];
        for (int i = 0; i < array4Task2.length; i++) {
            if (i == 0) {
                continue;
            } else {
                array4Task2[i] += array4Task2[i - 1] + 3;
            }
        }
        printArray(array4Task2);

        System.out.println("Задание №3");
        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] array4Task3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(array4Task3);
        for (int i = 0; i < array4Task3.length; i++) {
            array4Task3[i] = array4Task3[i] < 6 ? array4Task3[i] * 2 : array4Task3[i];
        }
        printArray(array4Task3);

        System.out.println("Задание №4");
        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] array4Task4 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        printArray(array4Task4);
        for (int i = 0; i < array4Task4.length; i++) {
            for (int j = 0; j < array4Task4[i].length; j++) {
                if ((i == j) || (j == array4Task4[j].length - 1 && i == 0) || (i == array4Task4[i].length - 1 && j == 0)) {
                    array4Task4[i][j] = 1;
                }
            }
        }
        System.out.println("");
        printArray(array4Task4);
        System.out.println("");

        System.out.println("Задание №5");
        //Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        Random random = new Random();
        int[] array4Task5 = new int[10];
        for (int i = 0; i < array4Task5.length; i++) {
            array4Task5[i] = random.nextInt(40) - 20;
        }
        printArray(array4Task5);
        findMaxMin(array4Task5);
        System.out.println("");

        System.out.println("Задание №6");
        //Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        int[] array4Task6 = {2, 2, 2, 1, 2, 2, 10, 1};
        if(checkOnHappy(array4Task6)){
            System.out.println("В массиве есть равные части!");
        }
    }

    public static void printArray(int[] printArray) {
        String printString = "";
        for (int i = 0; i < printArray.length; i++) {
            if (i == 0) {
                printString = printString + printArray[i];
            } else {
                printString = printString + "," + printArray[i];
            }
        }
        System.out.println("[" + printString + "]");
    }

    public static void printArray(int[][] printArray) {
        String printString = "";
        for (int i = 0; i < printArray.length; i++) {
            for (int j = 0; j < printArray[i].length; j++) {
                if (j == 0) {
                    printString = printString + printArray[i][j];
                } else {
                    printString = printString + "," + printArray[i][j];
                }
            }
            System.out.println("[" + printString + "]");
            printString = "";
        }
    }

    public static void reverseArray(int[] printArray) {
        for (int i = 0; i < printArray.length; i++) {
            printArray[i] = printArray[i] == 1 ? 0 : 1;
        }
    }

    public static void findMaxMin(int[] array) {
        int max = 0;
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        System.out.printf("Максимальное число в массиве: %d, минимальное число в массиве: %d", max, min);
    }

    public static boolean checkOnHappy(int[] array) {
        int summ = 0;
        int summSecond = 0;
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            summ += array[i];
            for (int j = (i + 1); j < array.length; j++) {
                summSecond += array[j];
            }
            if (summ == summSecond) {
                result = true;
            }
            summSecond = 0;
        }
        return result;
    }
}
