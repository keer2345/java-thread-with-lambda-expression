package org.java.thread;

class Hi02 implements Runnable {
  @Override
  public void run() {
    for (int i = 1; i <= 5; i++) {
      System.out.println("Hi02");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Hello02 implements Runnable {
  @Override
  public void run() {
    for (int i = 1; i <= 5; i++) {
      System.out.println("Hello02");
      try {
        Thread.sleep(800);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class Demo02 {
  public static void main(String[] args) {
    Runnable obj1 = new Hi02();
    Runnable obj2 = new Hello02();

    Thread t1 = new Thread(obj1);
    Thread t2 = new Thread(obj2);

    t1.start();
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t2.start();
  }
}
