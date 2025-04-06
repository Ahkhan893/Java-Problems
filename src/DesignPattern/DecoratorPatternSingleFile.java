package DesignPattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Step 1: Component Interface
interface FileReaderComponent {
    String readData();
}

// Step 2: Concrete Component - Basic File Reader
class BasicFileReader implements FileReaderComponent {
    private String filePath;

    public BasicFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String readData() {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }
}

// Step 3: Abstract Decorator
abstract class FileReaderDecorator implements FileReaderComponent {
    protected FileReaderComponent component;

    public FileReaderDecorator(FileReaderComponent component) {
        this.component = component;
    }

    @Override
    public String readData() {
        return component.readData();
    }
}

// Step 4.1: Concrete Decorator - Compression
class CompressionDecorator extends FileReaderDecorator {
    public CompressionDecorator(FileReaderComponent component) {
        super(component);
    }

    @Override
    public String readData() {
        String data = super.readData();
        return compressData(data);
    }

    private String compressData(String data) {
        return "Compressed Data: " + data.substring(0, Math.min(data.length(), 10)) + "...";
    }
}

// Step 4.2: Concrete Decorator - Encryption
class EncryptionDecorator extends FileReaderDecorator {
    public EncryptionDecorator(FileReaderComponent component) {
        super(component);
    }

    @Override
    public String readData() {
        String data = super.readData();
        return encryptData(data);
    }

    private String encryptData(String data) {
        return "Encrypted Data: " + new StringBuilder(data).reverse().toString();
    }
}

// Step 4.3: Concrete Decorator - Logging
class LoggingDecorator extends FileReaderDecorator {
    public LoggingDecorator(FileReaderComponent component) {
        super(component);
    }

    @Override
    public String readData() {
        System.out.println("Logging: Reading file data...");
        return super.readData();
    }
}

// Step 5: Client Code
public class DecoratorPatternSingleFile {
    public static void main(String[] args) {
        FileReaderComponent fileReader = new BasicFileReader("sample.txt");

        // Applying Decorators Dynamically
        fileReader = new LoggingDecorator(fileReader);
        fileReader = new CompressionDecorator(fileReader);
        fileReader = new EncryptionDecorator(fileReader);

        // Reading the file
        System.out.println(fileReader.readData());
    }
}
