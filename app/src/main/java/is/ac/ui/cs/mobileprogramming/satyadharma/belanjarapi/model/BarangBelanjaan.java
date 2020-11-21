package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "barang_belanjaan")
public class BarangBelanjaan {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nama")
    private String nama;
    @ColumnInfo(name = "deskripsi")
    private String deskripsi;
    @ColumnInfo(name = "harga")
    private int harga;

    public BarangBelanjaan(String nama, String deskripsi, int harga){
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.harga = harga;
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

    public int getHarga() {
        return harga;
    }
}
