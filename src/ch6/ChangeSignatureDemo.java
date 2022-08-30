package ch6;

/**
 * 修改函数签名（Change Signature），由于在Java中函数签名的由方法名和形参数据类型列表来限定的。
 * 所以修改函数签名就包含：1.修改方法名，2.修改形参类型列表，3.二者同时修改
 *
 * 常规适用的重构方式：将原方法的方法体使用提取方法的方式提取为目标方法名的方法，这样原方法就是通过调用新方法完成功能的，
 *                 确认正确后，将原方法inline重构，这样所有调用原方法的地方都会调用新方法。
 *
 * idea为我们提供了重命名和修改签名的快捷重构方式：
 *      1. 重命名：Shift + F6，需要注意的是对于有重载的方法，若直接在其中某个方法上重命名的话会呼出Rename Overloads面板
 *         让你选择需要将哪些方法重命名，默认是全部选择，或者自己根据需要勾选需要重命名的重载方法。
 *         或者：还可以实现修改签名的方式，单独重命名其中某个重载方法。
 *      2. 修改签名：Ctrl + F6，呼出Change Signature面板，
 *         可以修改方法名、参数类型、参数名、参数顺序
 *
 *
 */
public class ChangeSignatureDemo {

    public static void main(String[] args) {

    }

    public static double circum(double radius) {
        return 2 * Math.PI * radius;
    }
}
