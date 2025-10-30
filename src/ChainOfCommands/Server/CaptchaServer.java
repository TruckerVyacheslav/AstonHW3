package ChainOfCommands.Server;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


// Затычка для сервера капчи
public class CaptchaServer {

    private final Map<Integer, String> captchas = new HashMap<>();
    private final static String ALPHANUMERICAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public String getCaptchaForUser(int userID) {
        return captchas.get(userID);
    }

    public void makeNewCaptchaForUser(int userID) {
        captchas.put(userID, generateCaptcha());
    }
    public void clearCaptchaForUser(int userID) {
        captchas.remove(userID);
    }

    private String generateCaptcha() {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 2) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ALPHANUMERICAL.length());
            salt.append(ALPHANUMERICAL.charAt(index));
        }
        return salt.toString();
    }

}
