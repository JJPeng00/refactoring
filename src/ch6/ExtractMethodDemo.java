package ch6;

import java.util.Arrays;
import java.util.Date;

/**
 * 提取方法、反向重构：内联方法（inline method)
 * 根据一段代码的作用，将其提炼到一个方法中，并取一个与其用途相符的方法名
 *
 * 时机：将不同作用的代码段分别提炼出来，即使代码只有一行，我们将不再关心方法如何实现，只关心方法的作用。
 *      如果之后发现提炼的方法并不合适可以将方法内联回去。
 */
public class ExtractMethodDemo {

    public static void main(String[] args) {
        Invoice invoice = new Invoice("jjpeng", Arrays.asList(new Order(5), new Order(8)));
        printOwing(invoice);
    }

    private static void printOwing(Invoice invoice) {
        int outstanding = 0;
        System.out.println("***********************");
        System.out.println("**** Customer Owes ****");
        System.out.println("***********************");

        // calculate outstanding
        for (final Order order : invoice.orders) {
            outstanding += order.amount;
        }

        //record due date
        Date today = new Date();
        invoice.dueDate = today;

        //print details
        System.out.println("name: " + invoice.customer);
        System.out.println("amount: " + outstanding);
        System.out.println("due: " + invoice.dueDate);

    }

}
