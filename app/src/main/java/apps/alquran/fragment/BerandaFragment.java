package apps.alquran.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import apps.alquran.QuranViewModel;
import apps.alquran.R;
import apps.alquran.adapter.SurahAdapter;
import apps.alquran.api.ApiClient;
import apps.alquran.api.ApiService;
import apps.alquran.data.Surah;
import apps.alquran.room.QuranEntity;
import apps.alquran.utils.Preferences;
import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AndroidEntryPoint
public class BerandaFragment extends Fragment implements SurahAdapter.OnItemClickListener {

    private RecyclerView recyclerViewSurah;
    private SurahAdapter surahAdapter;
    private List<Surah> surahList;
    private List<Surah> filteredSurahList;

    QuranViewModel viewModel;

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        recyclerViewSurah = view.findViewById(R.id.recyclerViewSurah);
        recyclerViewSurah.setLayoutManager(new LinearLayoutManager(getContext()));

        SearchView searchView = view.findViewById(R.id.searchView);

        viewModel = new ViewModelProvider(this).get(QuranViewModel.class);

        ApiService apiService = ApiClient.getApiClient().create(ApiService.class);
        Call<List<Surah>> call = apiService.getAllSurah();
        call.enqueue(new Callback<List<Surah>>() {
            @Override
            public void onResponse(Call<List<Surah>> call, Response<List<Surah>> response) {
                surahList = response.body();
                filteredSurahList = new ArrayList<>(surahList);
                surahAdapter = new SurahAdapter(filteredSurahList, BerandaFragment.this);
                recyclerViewSurah.setAdapter(surahAdapter);
            }

            @Override
            public void onFailure(Call<List<Surah>> call, Throwable t) {
                // Handle error
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

        return view;
    }

    private void filter(String text) {
        filteredSurahList.clear();
        if (text.isEmpty()) {
            filteredSurahList.addAll(surahList);
        } else {
            text = text.toLowerCase();
            for (Surah surah : surahList) {
                if (surah.getNama().toLowerCase().contains(text)) {
                    filteredSurahList.add(surah);
                }
            }
        }
        surahAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(Surah surah) {
        Bundle bundle = new Bundle();
        bundle.putString("nomor", surah.getNomor());
        bundle.putString("name", surah.getNama());

        QuranEntity quranEntity = new QuranEntity();
        quranEntity.setId(Integer.valueOf(surah.getNomor()));
        quranEntity.setAsma(surah.getAsma());
        quranEntity.setNama(surah.getNama());
        quranEntity.setNomor(Integer.valueOf(surah.getNomor()));
        quranEntity.setIsSaved(true);
        new Thread(() -> viewModel.addAyat(quranEntity)).start();

        Preferences.saveLastOpenedSurah(getContext(), surah.getNomor(), surah.getNama());

        MenuAlQuranFragment menuAlQuranFragment = new MenuAlQuranFragment();
        menuAlQuranFragment.setArguments(bundle);

        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, menuAlQuranFragment)
                .addToBackStack(null)
                .commit();
    }
}
