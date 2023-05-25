package Lesson17;

import static Lesson17.Vedusiy.LOGGER;

public class Pevec1 extends Thread {
    private int count = 1;

    public Pevec1() {

    }

    public Pevec1(int count) {
        this.count = count;
    }


    @Override
    public void run() {
        int j = 0;

        while (j < count) {
            for (int i = 0; i < 3; i++) {
                LOGGER.debug("Певец 1 начал петь");
                System.out.println("La-La-La______");
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LOGGER.debug("Певец 1 передал микрофон");
            LOGGER.debug("Певец 1 ждет");
            synchronized (Monitors.MIKROFON) {
                Monitors.MIKROFON.notify();
            }
            synchronized (Monitors.MIKROFON) {
                try {
                    Monitors.MIKROFON.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            j++;
        }
    }
}
