package com.yemekhane.api.service;

import com.yemekhane.api.entity.Yemek;
import com.yemekhane.api.repository.YemekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class YemekService {

    private final YemekRepository yemekRepository;

    @Autowired
    public YemekService(YemekRepository yemekRepository) {
        this.yemekRepository = yemekRepository;
    }


    public List<Yemek> getAllYemekler() {
        return yemekRepository.findAll();
    }


    public Optional<Yemek> getYemekById(Long id) {
        return yemekRepository.findById(id);
    }


    public Yemek saveYemek(Yemek yemek) {
        return yemekRepository.save(yemek);
    }


    public void deleteYemek(Long id) {
        yemekRepository.deleteById(id);
    }
}
