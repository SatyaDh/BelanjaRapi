package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import java.time.LocalDate;
import java.util.Date;

import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.AktivitasBelanja;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.BarangBelanjaan;
import is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model.TempatBelanja;

@Database(entities = {AktivitasBelanja.class, BarangBelanjaan.class, TempatBelanja.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "belanja_db";
    private static AppDatabase instance;

    public abstract AktivitasBelanjaDAO aktivitasBelanjaDAO();
    public abstract BarangBelanjaanDAO barangBelanjaanDAO();
    public abstract TempatBelanjaDAO tempatBelanjaDAO();

    public static synchronized AppDatabase getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private BarangBelanjaanDAO barangBelanjaanDAO;
        private TempatBelanjaDAO tempatBelanjaDAO;
        private AktivitasBelanjaDAO aktivitasBelanjaDAO;

        private PopulateDbAsyncTask (AppDatabase db){
            barangBelanjaanDAO = db.barangBelanjaanDAO();
            tempatBelanjaDAO = db.tempatBelanjaDAO();
            aktivitasBelanjaDAO = db.aktivitasBelanjaDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            BarangBelanjaan barang = new BarangBelanjaan("Sayur","Sayuran untuk masak sup", 200000);
            TempatBelanja tempat = new TempatBelanja("Indomaret", "Bottom Text", "Dimanapun", "https://ffs.kryk.io/ibhhzmwq.jpg");
            barangBelanjaanDAO.insertBarangBelanjaan(barang);
            tempatBelanjaDAO.insertTempatBelanja(tempat);
            aktivitasBelanjaDAO.insertAktivitasBelanja(new AktivitasBelanja("Test", barang, new Date(), tempat));
            return null;
        }
    }

}
