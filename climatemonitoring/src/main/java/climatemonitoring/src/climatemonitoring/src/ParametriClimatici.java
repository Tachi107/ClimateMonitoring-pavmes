//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.Console;
import java.time.LocalDate;


/** gestisce la registrazione dei parametri climatici per un determinato centro di monitoraggio e un'area di interesse */
public class ParametriClimatici {
    public String CentroMonitoraggio;
    public String areaDiInteresse;
    /** data di rilevazione dei parametri */
    public LocalDate dataDiRilevazione;
    /** tutti i parametri da inserire */
    public static final String[] nomiParametri = {"Vento", "Umidità", "Pressione", "Temperatura", "Precipitazioni", "Altitudine", "Massa"};

    /** dizionario con tipo di parametro e valore associato */
    public Map<String, ArrayList<String>> Parametri = new HashMap<>();

    /** costruttore dei ParametriClimatici che imposta i campi della classe ParametriClimatici in base ai parametri forniti */
    public ParametriClimatici(String CentroMonitoraggio, String areaDiInteresse){
        this.CentroMonitoraggio = CentroMonitoraggio; 
        this.areaDiInteresse = areaDiInteresse;
        this.dataDiRilevazione = LocalDate.now();
        inserisciParametriClimatici();      
    }
    public ParametriClimatici(){
    }
        

    /** restituisce una rappresentazione in formato di stringa degli oggetti ParametriClimatici, compresi i campi e i valori dei parametri climatici. */
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

    /** utilizzata per inserire i parametri climatici associati a una determinata area di interesse */
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
