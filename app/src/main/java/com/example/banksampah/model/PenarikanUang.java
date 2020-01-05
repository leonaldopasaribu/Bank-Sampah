package com.example.banksampah.model;

public class PenarikanUang {
    private String jumlah, date;

    public PenarikanUang(){

    }

    public PenarikanUang(String jumlah, String date){
        this.jumlah = jumlah;
        this.date = date;
    }

    public String getJumlah() {

        return jumlah;
    }
    public void setJumlah(String jumlah) {

        this.jumlah = jumlah;
    }
    public String getDate() {

        return date;
    }
    public void setDate(String date) {

        this.date = date;
    }
}
