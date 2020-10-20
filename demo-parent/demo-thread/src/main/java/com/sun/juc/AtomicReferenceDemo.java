package com.sun.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author shawn
 * @descript 原子引用AtomicReference
 * @create 2020-09-07 8:21 下午
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User u1 = new User("z3", 12);
        User u2 = new User("l4", 15);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(u1);

        System.out.println(atomicReference.compareAndSet(u1, u2) + "\t " + atomicReference.get().toString());
    }
}

class User {
    String userName;
    int age;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }


}
