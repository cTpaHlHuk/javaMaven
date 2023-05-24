package Lesson17;

import static Lesson17.Vedusiy.LOGGER;

public class Pevec2 extends Thread {
    @Override
    public void run() {
        while (true) {
            LOGGER.debug("Певец 2 начал петь");
            synchronized (Monitors.MIKROFON) {
                try {
                    Monitors.MIKROFON.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("______Fa-Fa-Fa");
                try {
                    Thread.sleep(250);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MIKROFON) {
                LOGGER.debug("Певец 2 передал микрофон");
                Monitors.MIKROFON.notify();
            }
        }
    }
}
