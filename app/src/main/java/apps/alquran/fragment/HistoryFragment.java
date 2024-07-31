package apps.alquran.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerViewHistory = view.findViewById(R.id.recyclerViewHistory);
        recyclerViewHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        historyAdapter = new HistoryAdapter();
        recyclerViewHistory.setAdapter(historyAdapter);

        quranViewModel = new ViewModelProvider(this).get(QuranViewModel.class);
        quranViewModel.getQuranList().observe(getViewLifecycleOwner(), quranEntities -> historyAdapter.setHistoryList(quranEntities));

        // Set up back button functionality
        ImageButton backButton = view.findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> navigateToBerandaFragment());

        return view;
    }

    private void navigateToBerandaFragment() {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new BerandaFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navigateToBerandaFragment();
            }
        });
    }
}
