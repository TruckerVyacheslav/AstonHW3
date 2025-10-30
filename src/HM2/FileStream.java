package HM2;

import java.nio.file.*;
import java.util.regex.Pattern;

public class FileStream {
    private String path;
    private Path file;
    private static final String ALLOWED_FILE_FORMAT = ".*.txt";

    public FileStream() {
    }

    public FileStream(String path) {
        openNewFile(path);
    }

    public String getFilePath() {
        return path;
    }

    public void openNewFile(String path){
        try {
            file = Paths.get(path);
            if(!Pattern.matches(ALLOWED_FILE_FORMAT, path))
                throw new FileFormatException(file.getFileName().toString());
            this.path = path;
        } catch (InvalidPathException e) {
            throw new FileException(e.getMessage(), e);
        }
    }

    public void write(String text) {
        try {
            Files.write(file, text.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            throw new FileException(e.getMessage(), e);
        }
    }

    public String read() {
        try {
            return Files.readString(file);
        } catch (Exception e) {
            throw new FileException(e.getMessage(), e);
        }
    }

    public void create() {
        try {
            Files.createFile(file);
        } catch (Exception e) {
            throw new FileException(e.getMessage(), e);
        }
    }

    public void clear() {
        try {
            Files.writeString(file, "");
        } catch (Exception e) {
            throw new FileException(e.getMessage(), e);
        }
    }

    public void delete() {
        try {
            Files.delete(file);
        } catch (Exception e) {
            throw new FileException(e.getMessage(), e);
        }
    }

    public void rename(String newName) {
        try {
            Path oldFile = file;
            openNewFile(newName);
            Files.move(oldFile, file);
        } catch (Exception e) {
            throw new FileException(e.getMessage(), e);
        }
    }
}
