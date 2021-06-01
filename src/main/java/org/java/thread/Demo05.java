package org.java.thread;

public class Demo05 {
  public static void main(String[] args) throws InterruptedException {

    Thread t1 =
        new Thread(
            () -> {
              for (int i = 1; i <= 5; i++) {
                System.out.println("Hi04 -- " + Thread.currentThread().getPriority());
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
            },
            "Custom Thread Name");

    System.out.println(t1.getName());
    //    t2.setName("Hello Thread");
    System.out.println(t2.getName());

    System.out.println(t1.getPriority()); // default is 5
    t2.setPriority(8);
    t2.setPriority(Thread.MIN_PRIORITY);
    t2.setPriority(Thread.MAX_PRIORITY);
    System.out.println(t2.getPriority());

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
