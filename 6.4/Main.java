package Leks6;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Thread thread1 = Thread.currentThread();

        System.out.println("ID: " + thread1.getId() + ", Name: " + thread1.getName() + ", starts");

        long start = System.currentTimeMillis();

        File folderIn = new File("C:\\Users\\HP\\OneDrive\\Skrivebord\\to"); // Enter your link
        File folderIn1 = new File("C:\\Users\\HP\\OneDrive\\Skrivebord\\is"); // Enter your link

        File[] array = new File[]{folderIn,folderIn1}; // Adding files to an array

        File[] arrayOut = new File[array.length]; // Create an array for a folder

        File folderOut = new File("");

        for(int i = 0; i < arrayOut.length; i++) {
            folderOut = new File(array[i].getName()); // Enter your folder, when you will save file
            folderOut.mkdirs();  // Create a folder
            arrayOut[i] = folderOut; // Adding a folder to an array
        }

        Redactor redactor1 = new Redactor(array[0], arrayOut[0]);
        Redactor redactor2 = new Redactor(array[1], arrayOut[1]);

        Thread[] thr = new Thread[]{new Thread(redactor1), new Thread(redactor2)}; // Array for threads

        for(int i = 0; i < thr.length; i++){
            thr[i].start(); // Starting threads
        }

        for(int i = 0; i < thr.length; i++) {
            try {
                thr[i].join(); // Waiting for the thread to finish
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }

        long finish = System.currentTimeMillis();

        System.out.println(finish - start + "ms" + ", ID: " + thread1.getId() + ", Name: " + thread1.getName() + ", finish");
    }
}
