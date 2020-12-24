package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.BarangBelanjaanDAO;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.AppDatabase;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.AktivitasBelanja;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.BarangBelanjaan;

public class BarangBelanjaanRepository {
    private ExecutorService executor = ExecutorHelp.getSingleThreadExecutorInstance();
    private BarangBelanjaanDAO barangBelanjaanDAO;

    public BarangBelanjaanRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        barangBelanjaanDAO = database.barangBelanjaanDAO();
    }

    public void insertBarangBelanjaan(BarangBelanjaan barangBelanjaan){
        new InsertBBAsyncTask(barangBelanjaanDAO).execute(barangBelanjaan);
    }
    public void updateBarangBelanjaan(BarangBelanjaan barangBelanjaan){
        new UpdateBBAsyncTask(barangBelanjaanDAO).execute(barangBelanjaan);

    }
    public void deleteBarangBelanjaan(BarangBelanjaan barangBelanjaan){
        new DeleteBBAsyncTask(barangBelanjaanDAO).execute(barangBelanjaan);
    }

    private static class InsertBBAsyncTask extends AsyncTask<BarangBelanjaan, Void, Void> {
        private BarangBelanjaanDAO barangBelanjaDAO;

        private InsertBBAsyncTask(BarangBelanjaanDAO barangBelanjaDAO){
            this.barangBelanjaDAO = barangBelanjaDAO;
        }

        @Override
        protected Void doInBackground(BarangBelanjaan... barangBelanjaans) {
            barangBelanjaDAO.insertBarangBelanjaan(barangBelanjaans[0]);
            return null;
        }
    }
    private static class UpdateBBAsyncTask extends AsyncTask<BarangBelanjaan, Void, Void> {
        private BarangBelanjaanDAO barangBelanjaDAO;

        private UpdateBBAsyncTask(BarangBelanjaanDAO barangBelanjaDAO){
            this.barangBelanjaDAO = barangBelanjaDAO;
        }

        @Override
        protected Void doInBackground(BarangBelanjaan... barangBelanjaans) {
            barangBelanjaDAO.updateBarangBelanjaan(barangBelanjaans[0]);
            return null;
        }
    }

    private static class DeleteBBAsyncTask extends AsyncTask<BarangBelanjaan, Void, Void> {
        private BarangBelanjaanDAO barangBelanjaDAO;

        private DeleteBBAsyncTask(BarangBelanjaanDAO barangBelanjaDAO){
            this.barangBelanjaDAO = barangBelanjaDAO;
        }

        @Override
        protected Void doInBackground(BarangBelanjaan... barangBelanjaans) {
            barangBelanjaDAO.deleteBarangBelanjaan(barangBelanjaans[0]);
            return null;
        }
    }

}
