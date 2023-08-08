import java.io.IOException;
import java.util.List;

public class Operatore {
    
    public String nome, cognome, psw, centromonitoraggio, email;
    public String cf;
    public int userid;

    public Operatore(String nome, String cognome, String cf, String email, String psw, String centromonitoraggio)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.email=email;
        this.psw=psw;
        this.cf=cf;
        this.centromonitoraggio = centromonitoraggio;
    }
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s", nome,cognome,cf,email,psw,centromonitoraggio);
    }

    public boolean EsisteOperatore(Operatore o){

        try {
            List<String> operatore = null;
            for(String[] s: operatore){
                if(s[3].equals(email))
                return true;
            }
        } catch (IOException e) {}
        return false;
    }

    public Operatore CheckOperatore(String email, String psw){
         try {
            List<String[]> operatori = GestioneFile.readCSV(GestioneFile.OperatoriPath);
            for(String[] s: operatori){
                if(s[3].equals(email) && s[4].equals(psw))
                    return new Operatore(s[0], s[1], s[2], s[3], s[4], s[5]);
            }
        } catch (IOException e) {}
        return null;
    }
}
