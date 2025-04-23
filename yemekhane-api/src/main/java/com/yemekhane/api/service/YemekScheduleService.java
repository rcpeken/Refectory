package com.yemekhane.api.service;

import com.yemekhane.api.dto.YemekDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class YemekScheduleService {

     @Autowired
    private  YemekService yemekService;

    @Scheduled(cron = "0 0 4 * * *")
     public  void otomatikYemekKaydet(){
        System.out.println("Yemek listesi scraping başladı...");
        List<YemekDTO> kaydedilenler = yemekService.saveYemek();
        System.out.println("Kaydedilen yemek sayısı: " + kaydedilenler.size());
    }
}
