package apps.alquran;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import apps.alquran.adapter.SurahAdapter;
import apps.alquran.api.ApiClient;
import apps.alquran.api.ApiService;
import apps.alquran.data.Surah;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SurahAdapter surahAdapter;
    private List<Surah> surahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiService apiService = ApiClient.getApiClient().create(ApiService.class);
        Call<List<Surah>> call = apiService.getAllSurah();
        call.enqueue(new Callback<List<Surah>>() {
            @Override
            public void onResponse(Call<List<Surah>> call, Response<List<Surah>> response) {
                surahList = response.body();
                surahAdapter = new SurahAdapter(surahList);
                recyclerView.setAdapter(surahAdapter);

                surahAdapter.setOnItemClickListener(surah -> {
                    Intent intent = SurahDetailActivity.newIntent(MainActivity.this, Integer.parseInt(surah.getNomor()));
                    startActivity(intent);
                });
            }

            @Override
            public void onFailure(Call<List<Surah>> call, Throwable t) {
                // Handle error
            }
        });
    }
}
