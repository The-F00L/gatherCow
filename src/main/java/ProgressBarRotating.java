package main.java;
class ProgressBarRotating extends Thread {
    boolean showProgress = true;
    public void run() {
      String anim= "|/-\\";
      int x = 0;
      while (showProgress) {
        System.out.print(anim.charAt(x++ % anim.length())+"Collecting info \r" );
        try { Thread.sleep(100); }
        catch (Exception e) {};
      }
    }
}
