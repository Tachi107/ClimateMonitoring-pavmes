//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.Console;
import java.time.LocalDate;

public class ParametriClimatici {
    public String CentroMonitoraggio;
    public String areaDiInteresse;
    public LocalDate dataDiRilevazione;
    String[] nomiParametri = {"Vento", "Umidità", "Pressione", "Temperatura", "Precipitazioni", "Altitudine", "Massa"};
    public Map<String, ArrayList<String>> Parametri = new HashMap<>();

    public ParametriClimatici(String CentroMonitoraggio, String areaDiInteresse){
        this.CentroMonitoraggio = CentroMonitoraggio; 
        this.areaDiInteresse = areaDiInteresse;
        this.dataDiRilevazione = LocalDate.now();
        inserisciParametriClimatici();      
    }
        

    public String toString(){
        String param = String.format("%s,%s,%s,", CentroMonitoraggio, areaDiInteresse, dataDiRilevazione.toString());
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
        int maxLength = 256;
        String line = null;
        Console console = System.console();
        for(String nome : nomiParametri){
            Parametri.put(nome, new ArrayList<String>());
            do {
                value = console.readLine("Inserisci un valore compreso tra 1 e 5 per " + nome + ": ");
                if ((value.isEmpty() || !Regex.isNumeric(value)) || (Integer.parseInt(value) < 1 || Integer.parseInt(value) > 5)) 
                    System.out.println("Valore inserito non corretto, Riprova");
            } while ((value.isEmpty() || !Regex.isNumeric(value)) || (Integer.parseInt(value) < 1 || Integer.parseInt(value) > 5));
            Parametri.get(nome).add(value);
            System.out.print("Inserisci una nota (massimo 256 caratteri): ");
            while (true) {
                line = console.readLine();
                if (line.isEmpty() || line == null)
                    break;
                else if (line.length() > maxLength) {
                    System.out.print("Stringa troppo lunga...Riprova: ");
                }
                else{
                    break;
                }
            }
            System.out.println("Nota inserita con successo!");
            Parametri.get(nome).add(line);
        }
    }
}
