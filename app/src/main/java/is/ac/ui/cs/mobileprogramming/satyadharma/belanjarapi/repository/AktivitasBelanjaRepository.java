package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository;

import android.app.Application;
import android.os.AsyncTask;

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
        new InsertActBAsyncTask(aktivitasBelanjaDAO).execute(aktivitasBelanja);
    }
    public void updateAktivitasBelanja(AktivitasBelanja aktivitasBelanja){
        new UpdateActBAsyncTask(aktivitasBelanjaDAO).execute(aktivitasBelanja);

    }
    public void deleteAktivitasBelanja(AktivitasBelanja aktivitasBelanja){
        new DeleteActBAsyncTask(aktivitasBelanjaDAO).execute(aktivitasBelanja);
    }

    public LiveData<List<AktivitasBelanja>> getAllAktivitasBelanja() {
        return allAktivitasBelanja;
    }

    private static class InsertActBAsyncTask extends AsyncTask<AktivitasBelanja, Void, Void>{
        private AktivitasBelanjaDAO aktivitasBelanjaDAO;

        private InsertActBAsyncTask(AktivitasBelanjaDAO aktivitasBelanjaDAO){
            this.aktivitasBelanjaDAO = aktivitasBelanjaDAO;
        }

        @Override
        protected Void doInBackground(AktivitasBelanja... aktivitasBelanjas) {
            aktivitasBelanjaDAO.insertAktivitasBelanja(aktivitasBelanjas[0]);
            return null;
        }
    }
    private static class UpdateActBAsyncTask extends AsyncTask<AktivitasBelanja, Void, Void>{
        private AktivitasBelanjaDAO aktivitasBelanjaDAO;

        private UpdateActBAsyncTask(AktivitasBelanjaDAO aktivitasBelanjaDAO){
            this.aktivitasBelanjaDAO = aktivitasBelanjaDAO;
        }

        @Override
        protected Void doInBackground(AktivitasBelanja... aktivitasBelanjas) {
            aktivitasBelanjaDAO.updateAktivitasBelanja(aktivitasBelanjas[0]);
            return null;
        }
    }

    private static class DeleteActBAsyncTask extends AsyncTask<AktivitasBelanja, Void, Void>{
        private AktivitasBelanjaDAO aktivitasBelanjaDAO;

        private DeleteActBAsyncTask(AktivitasBelanjaDAO aktivitasBelanjaDAO){
            this.aktivitasBelanjaDAO = aktivitasBelanjaDAO;
        }

        @Override
        protected Void doInBackground(AktivitasBelanja... aktivitasBelanjas) {
            aktivitasBelanjaDAO.deleteAktivitasBelanja(aktivitasBelanjas[0]);
            return null;
        }
    }


}
