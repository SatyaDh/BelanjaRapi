package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.AktivitasBelanjaDAO;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.AppDatabase;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.AktivitasBelanja;

public class AktivitasBelanjaRepository {
    private ExecutorService executor = ExecutorHelp.getSingleThreadExecutorInstance();
    private AktivitasBelanjaDAO aktivitasBelanjaDAO;
    private LiveData<List<AktivitasBelanja>> allAktivitasBelanja;

    public AktivitasBelanjaRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        aktivitasBelanjaDAO = database.aktivitasBelanjaDAO();
        allAktivitasBelanja = aktivitasBelanjaDAO.getAktivitasBelanja();
    }

    public void insertAktivitasBelanja(AktivitasBelanja aktivitasBelanja){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                aktivitasBelanjaDAO.insertAktivitasBelanja(aktivitasBelanja);
            }
        });
    }
    public void updateAktivitasBelanja(AktivitasBelanja aktivitasBelanja){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                aktivitasBelanjaDAO.updateAktivitasBelanja(aktivitasBelanja);
            }
        });

    }
    public void deleteAktivitasBelanja(AktivitasBelanja aktivitasBelanja){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                aktivitasBelanjaDAO.deleteAktivitasBelanja(aktivitasBelanja);
            }
        });

    }

    public LiveData<List<AktivitasBelanja>> getAllAktivitasBelanja() {
        return allAktivitasBelanja;
    }
}
