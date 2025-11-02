import Decorator.Sender;
import Decorator.PigeonWrapper;
import Decorator.SMSWrapper;

void main() {
    System.out.println("Hallow!");
    Sender sender = new Sender();
    sender = new SMSWrapper(sender);
    sender = new PigeonWrapper(sender);

    sender.send("Уведомление");
}