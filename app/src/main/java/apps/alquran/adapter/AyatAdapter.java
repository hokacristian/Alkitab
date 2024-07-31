package apps.alquran.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import apps.alquran.R;
import apps.alquran.data.Ayat;

import apps.alquran.utils.HtmlUtils;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.AyatViewHolder> {
    private List<Ayat> ayatList;

    public AyatAdapter(List<Ayat> ayatList) {
        this.ayatList = ayatList;
    }

    @NonNull
    @Override
    public AyatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ayat, parent, false);
        return new AyatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyatViewHolder holder, int position) {
        Ayat ayat = ayatList.get(position);
        holder.txtAyatNumber.setText(ayat.getNomor());
        holder.txtAyatAr.setText(ayat.getAr());
        holder.txtAyatTr.setText(HtmlUtils.stripHtmlTags(ayat.getTr()));
        holder.txtAyatId.setText(ayat.getId());
    }

    @Override
    public int getItemCount() {
        return ayatList.size();
    }

    public static class AyatViewHolder extends RecyclerView.ViewHolder {
        TextView txtAyatNumber, txtAyatAr, txtAyatTr, txtAyatId;

        public AyatViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAyatNumber = itemView.findViewById(R.id.txtAyatNumber);
            txtAyatAr = itemView.findViewById(R.id.txtAyatAr);
            txtAyatTr = itemView.findViewById(R.id.txtAyatTr);
            txtAyatId = itemView.findViewById(R.id.txtAyatId);
        }
    }
}
