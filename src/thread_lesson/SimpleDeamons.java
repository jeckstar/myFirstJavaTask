package thread_lesson;

import java.util.concurrent.TimeUnit;

public class SimpleDeamons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread deamon = new Thread(new SimpleDeamons());
            deamon.setDaemon(true);
            deamon.start();
        }
        System.out.println("Запущены демоны");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
