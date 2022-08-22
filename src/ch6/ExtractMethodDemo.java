package ch6;

import java.util.Arrays;
import java.util.Date;

/**
 * 提取方法、反向重构：内联方法（inline method)
 * 根据一段代码的作用，将其提炼到一个方法中，并取一个与其用途相符的方法名
 *
 * 时机：将不同作用的代码段分别提炼出来，即使代码只有一行，我们将不再关心方法如何实现，只关心方法的作用。
 *      如果之后发现提炼的方法并不合适可以将方法内联回去。
 *
 * idea中选中某段代码后使用 Ctrl+Alt+M快捷键可将选中的代码提取为一个方法
 *
 * 1. 提取无局部变量的方法
 * 2. 提取有局部变量的方法，当局部变量只被读取时，可简单的直接将局部变量作为参数传入，idea会智能的帮助我们直接生成一个带有这两个参数的方法
 * 3. 提取有局部变量的方法，当局部变量是一个数据结构（对象），且在提取的方法中只修改这个结构中的数据时，也可简单的直接将局部变量作为参数传入
 * 4. 对局部变量再赋值，当局部变量只在被提炼的代码中被使用是，可直接将该变量的声明也移动到提取的代码中去，
 *    如果局部变量还被提炼之外的代码，可以将修改后的局部变量作为结果返回
 */
public class ExtractMethodDemo {

    public static void main(String[] args) {
        Invoice invoice = new Invoice("jjpeng", Arrays.asList(new Order(5), new Order(8)));
        printOwing(invoice);
    }

    private static void printOwing(Invoice invoice) {

        printBanner();

        final int outstanding = calculateOutstanding(invoice);

        recordDueDate(invoice);

        printDetails(invoice, outstanding);

    }

    private static int calculateOutstanding(Invoice invoice) {
        int result = 0;
        for (final Order order : invoice.orders) {
            result += order.amount;
        }
        return result;
    }

    private static void recordDueDate(Invoice invoice) {
        Date today = new Date();
        invoice.dueDate = today;
    }

    private static void printDetails(Invoice invoice, int outstanding) {
        System.out.println("name: " + invoice.customer);
        System.out.println("amount: " + outstanding);
        System.out.println("due: " + invoice.dueDate);
    }

    private static void printBanner() {
        System.out.println("***********************");
        System.out.println("**** Customer Owes ****");
        System.out.println("***********************");
    }

}
