package org.timerthread;

public class TimerThreadTest {
  public static void main(String[] args) {

    TimerThread<PrintingStringTask> timerThread = new TimerThread<>(new PrintingStringTask("Executing task!"),10, 1000l);
    timerThread.start();
    try {
      timerThread.join();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}