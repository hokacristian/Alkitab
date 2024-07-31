package apps.alquran.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuranDao {
    @Query("select * from quran order by id desc")
    LiveData<List<QuranEntity>> getQuran();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void save(QuranEntity entity);

    @Query("delete from quran where nomor = :nomor")
    void delete(Integer nomor);

    @Query("select exists(select * from quran where nomor = :nomor and isSaved = 1)")
    boolean isSaved(Integer nomor);
}
