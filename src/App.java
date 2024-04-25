import java.util.Scanner;

import models.Coin;
import models.Currencies;

public class App {
    public static void main(String[] args) throws Exception {
        String privKey = "1a77769bb5dfbc265de2332a";
        String inpStr;
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
        System.out.println("Bienvenido al conversor de divisas \n\n");
        while (true) {
            System.out.println("Seleccione la divisa de referencia a convertir [1-7]");
            System.out.println("1.-USD | 2.-ARS | 3.-BOB | 4.-BRL");
            System.out.println("5.-CLP | 6.-COP | 7.-MXN | venezuela");
            inpStr = input.nextLine();
            // baseCoin = currens.selectCoin(inpStr);
            baseCoin.selectCoin(inpStr, currens);

            System.out.println(baseCoin.getName());
            System.out.println(baseCoin.getValue());

            System.out.println("Seleccione la divisa de referencia a convertir [1-7]");
            System.out.println("1.-USD | 2.-ARS | 3.-BOB | 4.-BRL");
            System.out.println("5.-CLP | 6.-COP | 7.-MXN | venezuela");
            inpStr = input.nextLine();
            // baseCoin = currens.selectCoin(inpStr);

            System.out.printf("value: %.3f", baseCoin);

            System.out.println(baseCoin);

            if (inpStr.equalsIgnoreCase("salir")) {
                break;
            }
            break;
        }
        System.out.println("\n\nPrograma finalizado, gracias por usar");
        System.out.println("******* *** *** * *** *** *******");

        input.close();

    }
}
