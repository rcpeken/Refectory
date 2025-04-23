package com.yemekhane.api.entity;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "yemekler")
public class Yemek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String tarih;
    private String yemeklerText;

        public Yemek(){}
        public Yemek(Long id, String tarih, String yemeklerText) {
            this.id = id;
            this.tarih = tarih;
            this.yemeklerText = yemeklerText;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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


