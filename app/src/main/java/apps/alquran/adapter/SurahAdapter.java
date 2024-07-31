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
import apps.alquran.data.Surah;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahViewHolder> {
    private List<Surah> surahList;
    private OnItemClickListener listener;

    public SurahAdapter(List<Surah> surahList, OnItemClickListener listener) {
        this.surahList = surahList;
        this.listener = listener;
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
        holder.txtNumber.setText(surah.getNomor());
        holder.txtAyat.setText(surah.getAyat() + " Ayat");
        holder.txtName.setText(surah.getNama());
        holder.txtInfo.setText(surah.getArti());  // Update to use getArti()
        holder.txtAsma.setText(surah.getAsma());

        holder.cardView.setOnClickListener(v -> listener.onItemClick(surah));
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public static class SurahViewHolder extends RecyclerView.ViewHolder {
        TextView txtNumber, txtAyat, txtName, txtInfo, txtAsma;
        CardView cardView;

        public SurahViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtAyat = itemView.findViewById(R.id.txtAyat);
            txtName = itemView.findViewById(R.id.txtName);
            txtInfo = itemView.findViewById(R.id.txtInfo);
            txtAsma = itemView.findViewById(R.id.txtAsma);
            cardView = itemView.findViewById(R.id.cvSurah);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Surah surah);
    }
}
