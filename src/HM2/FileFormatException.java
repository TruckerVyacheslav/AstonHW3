package HM2;

import java.io.Serial;

public class FileFormatException extends FileException {
    @Serial
    private static final long serialVersionUID = 16632L;
    private static final String DEFAULT_MESSAGE = "Произошла ошибка с типом файла!";

    public FileFormatException() {
        super(DEFAULT_MESSAGE);
    }

    public FileFormatException(String message) {
        super(message);
    }

    public FileFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
