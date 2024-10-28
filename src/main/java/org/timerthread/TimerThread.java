package org.timerthread;

import java.lang.reflect.InvocationTargetException;

public class TimerThread<T extends Thread> extends Thread {
  private Integer timesToRepeat;
  private Long delay;
  private Class<T> clazz;
  private String str;

  public TimerThread(Class<T> clazz, Integer timesToRepeat, Long delay, String str) {
    this.timesToRepeat = timesToRepeat;
    this.delay = delay;
    this.clazz = clazz;
    this.str = str;
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
        T task = (T) clazz.getDeclaredConstructor(String.class).newInstance(str);
        task.start();
        task.join();
      } catch (NoSuchMethodException | SecurityException
               | InstantiationException | IllegalAccessException
               | IllegalArgumentException | InvocationTargetException
               | InterruptedException e) {
        System.out.println(e);
      }
      System.out.println();
      timesToRepeat--;
    }
  }
}
