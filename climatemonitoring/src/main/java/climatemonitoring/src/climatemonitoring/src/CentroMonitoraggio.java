//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.text.similarity.LevenshteinDistance;



/**
 * Classe che contiene le informazioni di un centro di monitoraggio.
 */
public class CentroMonitoraggio {
    /** codice del centro */
    public int codice;
    /** nome del centro */
    public String nome;
    /** lista che contiene i codici(interi) delle aree che fanno parte del centro  */
    public List<Integer> Aree;
    /** indirizzo del centro */
    public String Indirizzo;

    /** costruttore dell'area di interesse che imposta i campi del centro in base ai parametri forniti 
     * 
     * @param codice codice del centro
     * @param nome nome del centro
     * @param Indirizzo indirizzo del centro
     * 
    */
    public CentroMonitoraggio(int codice, String nome, String Indirizzo){
        this.codice = codice;
        this.nome = nome;
        this.Indirizzo = Indirizzo;
        Aree = new ArrayList<Integer>();
    }

    /**
     * consente agli utenti di 
     * aggiungere aree di interesse a un centro di monitoraggio
     * @param dati contiene le aree presenti nel file CoordinateMonitoraggio.csv
     */
    public void AggiungiAree(Dati dati){
        List<String[]> aree = dati.coordinate;
        Console console = System.console();
        String str = null;
        String check = null;
        boolean aggiunto = false;
        do{

            str = console.readLine("Inserisci il nome dell'area che vuoi aggiungere \nPremi Enter se hai finito: ");
            if(str.length() == 0)
                break;
            for(String[] nome : aree){
                if(nome.length > 2){
                int distance = LevenshteinDistance.getDefaultInstance().apply(str, nome[1]);
                if(distance == 0){
                    aggiunto = Aree.add(Integer.parseInt(nome[0]));
                    System.out.println("Hai aggiunto " + str + " alle aree");

                }
                else if(!aggiunto  && distance < 3){
                    do {
                        check = console.readLine("Intendevi " + nome[1] + "?(y/n)");
                    } while (!check.equals("y") && !check.equals("n"));
                    if(check.equals("y")){
                        aggiunto = Aree.add(Integer.parseInt(nome[0]));
                        System.out.println("Hai aggiunto " + str + " alle aree");
                        break;
                    }
                }
                if(aggiunto)
                    break;
                }
            }
            if(!aggiunto){
                System.out.println("Area non trovata!");
            }
        }while(str.length() != 0);
    }

    /**  fornisce una rappresentazione testuale dell'oggetto  CentroMonitoraggio */
    public String toString(){
        String Centro = null;
        Centro = String.format("%d,%s,%s,", codice, nome, Indirizzo);
        for(int codice : Aree){
                Centro = Centro.concat(codice + ",");
        }
        return Centro;
    }
}
