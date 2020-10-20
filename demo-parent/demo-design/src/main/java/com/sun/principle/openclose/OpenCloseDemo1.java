package com.sun.principle.openclose;

/**
 * @author shawn
 * @descript 开闭原则
 * @create 2020-10-13 9:53 下午
 */
public class OpenCloseDemo1 {
    public static void main(String[] args) {
        BackHome backHome = new BackHome();
        backHome.backHome(new Walk());
        backHome.backHome(new Car());
    }
}

// 回家
class BackHome {
    public void backHome(Back b){
        if(b.type ==1){
            walk();
        }else if (b.type ==2){
            car();
        }
    }

    public void walk(){
        System.out.println("步行回家");
    }

    public void car(){
        System.out.println("开车回家");
    }
}
// 基类
class Back {
    int type;
}
//步行
class Walk extends Back{
    Walk(){
        super.type=1;
    }
}
//开车
class Car extends Back{
    Car(){
        super.type=2;
    }
}
