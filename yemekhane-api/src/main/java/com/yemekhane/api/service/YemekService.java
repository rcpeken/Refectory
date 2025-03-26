package com.yemekhane.api.service;

import com.yemekhane.api.dto.YemekDTO;
import com.yemekhane.api.entity.Yemek;
import com.yemekhane.api.repository.YemekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class YemekService {

    @Autowired
    private YemekRepository yemekRepository;

    @Autowired
    private YemekhaneService yemekhaneService;

    public List<Yemek> getAllYemekler() {
        return yemekRepository.findAll();
    }


    public Optional<Yemek> getYemekById(Long id) {
        return yemekRepository.findById(id);
    }


    public List<YemekDTO> saveYemek() {
        try {
            List<YemekDTO> yemekList = getYemekListesi();
            yemekList.stream().forEach(content -> {
                Yemek newItem = new Yemek();
                newItem.setTarih(content.getTarih());
                newItem.setYemeklerText(content.getYemeklerText());
                yemekRepository.save(newItem);
            });
            return yemekList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }


    public void deleteYemek(Long id) {
        yemekRepository.deleteById(id);
    }

    private List<YemekDTO> getYemekListesi() throws IOException {
        return yemekhaneService.getYemekListesi()
                .stream()
                .map(YemekDTO::new)
                .collect(Collectors.toList());
    }
}
