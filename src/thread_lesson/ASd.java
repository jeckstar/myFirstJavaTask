package thread_lesson;

public class ASd {

    public static void main(String[] args) throws InterruptedException {
        final Holder holder = new Holder();
        final Thread incThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                holder.inc();
            }
            System.out.println("Inc thread: holder value is " + holder.getValue());
        });
        final Thread decThread = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                holder.dec();
            }
            System.out.println("Dec thread: holder value is " + holder.getValue());
        });
        incThread.start();
        decThread.start();
        incThread.join();
        decThread.join();
    }

    private static class Holder {

        private int value;

        public void inc() {
            value++;
        }

        public void dec() {
            value--;
        }

        public int getValue() {
            return value;
        }
    }

}
