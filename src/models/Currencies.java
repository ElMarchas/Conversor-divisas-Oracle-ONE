package models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
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

    public Currencies() {// esto es para testear nomas
        this.ARS = 100;
        this.BOB = 2;
        this.BRL = 3;
        this.CLP = 2;
        this.COP = 4;
        this.MXN = 5;
    }

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

    public int getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    public String getErrorType() {
        return errorType;
    }

    public double getARS() {
        return ARS;
    }

    public double getBOB() {
        return BOB;
    }

    public double getBRL() {
        return BRL;
    }

    public double getCLP() {
        return CLP;
    }

    public double getCOP() {
        return COP;
    }

    public double getMXN() {
        return MXN;
    }

    public double getUSD() {
        return USD;
    }

    public double selectCoin(String selector) {
        switch (selector) {
            case "1":
                return this.USD;
            case "2":
                return this.ARS;
            case "3":
                return this.BOB;
            case "4":
                return this.BRL;
            case "5":
                return this.CLP;
            case "6":
                return this.COP;
            case "7":
                return this.MXN;

            default:
                return 0;
        }

    }

}
