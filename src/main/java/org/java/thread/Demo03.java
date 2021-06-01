package org.java.thread;

public class Demo03 {
  public static void main(String[] args) {
    Runnable obj1 =
        new Runnable() {
          @Override
          public void run() {
            for (int i = 1; i <= 5; i++) {
              System.out.println("Hi03");
              try {
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
        };
    Runnable obj2 =
        () -> {
          for (int i = 1; i <= 5; i++) {
            System.out.println("Hello03");
            try {
              Thread.sleep(800);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        };

    Thread t1 = new Thread(obj1);
    Thread t2 = new Thread(obj2);
    Thread t3 =
        new Thread(
            () -> {
              for (int i = 1; i <= 5; i++) {
                System.out.println("Bye03");
                try {
                  Thread.sleep(700);
                } catch (InterruptedException e) {
                }
              }
            });

    t1.start();
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t2.start();
    t3.start();
  }
}
