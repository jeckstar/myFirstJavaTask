package thread_lesson.chicken_vs_eggs;

import java.util.concurrent.TimeUnit;

public class Chicken implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Курица");
        }
    }
}
