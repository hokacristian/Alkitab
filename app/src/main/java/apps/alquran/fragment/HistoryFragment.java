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
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HistoryFragment extends Fragment {

    private RecyclerView recyclerViewHistory;
    private HistoryAdapter historyAdapter;
    private QuranViewModel quranViewModel;
    QuranViewModel viewModel;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewHistory = view.findViewById(R.id.recyclerViewHistory);
        recyclerViewHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        historyAdapter = new HistoryAdapter();
        recyclerViewHistory.setAdapter(historyAdapter);

        quranViewModel = new ViewModelProvider(this).get(QuranViewModel.class);

        quranViewModel.getList();
        quranViewModel.getQuranList().observe(getViewLifecycleOwner(), quranEntities -> historyAdapter.setHistoryList(quranEntities));

    }
}
