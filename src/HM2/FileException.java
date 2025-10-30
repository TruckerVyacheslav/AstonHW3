package HM2;

import java.io.Serial;

public class FileException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 16692L;
    private static final String DEFAULT_MESSAGE = "Произошла ошибка при чтении/записи файла!";

    public FileException() {
        super(DEFAULT_MESSAGE);
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
