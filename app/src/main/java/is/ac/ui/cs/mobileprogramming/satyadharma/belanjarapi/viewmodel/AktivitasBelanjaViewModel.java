package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.AktivitasBelanja;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.repository.AktivitasBelanjaRepository;

public class AktivitasBelanjaViewModel extends AndroidViewModel {
    private AktivitasBelanjaRepository repository;
    private LiveData<List<AktivitasBelanja>> allAktivitasBelanja;

    public AktivitasBelanjaViewModel(@NonNull Application application) {
        super(application);
        repository = new AktivitasBelanjaRepository(application);
        allAktivitasBelanja = repository.getAllAktivitasBelanja();
    }

    public void insertAktivitasBelanja(AktivitasBelanja aktivitasBelanja){
        repository.insertAktivitasBelanja(aktivitasBelanja);
    }

    public void updateAktivitasBelanja(AktivitasBelanja aktivitasBelanja){
        repository.updateAktivitasBelanja(aktivitasBelanja);
    }

    public void deleteAktivitasBelanja(AktivitasBelanja aktivitasBelanja){
        repository.deleteAktivitasBelanja(aktivitasBelanja);
    }

    public LiveData<List<AktivitasBelanja>> getAllAktivitasBelanja() {
        return allAktivitasBelanja;
    }
}
