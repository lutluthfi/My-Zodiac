package com.example.arifluthfiansyah.myzodiak.rest;

import com.example.arifluthfiansyah.myzodiak.models.Zodiak;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Arif Luthfiansyah on 09/10/2016.
 */

public interface ApiInterface {
    @GET("zodiak")
    Call<Zodiak> getZodiak(@Query("nama") String nama, @Query("tgl") String tgl);
}
