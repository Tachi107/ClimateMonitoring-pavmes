//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
public class AreaDiInteresse {
    String code; 
    String nome; 
    String Stato; 
    String codiceStato; 
    String latitudine; 
    String longitudine; 

    public AreaDiInteresse(String code, String nome, String Stato, String latitudine, String longitudine){
        this.code = code; 
        this.nome = nome;
        this.Stato = Stato;
        this.codiceStato = Stato.substring(0, 2).toUpperCase();
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public String toString(){
        return String.format("%s,%s,%s,%s,%s,\"%s,%s\"", code, nome, nome, codiceStato, Stato, latitudine, longitudine);
    }
}
