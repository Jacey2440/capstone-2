# Point of Sale (POS) Application

## Overview

This is a **Point of Sale (POS) application** for **Deli**, a custom sandwich shop. The application automates order
management, allowing customers to order drinks, chips, and eventually sandwiches. Orders are saved
as receipts for record-keeping.

The project is built using **Object-Oriented Programming (OOP)** principles, including **abstract classes** and *
*inheritance**, making it scalable for future features like full sandwich customization.

---

## Features

### Ordering Menu

- Users can interact with a console-based menu:
    - **Add Drink**
    - **Add Chips**
    - **Cancel Order**

### Drinks

- Customers can choose from **3 sizes**: Small, Medium, Large.
- Each size has its own price.
- Drinks are added to the order and written to the receipt automatically.

### Chips

- Customers can choose to add chips for $1.50.
- Chips are added to the order and written to the receipt automatically.

### Receipts

- Each order generates a unique receipt file in `src/main/resources/Receipts/`.
- Receipt filenames include the **order number** and **date**:  
- order-{orderNumber} Date - yyyy-MM-dd.txt`
- Each item added to the order is appended to the receipt file.

---

## Project Structure

### Main Classes

- **Main.java** – Handles user interaction and the order menu.
- **OrderItem.java** – Abstract class for all order items (Drinks, Chips, future Sandwiches).
````java

public abstract class OrderItem {
    private String name;
    private double price;

    public OrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getDescription();
}
````
---
- **Drink.java** – Concrete implementation of `OrderItem` for drinks.
````java
public class Drink extends OrderItem {
    private String size;

    public Drink(String size, double price) {
        super(size + "Drink", price);
        this.size = size;
    }


    @Override
    public String getDescription() {
        return size + " Drink - $" + String.format("%.2f", getPrice());
    }

}
````
---
- **Chips.java** – Concrete implementation of `OrderItem` for chips.
````java
public class Chips extends OrderItem {
    private String name;

    public Chips(String name, double price) {
        super(name + "Chips", price);  // item name
        this.name = name;
    }


    @Override
    public String getDescription() {
        return getName() + " - $" + String.format("%.2f", getPrice());
    }
}

````
---
- **Receipt.java** – Handles creation and writing of order receipts.
````java

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

        // File name includes order number and date
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

````
---

## Object-Oriented Design

- **Inheritance:** `Drink` and `Chips` extend `OrderItem`.
- **Abstraction:** `OrderItem` defines a template for all items in an order.
- **Encapsulation:** Class properties are private with getters.
- **Scalability:** New order items (e.g., sandwiches) can be added easily by extending `OrderItem`.

---
