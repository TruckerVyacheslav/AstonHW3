package Adapter;

public class Printer implements Runnable{

    public Printer() {
    }

    @Override
    public void run() {
        System.out.print("Hello world!");
    }
}
