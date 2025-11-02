import Builder.UserDataBuilder;
import ChainOfCommands.Checks.CheckGenerator;
import ChainOfCommands.Checks.Checker;
import ChainOfCommands.Interface.ConsoleInterface;
import ChainOfCommands.Interface.UserInterface;
import ChainOfCommands.Server.CaptchaServer;
import ChainOfCommands.Server.PasswordServer;
import HM2.FileException;
import HM2.FileFormatException;
import Proxy.PasswordLoggerProxy;

void main() {

    try{
        UserInterface UI = new ConsoleInterface();
        CaptchaServer captchaServer = new CaptchaServer();
        PasswordServer passwordServer = new PasswordLoggerProxy();
        passwordServer.addNewUser("QWERTY", "QWERTY");
        Random rnd = new Random();
        int userID = rnd.nextInt(1000, 10000);

        Checker checker = CheckGenerator.generateStandartChecker(UI, passwordServer, captchaServer);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            captchaServer.makeNewCaptchaForUser(userID);
            UserDataBuilder dataBuilder = new UserDataBuilder();


            UI.showMessage("Капча - " + captchaServer.getCaptchaForUser(userID));
            UI.showMessage("Введите капчу: ");
            dataBuilder.setCaptcha(scanner.next());
            UI.showMessage("Введите логин: ");
            dataBuilder.setLogin(scanner.next());
            UI.showMessage("Введите Пароль: ");
            dataBuilder.setPassword(scanner.next());
            dataBuilder.setID(userID);

            if (checker.check(dataBuilder.getData()) == 0) {
                UI.showMessage("Нажмите Enter для выхода");
                scanner.nextLine();
                scanner.nextLine();
                break;
            } else {
                UI.showMessage("Попробуйте еще раз!");
            }
        }
        scanner.close();
    } catch (FileException e) {
        Optional<Throwable> cause = Optional.ofNullable(e.getCause());

        if (cause.isEmpty())
            cause = Optional.of(e);

        if (cause.get() instanceof NoSuchFileException)
            System.out.println("Файл " + e.getMessage() + " не найден!");
        else if (cause.get() instanceof FileAlreadyExistsException)
            System.out.println("Файл " + e.getMessage() + " уже существует!");
        else if (cause.get() instanceof OutOfMemoryError)
            System.out.println("Файл " + e.getMessage() + " слишком большой!");
        else if (cause.get() instanceof FileFormatException)
            System.out.println("Файл " + e.getMessage() + " имеет невеный формат!");
        else if (cause.get() instanceof InvalidPathException)
            System.out.println("Указан неккоректный путь!");
        else System.out.println("Необработанное исключение!!! " + e.getCause());
    }
}