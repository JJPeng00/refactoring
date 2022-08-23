package ch6;

/**
 * 内联函数  Inline Function
 *
 * 动机：当存在非必要的间接调用时，内联函数可能更加清晰。（但有时，只含有一行的间接调用也是值得存在的）
 *
 * 什么时候不内联：不能简单快速的内联，那就不内联。复杂情况：递归调用、多返回点、内联至另一个对象中而该对象并无访问函数等
 *
 * idea快捷键：在方法的调用点上使用 Ctrl + Alt + N 呼出选项面板，选择其中一个选项作为inline的结果：
 *      1. Inline all and remove the method （内联到所有的调用处，并移除被调用方法）
 *      2. Inline all and keep the method  （内联到所有的调用处，并保留被调用方法）
 *      3. Inline this only and keep the method （内联到当前调用处，并保留被调用方法）
 *
 */
public class InlineDemo {

    public static void main(String[] args) {
        Driver driver = new Driver(3);
        System.out.println(rating(driver));
    }

    private static int rating(Driver driver) {
        return moreThanFiveLateDeliveries(driver) ? 2 : 1;
    }

    private static boolean moreThanFiveLateDeliveries(Driver dvr) {
        //内联时，idea可以帮助我们自动改变局部变量的名称
        return dvr.getNumberOfLateDeliveries() > 5;
    }
}
