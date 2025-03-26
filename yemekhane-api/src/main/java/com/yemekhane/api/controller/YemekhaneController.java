package com.yemekhane.api.controller;

import com.yemekhane.api.dto.YemekDTO;
import com.yemekhane.api.entity.Yemek;
import com.yemekhane.api.service.YemekhaneService;
import com.yemekhane.api.service.YemekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/yemekhane")
public class YemekhaneController {

    @Autowired
    private YemekService yemekService;


    @PostMapping("/kaydet")
    public List<YemekDTO> saveYemek() {
        return yemekService.saveYemek();
    }


    @GetMapping("/tum-yemekler")
    public List<Yemek> getAllYemekler() {
        return yemekService.getAllYemekler();
    }


    @GetMapping("/{id}")
    public Optional<Yemek> getYemekById(@PathVariable Long id) {
        return yemekService.getYemekById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteYemek(@PathVariable Long id) {
        yemekService.deleteYemek(id);
    }
}
