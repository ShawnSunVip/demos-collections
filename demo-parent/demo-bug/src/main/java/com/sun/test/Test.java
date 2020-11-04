package com.sun.test;

/**
 * @author shawn
 * @descript
 * @create 2020-11-02 9:03 下午
 */
public enum Test {
    INSTANCE;

    public void getTest(){
        System.out.println("sssss");
    }

    public static void main(String[] args) {
        //Test test = Test.INSTANCE;
        for (int i=1;i<=20;i++)
        {
            new Thread(() -> {
                Test test = Test.INSTANCE;
                System.out.println(Test.class.getClass());
            }, String.valueOf(i)).start();
        }
        //test.getTest();
        
    }
}
