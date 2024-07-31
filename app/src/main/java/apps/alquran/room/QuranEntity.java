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

    @ColumnInfo(name = "isSaved")
    Boolean isSaved;

    // Getter dan Setter untuk id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter dan Setter untuk nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan Setter untuk asma
    public String getAsma() {
        return asma;
    }

    public void setAsma(String asma) {
        this.asma = asma;
    }

    // Getter dan Setter untuk nomor
    public Integer getNomor() {
        return nomor;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }

    // Getter dan Setter untuk isSaved
    public Boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(Boolean isSaved) {
        this.isSaved = isSaved;
    }
}
