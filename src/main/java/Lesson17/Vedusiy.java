package Lesson17;


import org.apache.log4j.Logger;

public class Vedusiy {
    public static final Logger LOGGER = Logger.getLogger(Vedusiy.class);

    public static void main(String[] args) {

        LOGGER.debug("Ведущий начал концерт");

        System.out.println("Концерт начался");
        Pevec1 pevec1 = new Pevec1(2);
        Pevec2 pevec2 = new Pevec2();
        pevec2.setDaemon(true);
        Pevec3 pevec3 = new Pevec3();
        pevec3.setDaemon(true);

        pevec1.start();
        pevec2.start();
        pevec3.start();

        while (pevec1.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Концерт закончился");
        LOGGER.debug("Ведущий закончил концерт");
    }
}
