package Leks6;

import java.math.BigInteger;

public class FactorialTask implements Runnable {

    public BigInteger calculateFactorial(long number){
        BigInteger fact = BigInteger.ONE;
        for(int i = 1; i <= number; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    @Override
    public void run() {
     Thread thr = new Thread();

        System.out.println("ID: " + thr.getId() + ", Name: " + thr.getName() + ", factorial = " +thr.getId() + " "+ this.calculateFactorial(thr.getId()));

    }

}
