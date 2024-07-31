package apps.alquran.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import apps.alquran.R;
import apps.alquran.room.QuranEntity;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<QuranEntity> historyList;

//    public HistoryAdapter(List<QuranEntity> historyList) {
//        this.historyList = historyList;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuranEntity entity = historyList.get(position);
        holder.surahName.setText(entity.getNama());
        holder.surahNumber.setText(String.valueOf(entity.getNomor()));
    }

    @Override
    public int getItemCount() {
        return historyList != null ? historyList.size() : 0;
    }

    public void setHistoryList(List<QuranEntity> historyList) {
        this.historyList = historyList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView surahName;
        public TextView surahNumber;

        public ViewHolder(View view) {
            super(view);
            surahName = view.findViewById(R.id.surahName);
            surahNumber = view.findViewById(R.id.surahNumber);
        }
    }
}
