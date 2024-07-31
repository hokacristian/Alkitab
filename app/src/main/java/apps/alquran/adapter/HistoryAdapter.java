package apps.alquran.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import apps.alquran.R;
import apps.alquran.room.QuranEntity;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<QuranEntity> historyList;

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
        holder.surahAsma.setText(entity.getAsma());
        holder.surahArti.setText(entity.getArti());
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
        TextView surahName;
        TextView surahNumber;
        TextView surahAsma;
        TextView surahArti;
        CardView cardView;

        public ViewHolder(View view) {
            super(view);
            surahName = view.findViewById(R.id.surahName);
            surahNumber = view.findViewById(R.id.surahNumber);
            surahAsma = view.findViewById(R.id.surahAsma);
            surahArti = view.findViewById(R.id.surahArti);
            cardView = view.findViewById(R.id.cvSurah);
        }
    }
}
