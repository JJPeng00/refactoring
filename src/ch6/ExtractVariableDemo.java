package ch6;

/**
 * 提炼变量（Extract Variable） 或 引入变量（Introduce Variable）
 *
 * 动机：有些表达式有可能非常复杂而难以阅读，局部变量可以帮助我们将表达式分解为比较容易管理的形式
 *
 * idea提供了提取变量的快捷键： Ctrl + Alt + V，选中要提取的表达式并应用快捷键就可以快速的提取出一个变量
 *
 * 1. 通过方法中的注释，我们可以知道：价格（price） = 底价（base price）- 批发折扣（quantity discount） + 运费（shipping），
 *    并且现有的语句也是根据这个样式构建的，但我们可以通过提取变量使其变得更加容易理解。
 * 2. 将这几个表达式分别提炼成变量
 *
 * 3. 进一步提取方法：如果当前表达式被多处调用，或者表达式是当前是类的基础操作，我们可以进一步将表达式提取成方法，以达到复用的目的。
 *
 * note：
 *      我们可以把对事物新的认识当作是一种知识，如同这里我们把了解到的：
 *      价格（price） = 底价（base price）- 批发折扣（quantity discount） + 运费（shipping）
 *      当作是一种知识。
 */
public class ExtractVariableDemo {

    public static void main(String[] args) {
        Order order = new Order(50, 10);
        System.out.println(price(order));
    }

    private static int price(Order order) {
        final int basePrice = getBasePrice(order);
        final int quantityDiscount = getQuantityDiscount(order);
        final int shipping = getShipping(order);
        return basePrice - quantityDiscount + shipping;
    }

    private static int getShipping(Order order) {
        return (int) Math.min(order.quantity * order.itemPrice * 0.1, 100);
    }

    private static int getQuantityDiscount(Order order) {
        return Math.max(0, order.quantity - 500) * (int) (order.itemPrice * 0.05);
    }

    private static int getBasePrice(Order order) {
        return order.quantity * order.itemPrice;
    }
}
