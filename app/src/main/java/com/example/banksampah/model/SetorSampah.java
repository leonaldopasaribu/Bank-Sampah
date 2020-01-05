package com.example.banksampah.model;

public class SetorSampah {
    private String jenis, berat, date;

    public SetorSampah(){

    }

    public SetorSampah(String jenis, String berat, String date){
        this.jenis = jenis;
        this.berat = berat;
        this.date = date;
    }

    public String getJenis() {

        return jenis;
    }
    public void setJenis(String jenis) {

        this.jenis = jenis;
    }
    public String getBerat() {

        return berat;
    }
    public void setBerat(String berat) {

        this.berat = berat;
    }
    public String getDate() {

        return date;
    }
    public void setDate(String date) {

        this.date = date;
    }
}
