package thread;

import java.util.Timer;
import java.util.TimerTask;

public class BasicThread2 {
    public static int second=0;

    public static void main(String[] args) {
        // Main Thread 구간
        // Timer 기반 Thread
        Timer timer = new Timer();
        timer.schedule(new  TimerTask() {
            @Override
            public void run() {

            }
        });
    }

}
