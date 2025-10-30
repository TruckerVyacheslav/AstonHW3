package Decorator;

public class SMSWrapper extends BaseWrapper{

    public SMSWrapper(Sender sender) {
        super(sender);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Отправка по смс! " + message);
    }
}
