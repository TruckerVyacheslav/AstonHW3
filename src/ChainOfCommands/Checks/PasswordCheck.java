package ChainOfCommands.Checks;

import ChainOfCommands.Interface.UserInterface;
import ChainOfCommands.Server.PasswordServer;
import ChainOfCommands.UserData;

public class PasswordCheck extends ActionLink {

    private final PasswordServer server;

    public PasswordCheck(ActionLink next, UserInterface out, PasswordServer server) {
        super(next, out);
        this.server = server;
    }

    @Override
    public int check(UserData data) {
        String password = server.getPassword(data.login());
        if(!password.isEmpty() && password.equals(data.password())) {
            out.next("Успешный вход!");
            return nextCheck(data);
        } else {
            out.reset("Неправильный логин или пароль!");
            return 2;
        }
    }
}
