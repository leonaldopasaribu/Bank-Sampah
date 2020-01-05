package com.example.banksampah.model;

public class JenisSampah {
    private String jenis,image;
    public JenisSampah() {

    }

    public JenisSampah(String jenis, String image) {
        this.jenis = jenis;
        this.image = image;
    }

    public String getJenis() {

        return jenis;
    }
    public void setJenis(String jenis) {

        this.jenis = jenis;
    }
    public String getImage() {

        return image;
    }
    public void setName(String image) {

        this.image = image;
    }
}