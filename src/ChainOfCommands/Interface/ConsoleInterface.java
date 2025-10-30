package ChainOfCommands.Interface;

public class ConsoleInterface implements UserInterface{

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void reset(String message) {
        showMessage(message);
    }

    @Override
    public void next(String message) {
        showMessage(message);
    }


    // Разделить main и interface

}
