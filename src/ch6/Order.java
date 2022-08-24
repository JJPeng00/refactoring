package ch6;

public class Order {
    int itemPrice;

    int quantity;

    int amount;

    public Order(int amount) {
        this.amount = amount;
    }

    public Order(int itemPrice, int quantity) {
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }
}
