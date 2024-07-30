package apps.alquran.module;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import apps.alquran.room.QuranDao;
import apps.alquran.room.QuranDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class LocalModule {

    @Provides
    @Singleton
    public static QuranDatabase provideDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, QuranDatabase.class, "Quran.db").build();
    }

    @Provides
    @Singleton
    public static QuranDao provideDao(QuranDatabase database) {
        return database.dao();
    }
}
