/*Giacomo Paviano 750742
Alessandro Messuti 750734
*/

package climatemonitoring.src;

/**
 * Classe che contiene le informazioni di un’area di interesse.
 */
public class AreaDiInteresse {

    /** codice dell'area */
    String code; 
    /** nome dell'area */
    String nome; 
    /** stato dell'area */
    String Stato; 
    /** codice dello stato dell'area */
    String codiceStato; 
    /** latutudine dell'area */
    String latitudine; 
    /** longitudine dell'area */
    String longitudine; 

    /** costruttore dell'area di interesse che imposta i campi dell'area in base ai parametri forniti
     * l'unico parametro che non viene passato è il codice dello stato poichè viene ricavato da quest'ultimo
     * 
     * @param code codice dell'area
     * @param nome nome dell'area 
     * @param sato nome dello stato dell'area
     * @param latitudine latitudine dell'area 
     * @param longitudine longitudine dell'area
    */
    public AreaDiInteresse(String code, String nome, String Stato, String latitudine, String longitudine){
        this.code = code; 
        this.nome = nome;
        this.Stato = Stato;
        this.codiceStato = Stato.substring(0, 2).toUpperCase();
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }


    /** restituisce una stringa formattata che rappresenta 
    l'oggetto "AreaDiInteresse". La stringa contiene i valori di tutti gli attributi separati da virgole 
    e con alcune informazioni aggiuntive */
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,\"%s,%s\"", code, nome, nome, codiceStato, Stato, latitudine, longitudine);
    }
}
