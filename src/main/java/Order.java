import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private LocalDateTime timeOfOrder;
    private ArrayList<String> items;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public Order() {
        this.timeOfOrder = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public LocalDateTime getTimeOfOrder() {
        return timeOfOrder;
    }
}
