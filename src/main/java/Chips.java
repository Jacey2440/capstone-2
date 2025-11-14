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
