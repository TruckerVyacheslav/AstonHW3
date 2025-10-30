package Decorator;

public class BaseWrapper extends Sender {
    public Sender sender;

    public BaseWrapper(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void send(String message) {
        sender.send(message);
    }
}
