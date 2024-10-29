package org.timerthread;

public class TimerThread<T extends Runnable> extends Thread {
  private Integer timesToRepeat;
  private Long delay;
  private T task;

  public TimerThread(T task, Integer timesToRepeat, Long delay) {
    this.task = task;
    this.timesToRepeat = timesToRepeat;
    this.delay = delay;
  }

  @Override
  public void run() {
    long start = System.currentTimeMillis();

    while (timesToRepeat > 0) {
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        System.out.println(e);
      }

      System.out.println("Timer delayed for " + (System.currentTimeMillis() - start) + " milliseconds");
      start = System.currentTimeMillis();

      try {
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
      } catch (InterruptedException e) {
        System.out.println(e);
      }
      System.out.println();
      timesToRepeat--;
    }
  }
}
