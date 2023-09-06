//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;

/** La classe Indirizzo rappresenta un oggetto che contiene informazioni sull'indirizzo, come la via, il numero civico, il comune, la provincia e il CAP. */
public class Indirizzo {
    public String via, comune, provincia, numeroCivico;
    public int cap;


/** costruttore dell'indirizzo che imposta i campi del indirizzo in base ai parametri forniti 
     * 
     * @param via via
     * @param numeroCivico numero civico
     * @param comune comune
     * @param provincia provincia
     * @param cap cap 
     * 
    */
    public Indirizzo(String via, String numeroCivico, String comune, String provincia, int cap){
        this.via = via; 
        this.numeroCivico = numeroCivico;
        this.comune = comune;
        this.provincia = provincia;
        this.cap = cap;
    }

    /** restituisce una rappresentazione formattata dell'indirizzo come una stringa, includendo via, numero civico, comune, provincia e CAP. */
    public String toString(){
        return String.format("%s %s,%s,%s,%d", via, numeroCivico, comune, provincia, cap);
    }
}
