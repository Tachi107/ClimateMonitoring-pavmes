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
        System.out.println("mail/password errata");
        return -1;
    }

    public void Registrati(){
        List<String[]> operatori = dati.operatori;
        boolean trovato = false;
        Operatore o = new Operatore(GestioneDati.Nome(), GestioneDati.Cognome(), GestioneDati.CF(), GestioneDati.eMail(), GestioneDati.Password(), null);
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
        else
            System.out.println("Utente già registrato\n");
    }
}

