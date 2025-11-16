package com.aluracursos.conversormonedas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuConverter {

    private CurrencyConverter converter = new CurrencyConverter();
    private Scanner scanner = new Scanner(System.in);

    // Mapa de monedas disponibles
    private Map<String, String> monedas = new HashMap<>();

    public MenuConverter() {
        monedas.put("USD", "Dólar estadounidense");
        monedas.put("PEN", "Sol peruano");
        monedas.put("EUR", "Euro");
        monedas.put("JPY", "Yen japonés");
        monedas.put("BRL", "Real brasileño");
    }

    public void iniciar() {
        while (true) {
            mostrarMenu();

            int opcion = obtenerOpcion();

            if (opcion == 7) {
                System.out.println("¡Gracias por usar el conversor, vuelve pronto! \uD83D\uDE0A");
                break;
            }

            procesarOpcion(opcion);
            System.out.println();
        }
    }

    private void mostrarMenu() {
        System.out.println("""
            ==================================
                   CONVERSOR DE MONEDAS       
            ==================================
                1. USD → PEN
                2. PEN → USD
                3. USD → EUR
                4. EUR → USD
                5. USD → JPY
                6. JPY → USD
                7. Salir
            ==================================
            """);
    }

    private int obtenerOpcion() {
        System.out.print("Ingrese una opción 💱: ");
        return scanner.nextInt();
    }

    private void procesarOpcion(int opcion) {
        try {
            String base = "";
            String target = "";

            switch (opcion) {
                case 1 -> { base = "USD"; target = "PEN"; }
                case 2 -> { base = "PEN"; target = "USD"; }
                case 3 -> { base = "USD"; target = "EUR"; }
                case 4 -> { base = "EUR"; target = "USD"; }
                case 5 -> { base = "USD"; target = "JPY"; }
                case 6 -> { base = "JPY"; target = "USD"; }
                default -> {
                    System.out.println("Opción inválida");
                    return;
                }
            }

            if (!monedas.containsKey(base) || !monedas.containsKey(target)) {
                System.out.println("Moneda no soportada.");
                return;
            }

            System.out.print("Cantidad en " + base + ": ");
            double cantidad = scanner.nextDouble();

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor a cero.");
                return;
            }

            double resultado = converter.convert(base, target, cantidad);
            System.out.println("Resultado: " + resultado + " " + target);

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}

