package ch6;

/**
 * 提炼变量（Extract Variable） 或 引入变量（Introduce Variable）
 *
 * 动机：有些表达式有可能非常复杂而难以阅读，局部变量可以帮助我们将表达式分解为比较容易管理的形式
 *
 * idea提供了提取变量的快捷键： Ctrl + Alt + V，选中要提取的表达式并应用快捷键就可以快速的提取出一个变量
 */
public class ExtractVariableDemo {

    public static void main(String[] args) {
        Order order = new Order(50, 10);
        System.out.println(price(order));
    }

    private static int price(Order order) {
        //price is base price - quantity discount + shipping
        return order.quantity * order.itemPrice -
                Math.max(0, order.quantity - 500) * (int)(order.itemPrice * 0.05) +
                (int)Math.min(order.quantity * order.itemPrice * 0.1, 100);
    }
}
