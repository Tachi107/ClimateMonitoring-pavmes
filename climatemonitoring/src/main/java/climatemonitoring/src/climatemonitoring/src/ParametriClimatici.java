package climatemonitoring.src;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.Console;
import java.time.LocalDate;

public class ParametriClimatici {
    public int CentroMonitoraggio;
    public int areaDiInteresse;
    public LocalDate dataDiRilevazione;
    String[] nomiParametri = {"Vento, Umidità, Pressione, Temperatura, Precipitazioni, Altitudine, Massa"};
    public Map<String, ArrayList<String>> Parametri = new HashMap<>();

    public ParametriClimatici(int CentroMonitoraggio, int areaDiInteresse, Date dataDiRilveazione){
            this.CentroMonitoraggio = CentroMonitoraggio; 
            this.areaDiInteresse = areaDiInteresse;
            this.dataDiRilevazione = LocalDate.now();
            String value = null;
            Scanner scanner = new Scanner(System.in);
            StringBuilder input = new StringBuilder();
            int maxLength = 256;
            Console console = System.console();
            for(String nome : nomiParametri){
                Parametri.put(nome, new ArrayList<String>());
                do {
                    value = console.readLine("Inserisci un valore compreso tra 1 e 5: ");
                    if (Integer.parseInt(value) < 1 || Integer.parseInt(value) > 5) 
                        System.out.println("Valore inserito non corretto, Riprova");
                } while (Integer.parseInt(value) < 1 || Integer.parseInt(value) > 5);
                Parametri.get(nome).add(value);

                System.out.println("Enter a string (max 256 characters):");
                while (true) {
                    char c = scanner.next().charAt(0);
                    if (c == '\n')
                        break;
                    if (c == '\b') {
                        if (input.length() > 0) {
                            System.out.print("\b \b"); // Cancella l'ultimo carattere visivamente
                            input.deleteCharAt(input.length() - 1);
                        }
                    } 
                    else if (input.length() < maxLength) {
                        System.out.print(c);
                        input.append(c);
                    }
                }
            System.out.println("\nYou entered: " + input.toString());
            Parametri.get(nome).add(input.toString());
            }
    }
        

    public String toString(){
        String param = String.format("%d,%d,%s", CentroMonitoraggio, areaDiInteresse, dataDiRilevazione.toString());
        return param;
    }

}
