package apps.alquran.api;

import java.util.List;


import apps.alquran.data.Ayat;
import apps.alquran.data.Surah;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET("99c279bb173a6e28359c/data")
    Call<List<Surah>> getAllSurah();

    @GET
    Call<List<Ayat>> getSurahDetails(@Url String url);
}
