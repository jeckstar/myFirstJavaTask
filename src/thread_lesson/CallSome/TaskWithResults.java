package thread_lesson.CallSome;

import java.util.concurrent.Callable;

public class TaskWithResults implements Callable<String> {
    private int id;

    public TaskWithResults(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result TaskWithResults " + id;
    }

}
