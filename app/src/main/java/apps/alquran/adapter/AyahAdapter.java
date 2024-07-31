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

public class AyahAdapter extends RecyclerView.Adapter<AyahAdapter.AyahViewHolder> {
    private List<Ayat> ayahList;

    public AyahAdapter(List<Ayat> ayahList) {
        this.ayahList = ayahList;
    }

    @NonNull
    @Override
    public AyahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ayah, parent, false);
        return new AyahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyahViewHolder holder, int position) {
        Ayat ayat = ayahList.get(position);
        holder.txtAyahNumber.setText(ayat.getNomor());
        holder.txtAyahAr.setText(ayat.getAr());
        holder.txtAyahTr.setText(HtmlUtils.stripHtmlTags(ayat.getTr()));
        holder.txtAyahId.setText(ayat.getId());
    }

    @Override
    public int getItemCount() {
        return ayahList.size();
    }

    public static class AyahViewHolder extends RecyclerView.ViewHolder {
        TextView txtAyahNumber, txtAyahAr, txtAyahTr, txtAyahId;

        public AyahViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAyahNumber = itemView.findViewById(R.id.txtAyahNumber);
            txtAyahAr = itemView.findViewById(R.id.txtAyahAr);
            txtAyahTr = itemView.findViewById(R.id.txtAyahTr);
            txtAyahId = itemView.findViewById(R.id.txtAyahId);
        }
    }
}
