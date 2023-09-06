//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;

/** La classe Operatore rappresenta un operatore di un sistema e contiene vari attributi correlati all'operatore */
public class Operatore {
    
    public String nome, cognome, psw, email;
    public String cf;
    public int userid, centromonitoraggio;


    /** costruttore dell'operatore che imposta i campi del operatore in base ai parametri forniti  */
    public Operatore(String nome, String cognome, String cf, String email, String psw, int centromonitoraggio)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.email=email;
        this.psw=psw;
        this.cf=cf;
        this.centromonitoraggio = centromonitoraggio;
    }

    /** Questo metodo restituisce una stringa formattata che contiene tutti gli attributi dell'operatore separati da virgole */
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%d", nome,cognome,cf,email,psw,centromonitoraggio);
    }
}
