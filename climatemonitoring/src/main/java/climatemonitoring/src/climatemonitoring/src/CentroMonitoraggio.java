package climatemonitoring.src;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class CentroMonitoraggio {
    public int codice;
    public String nome;
    public List<Integer> Aree;
    public String Indirizzo;

    public CentroMonitoraggio(int codice, String nome, String Indirizzo){
        this.codice = codice;
        this.nome = nome;
        this.Indirizzo = Indirizzo;
        Aree = new ArrayList<Integer>();
    }
    public void AggiungiAree(Dati dati){
        List<String[]> aree = dati.coordinate;
        Console console = System.console();
        String str = null;
        String check = null;
        do{

            str = console.readLine("Inserisci il nome dell'area che vuoi aggiungere \nPremi Enter se hai finito: ");
            if(str.length() == 0)
                break;
            for(String[] nome : aree){
                boolean aggiunto = false;
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
        }while(str.length() != 0);
    }


    public String toString(){
        int count = 0;
        String Centro = null;
        Centro = String.format("%d,%s,%s,", codice, nome, Indirizzo);
        for(int codice : Aree){
            if(Aree.size() -1 == count)
                Centro = Centro.concat(codice + "");
            else
                Centro = Centro.concat(codice + ",");
        }
        return Centro;
    }
}
