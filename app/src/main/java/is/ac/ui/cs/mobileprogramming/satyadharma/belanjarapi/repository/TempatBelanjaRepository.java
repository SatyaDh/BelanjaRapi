package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.AppDatabase;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.TempatBelanjaDAO;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.TempatBelanja;

public class TempatBelanjaRepository {
    private ExecutorService executor = ExecutorHelp.getSingleThreadExecutorInstance();
    private is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.TempatBelanjaDAO tempatBelanjaDAO;
    private LiveData<List<TempatBelanja>> allTempatBelanja;

    public TempatBelanjaRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        tempatBelanjaDAO = database.tempatBelanjaDAO();
    }

    public void insertTempatBelanja(TempatBelanja tempatBelanja){
        new InsertTTAsyncTask(tempatBelanjaDAO).execute(tempatBelanja);
    }
    public void updateTempatBelanja(TempatBelanja tempatBelanja){
        new UpdateTTAsyncTask(tempatBelanjaDAO).execute(tempatBelanja);

    }
    public void deleteTempatBelanja(TempatBelanja tempatBelanja){
        new DeleteTTAsyncTask(tempatBelanjaDAO).execute(tempatBelanja);

    }
    private static class InsertTTAsyncTask extends AsyncTask<TempatBelanja, Void, Void> {
        private TempatBelanjaDAO tempatBelanjaDAO;

        private InsertTTAsyncTask(TempatBelanjaDAO tempatBelanjaDAO){
            this.tempatBelanjaDAO = tempatBelanjaDAO;
        }

        @Override
        protected Void doInBackground(TempatBelanja... TempatBelanjas) {
            tempatBelanjaDAO.insertTempatBelanja(TempatBelanjas[0]);
            return null;
        }
    }
    private static class UpdateTTAsyncTask extends AsyncTask<TempatBelanja, Void, Void> {
        private TempatBelanjaDAO tempatBelanjaDAO;

        private UpdateTTAsyncTask(TempatBelanjaDAO tempatBelanjaDAO){
            this.tempatBelanjaDAO = tempatBelanjaDAO;
        }

        @Override
        protected Void doInBackground(TempatBelanja... TempatBelanjas) {
            tempatBelanjaDAO.updateTempatBelanja(TempatBelanjas[0]);
            return null;
        }
    }
    private static class DeleteTTAsyncTask extends AsyncTask<TempatBelanja, Void, Void> {
        private TempatBelanjaDAO tempatBelanjaDAO;

        private DeleteTTAsyncTask(TempatBelanjaDAO tempatBelanjaDAO){
            this.tempatBelanjaDAO = tempatBelanjaDAO;
        }

        @Override
        protected Void doInBackground(TempatBelanja... TempatBelanjas) {
            tempatBelanjaDAO.deleteTempatBelanja(TempatBelanjas[0]);
            return null;
        }
    }


}
