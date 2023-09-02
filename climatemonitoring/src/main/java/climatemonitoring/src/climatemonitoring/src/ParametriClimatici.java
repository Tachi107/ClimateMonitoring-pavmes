package climatemonitoring.src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.Console;
import java.time.LocalDate;

public class ParametriClimatici {
    public String CentroMonitoraggio;
    public String areaDiInteresse;
    public LocalDate dataDiRilevazione;
    String[] nomiParametri = {"Vento, Umidità, Pressione, Temperatura, Precipitazioni, Altitudine, Massa"};
    public Map<String, ArrayList<String>> Parametri = new HashMap<>();

    public ParametriClimatici(String CentroMonitoraggio, String areaDiInteresse){
        this.CentroMonitoraggio = CentroMonitoraggio; 
        this.areaDiInteresse = areaDiInteresse;
        this.dataDiRilevazione = LocalDate.now();
        inserisciParametriClimatici();      
    }
        

    public String toString(){
        String param = String.format("%d,%d,%s", CentroMonitoraggio, areaDiInteresse, dataDiRilevazione.toString());
        for(int i = 0; i < Parametri.size(); i++){
            ArrayList<String> parameters = Parametri.get(nomiParametri[i]);
            if(Parametri.size() -1 == i)
                param = param.concat(parameters + "");
            else
                param = param.concat(parameters + ",");
        }
        return param;
    }

    public void inserisciParametriClimatici(){
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

            System.out.print("Inserisci una nota (massimo 256 caratteri): ");
            while (true) {
                char c = scanner.next().charAt(0);
                if (c == '\n')
                    break;
                if (c == '\b') {
                    if (input.length() > 0) {
                        System.out.print("\b \b");
                        input.deleteCharAt(input.length() - 1);
                    }
                } 
                else if (input.length() < maxLength) {
                    System.out.print(c);
                    input.append(c);
                }
            }
        scanner.close();
        System.out.println("\nYou entered: " + input.toString());
        Parametri.get(nome).add(input.toString());
        }
    }

}
