package com.example.arifluthfiansyah.myzodiak;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arifluthfiansyah.myzodiak.models.Zodiak;
import com.example.arifluthfiansyah.myzodiak.rest.ApiClient;
import com.example.arifluthfiansyah.myzodiak.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Arif Luthfiansyah on 09/10/2016.
 */

public class FragmentDetailZodiak extends DialogFragment {

    private String[] tanggalZodiak = {
            "21-03-2016", "20-04-2016", "21-05-2016",
            "21-06-2016", "23-07-2016", "23-08-2016",
            "23-09-2016", "23-10-2016", "22-11-2016",
            "22-12-2016", "20-01-2016", "19-02-2016"};
    private TextView textUmum, textCintaSingle, textCintaCouple, textKarir;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_zodiak, container, false);
        textUmum = (TextView) view.findViewById(R.id.keterangan_umum);
        textCintaSingle = (TextView) view.findViewById(R.id.keterangan_cinta_single);
        textCintaCouple = (TextView) view.findViewById(R.id.keterangan_cinta_couple);
        textKarir = (TextView) view.findViewById(R.id.keterangan_karir);
        getData();
        return view;
    }

    public static FragmentDetailZodiak newInstance(int id_zodiak) {
        FragmentDetailZodiak fragmentDetailZodiak = new FragmentDetailZodiak();
        Bundle bundle = new Bundle();
        bundle.putInt("id_zodiak", id_zodiak);
        fragmentDetailZodiak.setArguments(bundle);
        return fragmentDetailZodiak;
    }

    public void getData() {
        ApiClient.getRetrofit().create(ApiInterface.class).getZodiak("app", tanggalZodiak[this.getArguments().getInt("id_zodiak")]).enqueue(new Callback<Zodiak>() {
            @Override
            public void onResponse(Call<Zodiak> call, Response<Zodiak> response) {
                textUmum.setText(response.body().getRamalan().getUmum());
                textCintaSingle.setText(response.body().getRamalan().getPercintaan().getSingle());
                textCintaCouple.setText(response.body().getRamalan().getPercintaan().getCouple());
                textKarir.setText(response.body().getRamalan().getKarirKeuangan());
            }

            @Override
            public void onFailure(Call<Zodiak> call, Throwable t) {

            }
        });
    }
}
