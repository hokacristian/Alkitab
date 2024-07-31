package apps.alquran.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quran")
public class QuranEntity {
    @ColumnInfo(name = "id")
    @PrimaryKey
    Integer id;

    @ColumnInfo(name = "nama")
    String nama;

    @ColumnInfo(name = "asma")
    String asma;

    @ColumnInfo(name = "nomor")
    Integer nomor;

    @ColumnInfo(name = "arti")
    String arti;

    @ColumnInfo(name = "isSaved")
    Boolean isSaved;

    // Getter and Setter for id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter and Setter for asma
    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }

    // Getter and Setter for nomor
    public Integer getNomor() {
        return nomor;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }

    // Getter and Setter for arti
    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }

    // Getter and Setter for isSaved
    public Boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(Boolean isSaved) {
        this.isSaved = isSaved;
    }
}
