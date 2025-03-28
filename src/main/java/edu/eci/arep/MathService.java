package edu.eci.arep;


import static spark.Spark.*;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class MathService {

    public static void main(String... args) {
        port(getPort());
        get("/primes", (req, res) -> processSearch(req.queryParams("value")));
    }

    private static String processSearch(String valueParam) {
        int value = Integer.parseInt(valueParam);
        List<Integer> primes = getPrimesUpTo(value);
        JsonObject response = createJsonResponse(value, primes);
        return response.toString();
    }

    private static List<Integer> getPrimesUpTo(int value) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= value; i++) {
            if (esPrimo(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean esPrimo(int input) {
        if (input <= 1) {
            return false;
        }
        for (int i = 2; i * i <= input; i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static JsonObject createJsonResponse(int input, List<Integer> primes) {
        JsonObject response = new JsonObject();
        response.addProperty("operation", "primes");
        response.addProperty("input", input);
        response.addProperty("output", primes.toString().replaceAll("[\\[\\] ]", ""));
        return response;
    }


    private static int getPort() {
        return System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : 8000;
    }
}
