package ChainOfCommands.Checks;

import ChainOfCommands.Interface.UserInterface;
import ChainOfCommands.Server.CaptchaServer;
import ChainOfCommands.Server.PasswordServer;

public final class CheckGenerator {

    public static Checker generateStandartChecker(UserInterface ui, PasswordServer passwordSrv, CaptchaServer captchaSrv) {
        PasswordCheck passwordCheck = new PasswordCheck(null, ui, passwordSrv);
        return new CaptchaCheck(passwordCheck, ui, captchaSrv);
    }
}
