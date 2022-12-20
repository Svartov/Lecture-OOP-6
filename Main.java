package Leks6;

public class Main {

    public static void main(String[] args){

        Thread[] ArrayThread = new Thread[100];

        for(int i = 0; i < ArrayThread.length; i++){
            ArrayThread[i] = new Thread(new FactorialTask());
            ArrayThread[i].start();
        }

    }

}
