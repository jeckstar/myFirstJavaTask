package task_threads.file_byte_reader;

public class LoadingProgress {
    private int loadCount;
    private int count = 0;



    public synchronized void startLoading(int loadCount) {
        while (count >= 1)
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        this.loadCount = loadCount;
        notify();
    }

    public synchronized void printLoadingProgress(){
        while (count < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println("Loading - " + loadCount + "%");
        }
        notify();
    }

}
