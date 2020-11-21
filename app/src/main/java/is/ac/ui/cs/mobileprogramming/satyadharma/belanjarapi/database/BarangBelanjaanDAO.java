package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.BarangBelanjaan;

@Dao
public interface BarangBelanjaanDAO {
    @Insert
    void insertBarangBelanjaan (BarangBelanjaan aktivitas);
    @Update
    void updateBarangBelanjaan (BarangBelanjaan aktivitas);
    @Delete
    void deleteBarangBelanjaan (BarangBelanjaan aktivitas);

}
