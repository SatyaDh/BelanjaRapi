package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class TempatBelanjaConverter {
    @TypeConverter
    public static String fromTempatBelanja (TempatBelanja tempat){
        return new Gson().toJson(tempat);
    }

    @TypeConverter
    public static TempatBelanja toBarangBelanjaan (String json){
        TempatBelanja tempat = new Gson().fromJson(json, TempatBelanja.class);
        return tempat;
    }

}
