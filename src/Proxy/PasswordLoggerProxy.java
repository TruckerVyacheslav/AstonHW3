package Proxy;

import ChainOfCommands.Server.PasswordServer;
import HM2.FileStream;

import java.time.LocalDate;

public class PasswordLoggerProxy extends PasswordServer {

    private String logFile = "log.txt";
    private final FileStream fs = new FileStream();

    public PasswordLoggerProxy(String logFile) {
        super();
        this.logFile = logFile;
        fs.create();
        fs.openNewFile(logFile);
    }

    public PasswordLoggerProxy() {
        super();
        fs.openNewFile(logFile);
    }

    private void WriteToLog(String message) {
        fs.write(message);
    }

    @Override
    public void addNewUser(String login, String password) {
        WriteToLog(LocalDate.now() + ": Пользователь создан - " + login);
        super.addNewUser(login, password);
    }

    @Override
    public String getPassword(String login) {
        WriteToLog(LocalDate.now() + ": Пользователь попытался войти - " + login);
        return super.getPassword(login);
    }
}
