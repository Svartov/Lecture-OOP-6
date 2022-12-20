package Leks6;

import java.util.Random;

public class Summa implements Runnable {

    private int[] array;
    private int n;
    private long sum = 0;

    public Summa(int[] arrayNum) {
        super();
        this.array = arrayNum;
        this.n = n;
    }

    public Summa() {
        super();
    }

    public static void shellSort(int[] array) {
        int inner, outer;
        int temp;

        int h = 1;
        // ищем начальное значение h
        while (h <= array.length / 3) {
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
        }

        while (h > 0) {
            //сдвигаемся на 1 шаг, для h-сортировки следующей группы элементов
            for (outer = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;
                //сортируем массив с шагом h
                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            //на каждом шаге уменьшаем h
            h = (h - 1) / 3;
        }
    }



    @Override
    public void run() {
        int n = 10;
        int[] array = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(n*5);
            System.out.print(array[i] + " ");
        }

        System.out.println();
        Thread thr = Thread.currentThread();
        shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
