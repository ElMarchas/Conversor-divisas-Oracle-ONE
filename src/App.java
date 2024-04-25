import java.util.Scanner;

import models.Currencies;
import models.CurrenciesRecord;

public class App {
    public static void main(String[] args) throws Exception {
        String privKey = "1a77769bb5dfbc265de2332a";
        Scanner input = new Scanner(System.in);
        Currencies currens = new Currencies(privKey);

        // CurrenciesRecord cur = currens.fetch(privKey);
        // System.out.println("888888888888888888888");
        // System.out.println(cur.result());
        // System.out.println(cur.conversion_rates());

        System.out.println("******* *** *** * *** *** *******");
        System.out.println("Bienvenido al conversor de divisas \n\n");
        while (true) {
            String key = input.nextLine();
            if (key.equalsIgnoreCase("salir")) {
                break;
            }
            break;
        }
        System.out.println("\n\nPrograma finalizado, gracias por usar");
        System.out.println("******* *** *** * *** *** *******");

        input.close();

    }
}
