package com.sun.principle.inversion;

/**
 * @author shawn
 * @descript 接口传递的三种方式
 * 1。接口传递
 * 2。构造方法传递
 * 3。Setter传递
 * @create 2020-10-12 9:22 下午
 */
public class InversionDemo3 {
    public static void main(String[] args) {
        // 方式一
        Tourism tourism = new Tourism();
        tourism.ride(new Bus());

        // 方式二
//        Tourism tourism = new Tourism(new AirCraft());
//        tourism.ride();
        // 方式三
//        Tourism tourism = new Tourism();
//        tourism.setTraffic(new Bus());
//        tourism.ride();
    }
}

// 方式1。接口传递
//旅行
interface ITourism {
    public void ride(ITraffic i);
}

// 交通
interface ITraffic {
    public void tool();
}

//大巴
class Bus implements ITraffic {
    public void tool() {
        System.out.println("乘大巴旅行");
    }
}

//飞机
class AirCraft implements ITraffic {
    public void tool() {
        System.out.println("乘飞机旅行");
    }
}

// 旅行类
class Tourism implements ITourism {
    public void ride(ITraffic t) {
        t.tool();
    }
}


//方式2 构造
//interface ITourism {
//    public void ride();
//}
//// 交通
//interface ITraffic {
//    public void tool();
//}
//
////大巴
//class Bus implements ITraffic{
//    public void tool() {
//        System.out.println("乘大巴旅行");
//    }
//}
//
////飞机
//class AirCraft implements ITraffic{
//    public void tool() {
//        System.out.println("乘飞机旅行");
//    }
//}
//
//// 旅行类
//class Tourism implements ITourism {
//    public ITraffic t;
//    public Tourism (ITraffic t){
//        this.t =t;
//    }
//    public void ride() {
//        t.tool();
//    }
//}
//
//// 方式三 Setter注入
//interface ITourism {
//    public void ride();
//    public void setTraffic(ITraffic t);
//}
//// 交通
//interface ITraffic {
//    public void tool();
//}
//
////大巴
//class Bus implements ITraffic{
//    public void tool() {
//        System.out.println("乘大巴旅行");
//    }
//}
//
////飞机
//class AirCraft implements ITraffic{
//    public void tool() {
//        System.out.println("乘飞机旅行");
//    }
//}
//
//// 旅行类
//class Tourism implements ITourism {
//    private ITraffic t;
//    public void setTraffic(ITraffic t) {
//        this.t =t;
//    }
//    public void ride() {
//        t.tool();
//    }
//}


