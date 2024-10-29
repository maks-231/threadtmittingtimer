package org.timerthread;

public class PrintingStringTask implements Runnable {
  private String str;

  public PrintingStringTask(String str) {
    this.str = str;
  }

  @Override
  public void run() {
    System.out.println(str);
  }
}
