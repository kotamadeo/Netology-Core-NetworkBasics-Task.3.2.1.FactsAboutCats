package com.gmail.at.kotamadeo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.at.kotamadeo.model.InfoAboutCats;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final String url = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        printCatsInfo(objectMapper, url);
    }

    private static CloseableHttpClient httpClientConfiguration() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            return HttpClients.createDefault();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printCatsInfo(ObjectMapper objectMapper, String url) {
        try {
            List<InfoAboutCats> infoAboutCats = objectMapper.readValue(httpClientConfiguration()
                    .execute(new HttpGet(url)).getEntity().getContent(), new TypeReference<>() {
            });
            infoAboutCats.stream().filter(x -> x.getUpvotes() > 0)
                    .sorted(Comparator.comparingInt(InfoAboutCats::getUpvotes))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}