package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.TempatBelanja;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository.TempatBelanjaRepository;

public class TempatBelanjaViewModel extends AndroidViewModel {
    private TempatBelanjaRepository repository;

    public TempatBelanjaViewModel(@NonNull Application application) {
        super(application);
        repository = new TempatBelanjaRepository(application);
    }

    public void insertTempatBelanja(TempatBelanja TempatBelanja){
        repository.insertTempatBelanja(TempatBelanja);
    }

    public void updateTempatBelanja(TempatBelanja TempatBelanja){
        repository.updateTempatBelanja(TempatBelanja);
    }

    public void deleteTempatBelanja(TempatBelanja TempatBelanja){
        repository.deleteTempatBelanja(TempatBelanja);
    }

}
