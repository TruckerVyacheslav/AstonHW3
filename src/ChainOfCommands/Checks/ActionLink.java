package ChainOfCommands.Checks;

import ChainOfCommands.Interface.UserInterface;
import ChainOfCommands.UserData;

public abstract class ActionLink implements Checker {

    protected ActionLink next;
    protected UserInterface out;

    public ActionLink(ActionLink next, UserInterface out) {
        this.next = next;
        this.out = out;
    }

    protected int nextCheck(UserData data) {
        return next == null ? 0 : next.check(data);
    }

}
