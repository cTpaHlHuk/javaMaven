package Lesson17;

import static Lesson17.Vedusiy.LOGGER;

public class Pevec3 extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Monitors.MIKROFON) {
                try {
                    Monitors.MIKROFON.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 3; i++) {
                LOGGER.debug("Певец 3 начал петь");
                System.out.println("_Da__Da__Da_");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LOGGER.debug("Певец 3 передал микрофон");
            synchronized (Monitors.MIKROFON) {
                Monitors.MIKROFON.notify();
            }
        }
    }
}
