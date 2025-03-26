package com.yemekhane.api.dto;

public class YemekDTO {
    private String tarih;
    private String yemeklerText;

    public YemekDTO(String tarih, String yemeklerText) {
        this.tarih = tarih;
        this.yemeklerText = yemeklerText;
    }

    public YemekDTO(YemekDTO yemek) {
        this.tarih = yemek.getTarih();
        this.yemeklerText = yemek.getYemeklerText();
    }


    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getYemeklerText() {
        return yemeklerText;
    }

    public void setYemeklerText(String yemeklerText) {
        this.yemeklerText = yemeklerText;
    }
}
