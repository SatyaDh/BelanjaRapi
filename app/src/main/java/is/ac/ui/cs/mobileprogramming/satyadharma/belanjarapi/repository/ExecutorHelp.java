package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorHelp {
    private static ExecutorService instance;

    public static synchronized ExecutorService getSingleThreadExecutorInstance(){
        if(instance == null){
            instance = Executors.newSingleThreadExecutor();
        }
        return instance;
    }

}
