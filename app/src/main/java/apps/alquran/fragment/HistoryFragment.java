package apps.alquran.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import apps.alquran.R;
import apps.alquran.adapter.HistoryAdapter;
import apps.alquran.room.QuranEntity;
import apps.alquran.QuranViewModel;

public class HistoryFragment extends Fragment {

    private RecyclerView recyclerViewHistory;
    private HistoryAdapter historyAdapter;
    private QuranViewModel quranViewModel;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerViewHistory = view.findViewById(R.id.recyclerViewHistory);
        recyclerViewHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        historyAdapter = new HistoryAdapter(null);
        recyclerViewHistory.setAdapter(historyAdapter);

        quranViewModel = new ViewModelProvider(this).get(QuranViewModel.class);
        quranViewModel.getQuranList().observe(getViewLifecycleOwner(), new Observer<List<QuranEntity>>() {
            @Override
            public void onChanged(List<QuranEntity> quranEntities) {
                historyAdapter.setHistoryList(quranEntities);
            }
        });

        return view;
    }
}
