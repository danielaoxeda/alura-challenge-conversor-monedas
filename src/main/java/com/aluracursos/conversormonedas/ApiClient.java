package com.aluracursos.conversormonedas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ApiClient {
    private static final String API_KEY = "f3c0ca2eb531aeb697a4e5a2";
    private static final String API_URL =
            "https://v6.exchangerate-api.com/v6/" + API_KEY +"/latest/";

    public String getRates(String baseCurrency) throws Exception {
        String finalUrl = API_URL + baseCurrency;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(finalUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        return response.body();
    }
}
