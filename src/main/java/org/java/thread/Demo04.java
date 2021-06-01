package org.java.thread;

public class Demo04 {
  public static void main(String[] args) throws InterruptedException {

    Thread t1 =
        new Thread(
            () -> {
              for (int i = 1; i <= 5; i++) {
                System.out.println("Hi04");
                try {
                  Thread.sleep(1000);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    Thread t2 =
        new Thread(
            () -> {
              for (int i = 1; i <= 5; i++) {
                System.out.println("Hello04");
                try {
                  Thread.sleep(800);
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });

    System.out.println(t1.isAlive());

    t1.start();
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t2.start();

    System.out.println(t1.isAlive());
    t1.join();
    t2.join();

    System.out.println(t1.isAlive());
    System.out.println("Bye bye!");
  }
}
