package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class BarangBelanjaanConverter {
    @TypeConverter
    public static String fromBarangBelanjaan (BarangBelanjaan barang){
        return new Gson().toJson(barang);
    }

    @TypeConverter
    public static BarangBelanjaan toBarangBelanjaan (String json){
        BarangBelanjaan barang = new Gson().fromJson(json, BarangBelanjaan.class);
        return barang;
    }
}
