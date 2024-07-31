package apps.alquran.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static final String PREFS_NAME = "alquran_prefs";
    private static final String KEY_SURAH_NUMBER = "surah_number";
    private static final String KEY_SURAH_NAME = "surah_name";

    public static void saveLastOpenedSurah(Context context, String number, String name) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_SURAH_NUMBER, number);
        editor.putString(KEY_SURAH_NAME, name);
        editor.apply();
    }

    public static String[] getLastOpenedSurah(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String number = sharedPreferences.getString(KEY_SURAH_NUMBER, null);
        String name = sharedPreferences.getString(KEY_SURAH_NAME, null);
        return new String[]{number, name};
    }
}
