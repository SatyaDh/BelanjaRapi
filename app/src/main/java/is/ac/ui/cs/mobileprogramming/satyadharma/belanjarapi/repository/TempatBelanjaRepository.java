package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.AppDatabase;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.TempatBelanjaDAO;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.TempatBelanja;

public class TempatBelanjaRepository {
    private ExecutorService executor = ExecutorHelp.getSingleThreadExecutorInstance();
    private is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.TempatBelanjaDAO TempatBelanjaDAO;
    private LiveData<List<TempatBelanja>> allTempatBelanja;

    public TempatBelanjaRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        TempatBelanjaDAO = database.tempatBelanjaDAO();
    }

    public void insertTempatBelanja(TempatBelanja TempatBelanja){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                TempatBelanjaDAO.insertTempatBelanja(TempatBelanja);
            }
        });
    }
    public void updateTempatBelanja(TempatBelanja TempatBelanja){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                TempatBelanjaDAO.updateTempatBelanja(TempatBelanja);
            }
        });

    }
    public void deleteTempatBelanja(TempatBelanja TempatBelanja){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                TempatBelanjaDAO.deleteTempatBelanja(TempatBelanja);
            }
        });

    }

}
