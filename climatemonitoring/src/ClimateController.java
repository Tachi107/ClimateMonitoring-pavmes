
import java.util.List;

public class ClimateController {
    public Dati dati = null;

    public ClimateController(){
        dati = new Dati();
    }

    public int Accedi(String email, String pwd){
            List<String[]> operatori = dati.operatori;
            for(String[] s: operatori){
                if(s[3].equals(email) && s[4].equals(pwd)){
                    System.out.println("Hai effettuato l'accesso");
                    return operatori.indexOf(s);
                }
            }
        return -1;
    }

    public void Registrati(){
        List<String[]> operatori = dati.operatori;
        boolean trovato = false;
        Operatore o = new Operatore(GestioneDati.Nome(), GestioneDati.Cognome(), GestioneDati.CF(), GestioneDati.eMail(), GestioneDati.Password(), GestioneDati.CentroMonitoraggio());
        if(operatori.size()<2){
            operatori.add(o.toString().split(","));
            GestioneFile.writeCSV(o, GestioneFile.OperatoriPath);
            System.out.println("Utente Registrato\n");
        }
        else{
        for(String[] s: operatori){
            if(s[3].equals(o.toString().split(",")[3])){
                trovato = true;
            }
        }
        if(!trovato){
            operatori.add(o.toString().split(","));
            GestioneFile.writeCSV(o, GestioneFile.OperatoriPath);
            System.out.println("Utente Registrato\n");
        }
        else{
            System.out.println("Utente già registrato\n");
            try {
                System.out.println("Attendi 5 secondi e verrai reindirizzato al menù...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
        }
        }
    }
}

