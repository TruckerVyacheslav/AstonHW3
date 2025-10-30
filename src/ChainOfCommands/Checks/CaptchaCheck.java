package ChainOfCommands.Checks;

import ChainOfCommands.Server.CaptchaServer;
import ChainOfCommands.Interface.UserInterface;
import ChainOfCommands.UserData;

public class CaptchaCheck extends ActionLink {

    private final CaptchaServer captchaServer;

    public CaptchaCheck(ActionLink next, UserInterface out, CaptchaServer captchaServer) {
        super(next, out);
        this.captchaServer = captchaServer;
    }

    @Override
    public int check(UserData data) {
        String captchaAnswer = captchaServer.getCaptchaForUser(data.ID());
        captchaServer.clearCaptchaForUser(data.ID());

        if(captchaAnswer.equals(data.captcha())) {
            out.next("");
            return nextCheck(data);
        }
        else{
            out.reset("неправильная капча!");
            return 1;
        }
    }
}

