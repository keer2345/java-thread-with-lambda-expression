package org.java.thread;


public class Demo06 {
  private static int count = 0;

  private static synchronized void countInc(){
      count++;
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t1 =
        new Thread(
            () -> {
              for (int i = 0; i < 100000; i++) {
                  countInc();
              }
            });
    Thread t2 =
        new Thread(
            () -> {
              for (int i = 0; i < 100000; i++) {
                  countInc();
              }
            });

    t1.start();
    t2.start();

    // Java thread join method can be used to pause the current thread execution
    // until unless the specified thread is dead
    t1.join();
    t2.join();

    System.out.println("Value: " + count);
  }
}
