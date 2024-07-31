package apps.alquran;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import apps.alquran.adapter.SurahAdapter;
import apps.alquran.api.ApiClient;
import apps.alquran.api.ApiService;
import apps.alquran.data.Surah;
import apps.alquran.room.QuranEntity;
import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SurahAdapter surahAdapter;
    private List<Surah> surahList;

    QuranViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(QuranViewModel.class);

        ApiService apiService = ApiClient.getApiClient().create(ApiService.class);
        Call<List<Surah>> call = apiService.getAllSurah();
        /*call.enqueue(new Callback<List<Surah>>() {
            @Override
            public void onResponse(Call<List<Surah>> call, Response<List<Surah>> response) {
                surahList = response.body();
                surahAdapter = new SurahAdapter(surahList);
                recyclerView.setAdapter(surahAdapter);

                surahAdapter.setOnItemClickListener(surah -> {
                    QuranEntity quranEntity = new QuranEntity();
                    quranEntity.setId(Integer.valueOf(surah.getNomor()));
                    quranEntity.setAsma(surah.getAsma());
                    quranEntity.setNama(surah.getNama());
                    quranEntity.setNomor(Integer.valueOf(surah.getNomor()));
                    quranEntity.setIsSaved(true);
                    new Thread(() -> viewModel.addAyat(quranEntity)).start();
                    Intent intent = SurahDetailActivity.newIntent(MainActivity.this, Integer.parseInt(surah.getNomor()));
                    startActivity(intent);Override
                });
            }

            @Override
            public void onFailure(Call<List<Surah>> call, Throwable t) {
                // Handle error
            }
        });*/
    }
}
