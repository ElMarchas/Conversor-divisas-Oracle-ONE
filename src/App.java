import java.util.Scanner;

import models.Coin;
import models.Currencies;

public class App {
    public static void main(String[] args) throws Exception {
        String privKey = "1a77769bb5dfbc265de2332a";
        int exit = 0;
        String inpStr = "";
        Scanner input = new Scanner(System.in);
        // Currencies currens = new Currencies(privKey);
        Currencies currens = new Currencies();

        Coin baseCoin = new Coin();
        Coin secCoin = new Coin();

        // CurrenciesRecord cur = currens.fetch(privKey);
        // System.out.println("888888888888888888888");
        // System.out.println(cur.result());
        // System.out.println(cur.conversion_rates());

        System.out.println("******* *** *** * *** *** *******");
        System.out.println("Bienvenido al conversor de divisas \nEscriba salir para terminar el programa\n");
        while (true) {
            System.out.println("Seleccione la divisa de referencia a convertir [1-7]");
            exit = getCoin(baseCoin, input, currens);
            if (exit == 1) {
                break;
            }
            System.out.printf(" --->  Divisa base seleccionada: %s, ahora su valor es 1.00 %s%n%n", baseCoin.getName(),
                    baseCoin.getName());
            System.out.println("Seleccione la divisa a convertir [1-7]");
            exit = getCoin(secCoin, input, currens);
            if (exit == 1) {
                break;
            }
            System.out.printf(" --->  Divisa seleccionada: %s, ahora su valor es %.2f %s%n%n", secCoin.getName(),
                    (baseCoin.getValue() / secCoin.getValue()),
                    baseCoin.getName());
            exit = convertion(baseCoin, secCoin, input);
            if (exit == 1) {
                break;
            }
        }
        System.out.println("\n\nPrograma finalizado, gracias por usar");
        System.out.println("******* *** *** * *** *** *******");

        input.close();

    }

    public static int convertion(Coin baseCoin, Coin secCoin, Scanner input) {
        String stg;
        while (true) {
            System.out.printf("Cuantos %s quiere convertir a %s?%n", secCoin.getName(),
                    baseCoin.getName());
            System.out.printf("Tasa de cambio 1 %s =   %.2f %s%n", baseCoin.getName(),
                    (secCoin.getValue() / baseCoin.getValue()),
                    secCoin.getName());
            stg = input.nextLine();

            System.out.printf("----->%n -->  %s %s son %.2f %s%n----->%n", stg, secCoin.getName(),
                    ((baseCoin.getValue() / secCoin.getValue()) * Double.parseDouble(stg)),
                    baseCoin.getName());

            if (stg.equalsIgnoreCase("salir")) {
                return 1;
            }
        }

    }

    public static int getCoin(Coin coin, Scanner input, Currencies cur) {
        String stg;
        while (true) {
            System.out.println("1.-USD | 2.-ARS | 3.-BOB | 4.-BRL");
            System.out.println("5.-CLP | 6.-COP | 7.-MXN | venezuela");
            stg = input.nextLine();
            coin.selectCoin(stg, cur);
            if (coin.getValue() != 0) {
                return 0;
            }
            if (stg.equalsIgnoreCase("salir")) {
                return 1;
            }
            System.out.println("Comando desconocido, ingrese un numero del 1 al 7 o escriba salir");
        }

    }
}
