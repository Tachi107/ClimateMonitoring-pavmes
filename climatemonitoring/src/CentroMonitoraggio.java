import java.util.List;

public class CentroMonitoraggio {
    public int codice;
    public String nome;
    public List<Integer> Aree;
    public String Indirizzo;

    public CentroMonitoraggio(String nome, String Indirizzo, List<Integer> Aree){
        this.nome = nome;
        this.Indirizzo = Indirizzo;
        this.Aree = Aree;
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
