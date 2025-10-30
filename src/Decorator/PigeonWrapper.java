package Decorator;

public class PigeonWrapper extends BaseWrapper{

    public PigeonWrapper(Sender sender) {
        super(sender);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Отправка голубем! " + message);

    }
}
