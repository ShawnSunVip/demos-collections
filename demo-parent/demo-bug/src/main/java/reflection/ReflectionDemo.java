package reflection;

/**
 * @author sunxiang
 * @date 2020-10-22 9:07
 **/
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException{
        // 获取
        Class<?> aClass = Class.forName("reflection.A");
        Class<A> aClass1 = A.class;
        System.out.println("ss");
    }
}

interface  B {
    public String method(String str);
}

class A implements B{

    //成员变量
    private int num=0;
    // 常量
    private static  final String ABC="abc";

    private C c;

    public A(){

    }


    public A(C c){
        this.c=c;
    }

    @Override
    public String method(String str) {
        // 局部变量
        String x ="123";
        return x+str;
    }

    public String methodA1(){
       return num+ABC;
    }

    public void methodA2(){
        getMethodC();
    }

    private void getMethodC(){
        c.methodC();
    }
}

class C {
    public void methodC(){
        System.out.println("this is C");
    }
}
