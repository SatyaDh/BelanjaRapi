package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.BarangBelanjaan;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository.BarangBelanjaanRepository;

public class BarangBelanjaanViewModel extends AndroidViewModel {
    private BarangBelanjaanRepository repository;

    public BarangBelanjaanViewModel(@NonNull Application application) {
        super(application);
        repository = new BarangBelanjaanRepository(application);
    }

    public void insertBarangBelanjaan(BarangBelanjaan BarangBelanjaan){
        repository.insertBarangBelanjaan(BarangBelanjaan);
    }

    public void updateBarangBelanjaan(BarangBelanjaan BarangBelanjaan){
        repository.updateBarangBelanjaan(BarangBelanjaan);
    }

    public void deleteBarangBelanjaan(BarangBelanjaan BarangBelanjaan){
        repository.deleteBarangBelanjaan(BarangBelanjaan);
    }


}
