
package com.example.arifluthfiansyah.myzodiak.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ramalan {

    @SerializedName("umum")
    @Expose
    private String umum;
    @SerializedName("percintaan")
    @Expose
    private Percintaan percintaan;
    @SerializedName("karir_keuangan")
    @Expose
    private String karirKeuangan;

    /**
     * 
     * @return
     *     The umum
     */
    public String getUmum() {
        return umum;
    }

    /**
     * 
     * @param umum
     *     The umum
     */
    public void setUmum(String umum) {
        this.umum = umum;
    }

    /**
     * 
     * @return
     *     The percintaan
     */
    public Percintaan getPercintaan() {
        return percintaan;
    }

    /**
     * 
     * @param percintaan
     *     The percintaan
     */
    public void setPercintaan(Percintaan percintaan) {
        this.percintaan = percintaan;
    }

    /**
     * 
     * @return
     *     The karirKeuangan
     */
    public String getKarirKeuangan() {
        return karirKeuangan;
    }

    /**
     * 
     * @param karirKeuangan
     *     The karir_keuangan
     */
    public void setKarirKeuangan(String karirKeuangan) {
        this.karirKeuangan = karirKeuangan;
    }

}
