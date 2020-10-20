package com.sun.principle.openclose;

/**
 * @author shawn
 * @descript
 * @create 2020-10-13 10:02 下午
 */
public class OpenCloseDemo2 {
    public static void main(String[] args) {
        NewBackHome newBackHome = new NewBackHome();
        newBackHome.backHome(new NewWalk());
        newBackHome.backHome(new NewCar());
        newBackHome.backHome(new NewSubWay());
    }
}

// 回家
class NewBackHome {
    public void backHome(NewBack b){
        b.BackHome();
    }

}
// 基类-》改成抽象类
abstract class NewBack {
    int type;
    public abstract void BackHome();// 抽象方法
}
//步行
class NewWalk extends NewBack{
    NewWalk(){
        super.type=1;
    }

    public void BackHome() {
        System.out.println("步行回家");
    }
}
//开车
class NewCar extends NewBack{
    NewCar(){
        super.type=2;
    }

    public void BackHome() {
        System.out.println("开车回家");
    }
}

//地铁
class NewSubWay extends NewBack{
    NewSubWay(){
        super.type=3;
    }

    public void BackHome() {
        System.out.println("地铁回家");
    }
}
