package apps.alquran.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import apps.alquran.R;
import apps.alquran.data.Surah;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahViewHolder> {
    private List<Surah> surahList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Surah surah);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SurahAdapter(List<Surah> surahList) {
        this.surahList = surahList;
    }

    @NonNull
    @Override
    public SurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_surah, parent, false);
        return new SurahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SurahViewHolder holder, int position) {
        Surah surah = surahList.get(position);
        holder.tvNama.setText(surah.getNama());
        holder.tvArti.setText(surah.getArti());
        holder.tvAsma.setText(surah.getAsma());
        holder.tvKeterangan.setText(surah.getKeterangan());
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(surah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public static class SurahViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvArti, tvAsma, tvKeterangan;

        public SurahViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvArti = itemView.findViewById(R.id.tvArti);
            tvAsma = itemView.findViewById(R.id.tvAsma);
            tvKeterangan = itemView.findViewById(R.id.tvKeterangan);
        }
    }
}
