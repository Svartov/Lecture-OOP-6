package Leks6;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        File folderIn = new File("C:\\Users\\HP\\OneDrive\\Skrivebord\\to"); // Enter first folder
        File folderOut = new File("C:\\Users\\HP\\OneDrive\\Skrivebord\\is"); // Enter the second folder

        try {
            long totalBytes = Redactor.copyFolder(folderIn, folderOut);
            System.out.println("copying: " + totalBytes + " bytes");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SearchRedactor radactor1 = new SearchRedactor(folderIn,folderOut);

        while (true){
            Thread thread2 = new Thread(radactor1);
            thread2.start();
            thread2.join();
            thread2.sleep(1000);
        }


    }
}
