package apps.alquran.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {QuranEntity.class}, version = 1, exportSchema = false)
public abstract class QuranDatabase extends RoomDatabase {
    public abstract QuranDao dao();
}
