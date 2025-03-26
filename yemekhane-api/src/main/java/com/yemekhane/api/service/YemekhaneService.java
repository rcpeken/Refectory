package com.yemekhane.api.service;

import com.yemekhane.api.dto.YemekDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class YemekhaneService {

    private static final String URL = "https://www.cumhuriyet.edu.tr/yemeklistesi/index.php";

    public List<YemekDTO> getYemekListesi() throws IOException {
        Document doc = Jsoup.connect(URL).get();
        Elements yemekListesi = doc.select("div#ylistTable div.mitem");

        return yemekListesi.stream()
                .map(yemekGun -> new YemekDTO(
                        yemekGun.select("h4").text(),
                        yemekGun.html()
                                .replaceAll("<h4.*?</h4>", "")
                                .replaceAll("<br>", " | ")
                                .replaceAll("<[^>]*>", "")
                                .replaceAll("\n", " ")
                                .trim()
                ))
                .collect(Collectors.toList());
    }
}
