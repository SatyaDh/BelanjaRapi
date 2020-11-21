package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tempat_belanja")
public class TempatBelanja {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "deskripsi")
    private String deskripsi;
    @ColumnInfo(name = "lokasi")
    private String lokasi;
    @ColumnInfo(name = "image_url")
    private String image_url;
    public TempatBelanja(String nama, String deskripsi, String lokasi, String image_url){
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.image_url = image_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getImage_url() {
        return image_url;
    }
}
