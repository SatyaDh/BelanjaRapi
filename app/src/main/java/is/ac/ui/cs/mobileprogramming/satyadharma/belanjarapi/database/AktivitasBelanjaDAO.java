package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.AktivitasBelanja;

@Dao
public interface AktivitasBelanjaDAO {
    @Query("Select * from aktivitas_belanja")
    LiveData<List<AktivitasBelanja>> getAktivitasBelanja();
    @Insert
    void insertAktivitasBelanja (AktivitasBelanja aktivitas);
    @Update
    void updateAktivitasBelanja (AktivitasBelanja aktivitas);
    @Delete
    void deleteAktivitasBelanja (AktivitasBelanja aktivitas);
}
