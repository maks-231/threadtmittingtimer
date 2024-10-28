package org.timerthread;

public class PrintingStringTask extends Thread {
  private String str;

  public PrintingStringTask(String str) {
    this.str = str;
  }

  public PrintingStringTask() {
    this.str = "Empty task";
  }

  @Override
  public void run() {
    System.out.println(str);
  }
}
