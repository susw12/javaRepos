package net.ads.mrpaul.xc240.ps10;

public class SequentialIncrementer implements Incrementable{
    private int a;

    public SequentialIncrementer() {
        a = 0;
    }
    public void increment() {
        a++;
    }

    public int getValue() {
        return a;
    }
}
