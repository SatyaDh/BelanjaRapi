package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.TempatBelanja;
@Dao
public interface TempatBelanjaDAO {
    @Insert
    void insertTempatBelanja (TempatBelanja aktivitas);
    @Update
    void updateTempatBelanja (TempatBelanja aktivitas);
    @Delete
    void deleteTempatBelanja (TempatBelanja aktivitas);

}
