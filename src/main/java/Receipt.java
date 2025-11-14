
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {


    private final Path filePath;

    // Constructor accepts orderNumber to create unique file
    public Receipt(String orderNumber) throws IOException {

        // Creates the folder: src/main/resources/Receipts
        Path folderPath = Paths.get("src/main/resources/Receipts");
        if (Files.notExists(folderPath)) {
            Files.createDirectories(folderPath);
            // creates a folder path if the mentioned path does not exist
        }

        // File name includes order number and date/time
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = LocalDateTime.now().format(FORMATTER);

        String fileName = "order-" + orderNumber + " Date - " + date + ".txt";
        //
        filePath = folderPath.resolve(fileName);

        // Create the file if it does not exist
        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
    }

    // Append a line to the file
    public void writeLine(String text) throws IOException {
        try (FileWriter writer = new FileWriter(filePath.toFile(), true)) {
            writer.write(text + "\n");
        }
    }
}
