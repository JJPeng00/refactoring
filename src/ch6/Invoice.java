package ch6;

import java.util.Date;
import java.util.List;

public class Invoice {

    String customer;

    List<Order> orders;

    Date dueDate;

    public Invoice(String customer, List<Order> orders) {
        this.customer = customer;
        this.orders = orders;
    }
}
