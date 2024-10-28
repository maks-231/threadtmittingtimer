package org.timerthread;

public class TimerThreadTest {
  public static void main(String[] args) {

    TimerThread<PrintingStringTask> timerThread = new TimerThread<>(PrintingStringTask.class,10, 1000l, "Executing task!");
    timerThread.start();
    try {
      timerThread.join();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}