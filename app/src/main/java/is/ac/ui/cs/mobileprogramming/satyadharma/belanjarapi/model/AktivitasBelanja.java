package is.ac.ui.cs.mobileprogramming.satyadharma.belanjarapi.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "aktivitas_belanja")
public class AktivitasBelanja {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "judul_pembelian")
    private String judul_pembelian;
    @ColumnInfo(name = "barang_pembelian")
    private BarangBelanjaan barang_pembelian;
    @ColumnInfo(name = "status")
    private Status status;
    private Date tanggal_belanja;
    @ColumnInfo(name = "tempat_belanja")
    private TempatBelanja tempat_belanja;

    public AktivitasBelanja (String judul_pembelian, BarangBelanjaan barang_pembelian, Date tanggal_belanja ,TempatBelanja tempat_belanja){
        this.judul_pembelian = judul_pembelian;
        this.barang_pembelian = barang_pembelian;
        this.tanggal_belanja = tanggal_belanja;
        this.status = Status.PENDING;
        this.tempat_belanja = tempat_belanja;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Date getTanggal_belanja() {
        return tanggal_belanja;
    }

    public int getId() {
        return id;
    }

    public String getJudul_pembelian() {
        return judul_pembelian;
    }

    public BarangBelanjaan getBarang_pembelian() {
        return barang_pembelian;
    }

    public Status getStatus() {
        return status;
    }

    public TempatBelanja getTempat_belanja() {
        return tempat_belanja;
    }
}
