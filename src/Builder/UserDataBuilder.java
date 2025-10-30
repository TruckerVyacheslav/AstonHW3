package Builder;

import ChainOfCommands.UserData;

public class UserDataBuilder implements Builder {
    String login;
    String password;
    String captcha;
    int ID;

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;

    }

    @Override
    public void setCaptcha(String captcha) {
        this.captcha = captcha;

    }

    @Override
    public void setID(int ID) {
        this.ID = ID;

    }

    public UserData getData(){
        return new UserData(login, password, captcha, ID);
    }
}
