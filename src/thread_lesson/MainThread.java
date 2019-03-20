package thread_lesson;

public class MainThread {
    public static void main(String[] args) {
//        LiftOff liftOff = new LiftOff();
//        liftOff.run();

        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Операция после LiftOff");

//        for (int i = 0; i < 5; i++) {
//            new Thread(new LiftOff()).start();
//            System.out.println("Операция после");
//        }
    }
}
