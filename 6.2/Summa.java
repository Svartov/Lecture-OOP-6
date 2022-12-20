package Leks6;

public class Summa implements Runnable {

    private int[] arrayNum;
    private int feast;
    private int second;
    private long sum = 0;

    public Summa(int[] arrayNum, int feast, int second) {
        super();
        this.arrayNum = arrayNum;
        this.feast = feast;
        this.second = second;
    }

    public Summa() {
        super();
    }

    public long getSum(){
        return sum;
    }

    @Override
    public void run() {
        Thread thr = new Thread();

        for (int i = feast; i < second; i++) {
            sum = sum + arrayNum[i];
        }

    }
}
