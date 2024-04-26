package models;

public class Coin {
    String name;
    double value;

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void selectCoin(String selector, Currencies cur) {
        switch (selector) {
            case "1":
                this.name = "USD";
                this.value = cur.selectCoin(selector);
                break;
            case "2":
                this.name = "ARS";
                this.value = cur.selectCoin(selector);
                break;
            case "3":
                this.name = "BOB";
                this.value = cur.selectCoin(selector);
                break;
            case "4":
                this.name = "BRL";
                this.value = cur.selectCoin(selector);
                break;
            case "5":
                this.name = "CLP";
                this.value = cur.selectCoin(selector);
                break;
            case "6":
                this.name = "COP";
                this.value = cur.selectCoin(selector);
                break;
            case "7":
                this.name = "MXN";
                this.value = cur.selectCoin(selector);
                break;

            default:
                this.name = "NO";
                break;
        }

    }

}
