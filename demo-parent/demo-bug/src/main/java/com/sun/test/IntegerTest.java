package com.sun.test;

/**
 * @author shawn
 * @descript
 *
 * 在 Java 5 中，在 Integer 的操作上引入了一个新功能来节省内存和提高性能。整型对象通过使用相同的对象引用实现了缓存和重用。
 * 当需要进行自动装箱时，如果数字在 -128 至 127 之间时，会直接使用缓存中的对象，而不是重新创建一个对象。
 * 所以第一个执行结果是integer1 == integer2
 * 第二个比较，数字大于127，会重建对象，==比较的是内存地址，所以执行结果是integer3 != integer4
 *
 * 扩展
 * Byte, Short, Long有固定范围: -128 到 127。对于Character, 范围是 0 到 127。除了Integer以外，这个范围都不能改变。
 * @create 2020-10-24 1:50 下午
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer integer1 = 3;
        Integer integer2 = 3;

        System.out.println(Integer.valueOf(128));

        if (integer1 == integer2)
            System.out.println("integer1 == integer2");
        else
            System.out.println("integer1 != integer2");


        Integer integer3 = 300;
        Integer integer4 = 300;

        if (integer3 == integer4)
            System.out.println("integer3 == integer4");
        else
            System.out.println("integer3 != integer4");
    }
}
