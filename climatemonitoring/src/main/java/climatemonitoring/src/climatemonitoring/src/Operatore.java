//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
public class Operatore {
    
    public String nome, cognome, psw, email;
    public String cf;
    public int userid, centromonitoraggio;

    public Operatore(String nome, String cognome, String cf, String email, String psw, int centromonitoraggio)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.email=email;
        this.psw=psw;
        this.cf=cf;
        this.centromonitoraggio = centromonitoraggio;
    }
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%d", nome,cognome,cf,email,psw,centromonitoraggio);
    }
}
