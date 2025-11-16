package com.aluracursos.conversormonedas;

import com.google.gson.Gson;

public class CurrencyConverter {
    private ApiClient apiClient = new ApiClient();
    private Gson gson = new Gson();

    public double convert(String base, String target, double amount) throws Exception{
        String json = apiClient.getRates(base);

        CurrencyResponse response = gson.fromJson(json, CurrencyResponse.class);

        if (response == null || response.conversion_rates == null) {
            throw new RuntimeException("No fue posible obtener las tasas de conversión");
        }

        Double rate = response.conversion_rates.get(target);

        if (rate == null) {
            throw new RuntimeException("La moneda objetivo no existe en la respuesta de la API");
        }

        return Math.round(amount * rate * 100.0) / 100.0;
    }
}
