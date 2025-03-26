package com.yemekhane.api.controller;

import com.yemekhane.api.dto.YemekDTO;
import com.yemekhane.api.entity.Yemek;
import com.yemekhane.api.service.YemekhaneService;
import com.yemekhane.api.service.YemekService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/yemekhane")
public class YemekhaneController {

    private final YemekhaneService yemekhaneService;
    private final YemekService yemekService;

    public YemekhaneController(YemekhaneService yemekhaneService, YemekService yemekService) {
        this.yemekhaneService = yemekhaneService;
        this.yemekService = yemekService;
    }


    @GetMapping("/liste")
    public List<YemekDTO> getYemekListesi() throws IOException {
        return yemekhaneService.getYemekListesi()
                .stream()
                .map(YemekDTO::new)
                .collect(Collectors.toList());
    }


    @PostMapping("/kaydet")
    public Yemek saveYemek(@RequestBody Yemek yemek) {
        System.out.println("Gelen Yemek: " + yemek);
        return yemekService.saveYemek(yemek);
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
