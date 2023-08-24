package climatemonitoring.src;
import java.util.ArrayList;
import java.util.List;

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
    }


    public String toString(){
        int count = 0;
        String Centro = null;
        Centro = String.format("%d,%s,%s,", codice, nome, Indirizzo);
        for(int codice : Aree){
            if(Aree.size() -1 == count)
                Centro.concat(codice + "");
            else
                Centro.concat(codice + ",");
        }
        return Centro;
    }
}
