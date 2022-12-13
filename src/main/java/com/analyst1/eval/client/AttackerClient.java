package com.analyst1.eval.client;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;


public class AttackerClient {
    public HttpResponse<String> findAllAttackers(int pageNum, int size) {
        try {
            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(HttpRequest.newBuilder()
                            .uri(new URI("http://localhost:8081/api/attackers?page=" + pageNum+"&size=" +size + "&sort=ASC"))
                            .GET()
                            .build(), HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> findAllAttackersById(int id) {
        Objects.requireNonNull(id);

        try {
            HttpResponse<String> response = HttpClient.newBuilder()
                    .build()
                    .send(HttpRequest.newBuilder()
                            .uri(new URI("http://localhost:8081/api/attackers/" + id))
                            .GET()
                            .build(), HttpResponse.BodyHandlers.ofString());
            return response;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}