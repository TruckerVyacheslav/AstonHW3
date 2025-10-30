package ChainOfCommands.Server;

import java.util.HashMap;
import java.util.Map;

public class PasswordServer {

    private final Map<String, String> users = new HashMap<>();

    public void addNewUser(String login, String password){
        users.put(login, password);
    }

    public String getPassword(String login) {
        return users.getOrDefault(login, "");
    }
}
