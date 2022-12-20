package Leks6;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args){

        Thread thread1 = Thread.currentThread();

        System.out.println("ID: " + thread1.getId() + ", Name: " + thread1.getName() + ", Start");

        Random rn = new Random();

        int n = 10;

        int[] array = new int[n];

        Summa sum1 = new Summa(array);
        Summa sum2 = new Summa(array);

        Thread[] thr = new Thread[]{new Thread(sum1), new Thread(sum2)};

        thr[0].start();

            try {
                thr[0].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }


        if(thr[0].isAlive() == false){
            System.out.println();
            System.out.println();
            thr[1].start();
        }

        try {
            thr[1].join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("ID: " + thread1.getId() + ", Name: " + thread1.getName() + ", Finish");

    }

}
