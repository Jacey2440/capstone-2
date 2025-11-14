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


