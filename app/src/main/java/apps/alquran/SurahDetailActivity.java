package apps.alquran;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import apps.alquran.api.ApiClient;
import apps.alquran.api.ApiService;
import apps.alquran.data.Ayat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahDetailActivity extends AppCompatActivity {

    private static final String EXTRA_SURAH_NUMBER = "EXTRA_SURAH_NUMBER";
    private TextView tvSurahDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_detail);

        tvSurahDetails = findViewById(R.id.tvSurahDetails);

        int surahNumber = getIntent().getIntExtra(EXTRA_SURAH_NUMBER, -1);
        if (surahNumber != -1) {
            loadSurahDetails(surahNumber);
        }
    }

    private void loadSurahDetails(int surahNumber) {
        String apiUrl = "https://api.npoint.io/99c279bb173a6e28359c/surat/" + surahNumber;
        ApiService apiService = ApiClient.getApiClient().create(ApiService.class);
        Call<List<Ayat>> call = apiService.getSurahDetails(apiUrl);
        call.enqueue(new Callback<List<Ayat>>() {
            @Override
            public void onResponse(Call<List<Ayat>> call, Response<List<Ayat>> response) {
                List<Ayat> ayatList = response.body();
                if (ayatList != null) {
                    StringBuilder details = new StringBuilder();
                    for (Ayat ayat : ayatList) {
                        details.append(ayat.getAr()).append("\n")
                                .append(ayat.getId()).append("\n\n");
                    }
                    tvSurahDetails.setText(details.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Ayat>> call, Throwable t) {
                tvSurahDetails.setText("Failed to load data");
            }
        });
    }

    public static Intent newIntent(Context context, int surahNumber) {
        Intent intent = new Intent(context, SurahDetailActivity.class);
        intent.putExtra(EXTRA_SURAH_NUMBER, surahNumber);
        return intent;
    }
}
