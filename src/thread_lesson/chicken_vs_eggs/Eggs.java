package thread_lesson.chicken_vs_eggs;

import java.util.concurrent.TimeUnit;

public class Eggs {

    public static void main(String[] args) {

        Thread thread = new Thread(new Chicken());
        System.out.println("Спор начат");
        thread.start();

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Яйцо");
        }
        if (thread.isAlive()){
            try{
                thread.join();	//Подождать пока оппонент закончит высказываться.
            }catch(InterruptedException e){}

            System.out.println("Первым появилось яйцо!");
        }
        else	//если оппонент уже закончил высказываться
        {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}
