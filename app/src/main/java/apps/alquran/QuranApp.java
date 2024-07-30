package apps.alquran;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class QuranApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
