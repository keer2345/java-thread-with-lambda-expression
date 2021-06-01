package org.java.thread;

class Hi01 extends Thread {
  @Override
  public void run() {
    for (int i = 1; i <= 5; i++) {
      System.out.println("Hi01");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Hello01 extends Thread {
  @Override
  public void run() {
    for (int i = 1; i <= 5; i++) {
      System.out.println("Hello01");
      try {
        Thread.sleep(800);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class Demo01 {
  public static void main(String[] args) {
    Hi01 obj1 = new Hi01();
    Hello01 obj2 = new Hello01();

    obj1.start();
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    obj2.start();
  }
}
