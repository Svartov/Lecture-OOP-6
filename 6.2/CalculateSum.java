package Leks6;

public class CalculateSum {

    public static long CalculateSum(int[] arrayNum) {

        long sum = 0;
        for (int i = 0; i < arrayNum.length; i++) {

            sum = sum + arrayNum[i];

        }

        return sum;
    }


}

