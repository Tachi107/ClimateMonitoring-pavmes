import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GestioneDati {
    
    public static String Nome(){
        Console console = System.console();
        System.out.print("Inserisci nome: ");
        String nome = console.readLine();
        return nome;
    }

    public static String Cognome(){
        Console console = System.console();
        System.out.print("Inserisci cognome: ");
        String cognome = console.readLine();
        return cognome;
    }
    
    public static String eMail(){
        Console console = System.console();
        String email = null;
        boolean sbagliato = false;
       do{
        if(sbagliato)
            System.out.print("Formato e-mail errato, riprova: ");
        else
            System.out.print("Inserisci e-mail: ");
        email = console.readLine();
        sbagliato = true;
       }while(!Regex.validateEmail(email));
        return email;
    }

    public static String Password(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = null;
        boolean sbagliato = false;
        
        do{
        if(sbagliato)
            System.out.print("Formato password errato, riprova!\nRicorda di utilizzare almeno:\n\tuna lettera maiuscola\n\tuna lettera minuscola\n\tun carattere speciale\n\tun numero\n\tla lunghezza deve essere tra gli 8 e i 20 caratteri)\nRiprova: ");
        
        else 
            System.out.print("Inserisci password: ");
       
        ThreadDisappear td = new ThreadDisappear();
        Thread t = new Thread(td);
        try {
            t.start();
            password = br.readLine();
            td.maskEnd();
        } catch (IOException ioe) { ioe.printStackTrace(); }
        sbagliato = true;
       }while(!Regex.validatePSW(password));
        
       return password;
    }

    public static String CF(){
        Console console = System.console();
        String cf = null;
        boolean sbagliato = false;
        do{
        if(sbagliato)
            System.out.print("Formato codice fiscale errato, riprova: ");
        else
            System.out.print("Inserisci codice fiscale: ");
        cf = console.readLine();
        sbagliato = true;
       }while(!Regex.validateCF(cf));
        return cf;
    }

    public static int CentroMonitoraggio(){
        Dati dati = new Dati();
        Console console = System.console();
        List<String[]> CentriMonitoraggio = dati.centri;
        System.out.println("\n\n\n*****CENTRI DI MONITORAGGIO*****");

        for(String[] centro : CentriMonitoraggio){
            System.out.println(centro[0] + " - " + centro[1]);
        }

        String codice = console.readLine("Inserisci codice centro di monitoraggio: ");
        for(String[] centro : CentriMonitoraggio){
            if(codice == centro[0])
                return Integer.parseInt(codice);
        }
        System.out.println("Codice non presente, effettuare creazione del centro nel menù operatore");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        return -1;
    }

    public static String Indirizzo(){
        Console console = System.console();
        return console.readLine("Inserisci indirizzo: ");
    }
}
