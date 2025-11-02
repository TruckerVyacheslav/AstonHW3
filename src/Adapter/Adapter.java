package Adapter;

public class Adapter implements Action{

    private Runnable adaptee;

    public Adapter(Runnable adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void doStuff() {
        adaptee.run();
    }
}
