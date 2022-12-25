package Leks6;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args){

        Random rn = new Random();
        Thread thread1 = Thread.currentThread();

        System.out.println("ID: " + thread1.getId() + ", Name: " + thread1.getName() + ", start");

        int[] array = new int[500000];
        for(int i = 0; i < array.length; i++){
            array[i] = rn.nextInt( 250);
        }

        long start = System.currentTimeMillis();
        long sumInOneStream  = CalculateSum.calculateSum(array);
        long finish = System.currentTimeMillis();

        System.out.println(finish - start + " MS [sum - " + sumInOneStream);

        start = System.currentTimeMillis();

        Summa sum1 = new Summa(array,0,500);
        Summa sum2 = new Summa(array,50,50000);
        Summa sum3 = new Summa(array,500,500000);
        Summa sum4 = new Summa(array,500,500000);
        Summa sum5 = new Summa(array,500,500000);

        Thread[] thr = new Thread[]{new Thread(sum1), new Thread(sum2), new Thread(sum3), new Thread(sum4), new Thread(sum5)};

        for(int i = 0; i < thr.length; i++){
            thr[i].start();
        }

        for(int i = 0; i < thr.length; i++){
            try {
                thr[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        long Sum = sum1.getSum() + sum2.getSum() + sum3.getSum() + sum4.getSum() + sum5.getSum();
        finish = System.currentTimeMillis();

        System.out.println(finish - start + " MS [Our sum - " + Sum);
        System.out.println("ID: " + thread1.getId() + ", Name: " + thread1.getName() + " finish");

    }

}
