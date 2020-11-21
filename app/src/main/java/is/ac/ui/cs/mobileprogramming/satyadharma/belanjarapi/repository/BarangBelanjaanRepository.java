package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.BarangBelanjaanDAO;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database.AppDatabase;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.BarangBelanjaan;

public class BarangBelanjaanRepository {
    private ExecutorService executor = ExecutorHelp.getSingleThreadExecutorInstance();
    private BarangBelanjaanDAO BarangBelanjaanDAO;
    private LiveData<List<BarangBelanjaan>> allBarangBelanjaan;

    public BarangBelanjaanRepository(Application application){
        AppDatabase database = AppDatabase.getInstance(application);
        BarangBelanjaanDAO = database.barangBelanjaanDAO();
    }

    public void insertBarangBelanjaan(BarangBelanjaan BarangBelanjaan){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                BarangBelanjaanDAO.insertBarangBelanjaan(BarangBelanjaan);
            }
        });
    }
    public void updateBarangBelanjaan(BarangBelanjaan BarangBelanjaan){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                BarangBelanjaanDAO.updateBarangBelanjaan(BarangBelanjaan);
            }
        });

    }
    public void deleteBarangBelanjaan(BarangBelanjaan BarangBelanjaan){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                BarangBelanjaanDAO.deleteBarangBelanjaan(BarangBelanjaan);
            }
        });

    }

}
