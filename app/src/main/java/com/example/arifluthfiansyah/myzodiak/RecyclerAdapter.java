package com.example.arifluthfiansyah.myzodiak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Arif Luthfiansyah on 09/10/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private String[] namaZodiak = {
            "Aries", "Taurus", "Gemini",
            "Cancer", "Leo", "Virgo",
            "Libra", "Scorpio", "Sagitarius",
            "Capricone", "Aquarius", "Pices"};
    private String[] rangeZodiak = {
            "21 Maret - 19 April", "20 April - 20 Mei", "21 Mei - 20 Juni",
            "21 Juni - 22 Juli", "23 Juli - 22 Agustus", "23 Agustus - 22 September",
            "23 September - 22 Oktober", "23 Oktober - 21 November", "22 November - 21 Desember",
            "22 Desember - 19 Januari", "20 Januari - 18 Februari", "19 Februari - 20 Maret"};
    private String[] iconZodiak = {
            "ic_aries", "ic_taurus", "ic_gemini",
            "ic_cancer", "ic_leo", "ic_virgo",
            "ic_libra", "ic_scorpio", "ic_sagitarius",
            "ic_capricon", "ic_aquarius", "ic_pisces"
    };
    private Context context;
    private zodiakListener zodiakListener;

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView nameZodiac, rangeZodiac;
        private ImageView imageZodiac;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nameZodiac = (TextView) itemView.findViewById(R.id.nama_zodiak);
            rangeZodiac = (TextView) itemView.findViewById(R.id.range_zodiak);
            imageZodiac = (ImageView) itemView.findViewById(R.id.gambar_zodiak);
        }

        @Override
        public void onClick(View v) {
            zodiakListener.onItemClick(getAdapterPosition());
        }
    }

    public interface zodiakListener {
        void onItemClick(int position);
    }

    public RecyclerAdapter(Context context, zodiakListener listener) {
        this.context = context;
        this.zodiakListener = listener;
    }

    @Override
    public int getItemCount() {
        return namaZodiak.length;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nameZodiac.setText(namaZodiak[position]);
        holder.rangeZodiac.setText(rangeZodiak[position]);
        holder.imageZodiac.setBackgroundResource(context.getResources().getIdentifier(iconZodiak[position], "drawable", context.getPackageName()));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_zodiak, parent, false));
    }
}
