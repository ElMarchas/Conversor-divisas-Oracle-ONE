package models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Currencies {
    private int status;
    private String result;
    private String errorType;
    private double ARS;
    private double BOB;
    private double BRL;
    private double CLP;
    private double COP;
    private double MXN;
    private double USD = 1;

    public Currencies(String key) {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/latest/USD");
        Gson gson = new Gson();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(url).build();

        try {
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            // System.out.println(res.statusCode());
            // System.out.println(res.body());
            JsonElement je = gson.fromJson(res.body(), JsonElement.class);
            JsonObject jo = je.getAsJsonObject();
            JsonObject rates = jo.getAsJsonObject("conversion_rates");

            this.status = res.statusCode();
            this.result = jo.get("result").getAsString();
            if (!this.result.equalsIgnoreCase("success")) {
                this.errorType = jo.get("error-type").getAsString();
            }

            this.ARS = rates.get("ARS").getAsDouble();
            this.BOB = rates.get("BOB").getAsDouble();
            this.BRL = rates.get("BRL").getAsDouble();
            this.CLP = rates.get("CLP").getAsDouble();
            this.COP = rates.get("COP").getAsDouble();
            this.MXN = rates.get("MXN").getAsDouble();

            System.out.println(this.MXN);
            // return new Gson().fromJson(res.body(), CurrenciesRecord.class);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public CurrenciesRecord fetch(String key) {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + key + "/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(url).build();

        try {
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            // System.out.println(res.statusCode());
            // System.out.println(res.body());

            return new Gson().fromJson(res.body(), CurrenciesRecord.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

}
