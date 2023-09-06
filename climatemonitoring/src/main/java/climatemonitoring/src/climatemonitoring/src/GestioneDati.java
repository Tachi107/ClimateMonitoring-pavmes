//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.io.Console;
import java.util.List;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;


//* La classe GestioneDati contiene una serie di metodi statici che gestiscono l'input da parte dell'utente per ottenere vari dati */
public class GestioneDati {
    
    /** Legge e restituisce il nome inserito dall'utente.  */
    public static String Nome(){
        Console console = System.console();
        System.out.print("Inserisci nome: ");
        String nome = console.readLine();
        return nome;
    }

    /**  Legge e restituisce il cognome inserito dall'utente.*/
    public static String Cognome(){
        Console console = System.console();
        System.out.print("Inserisci cognome: ");
        String cognome = console.readLine();
        return cognome;
    }
    
    /** Legge e restituisce l'indirizzo email inserito dall'utente, assicurandosi che sia nel formato corretto. */
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

    /** Legge e restituisce la password inserita dall'utente, assicurandosi che rispetti determinati requisiti di formato */
    public static String Password(){
        boolean sbagliato = false;
        String passwd = null;
        try {
            StringBuilder password = new StringBuilder();
        do {
            try (Terminal terminal = TerminalBuilder.builder().system(true).build()) {
            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();
            if(sbagliato)
                passwd = lineReader.readLine("Formato password errato, riprova!\nRicorda di utilizzare almeno:\n\tuna lettera maiuscola\n\tuna lettera minuscola\n\tun carattere speciale\n\tun numero\n\tla lunghezza deve essere tra gli 8 e i 20 caratteri)\nRiprova: ", '*');
            else{
                passwd = lineReader.readLine("Inserisci password: ", '*');
            }

            System.out.println("\nHai inserito la password: " + password);

            sbagliato = true;
            terminal.close();
        }
        }while(!Regex.validatePSW(passwd));
        } catch (Exception e) {}
        return passwd;
       }

       /** Legge e restituisce il codice fiscale inserito dall'utente, assicurandosi che sia nel formato corretto. */
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

    /** Mostra all'utente una lista di centri di monitoraggio e richiede l'inserimento del codice di un centro. Restituisce il codice del centro selezionato o -1 se il codice inserito non è valido. */
    public static int CentroMonitoraggio(){
        Dati dati = new Dati();
        Console console = System.console();
        List<String[]> CentriMonitoraggio = dati.centri;
        System.out.println("\n\n\n*****CENTRI DI MONITORAGGIO*****");

        for(String[] centro : CentriMonitoraggio){
            System.out.println(centro[0] + " - " + centro[1]);
        }

        String codice = console.readLine("Inserisci codice centro di monitoraggio: ");
        if(codice.length() == 0 || codice.equals(null)){
            System.out.println("Codice non presente, effettuare creazione del centro nel menù operatore");
            return -1;
        }
        for(String[] centro : CentriMonitoraggio){
            if(codice.equals(centro[0]))
                return Integer.parseInt(codice);
        }
        System.out.println("Codice non presente, effettuare creazione del centro nel menù operatore");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
        return -1;
    }

    /** Legge e restituisce il CAP (Codice di Avviamento Postale) inserito dall'utente, assicurandosi che sia nel formato corretto. */
    public static int CAP(){
        Console console = System.console();
        String cap = null;
        boolean sbagliato = false;
        do{
        if(sbagliato)
            System.out.print("Formato cap errata, riprova: ");
        else
            System.out.print("Inserisci cap: ");
        cap = console.readLine();
        sbagliato = true;
       }while(!Regex.validateCAP(cap));
        return Integer.parseInt(cap);
    }

    /** Legge e restituisce il nome della via inserito dall'utente, assicurandosi che sia nel formato corretto */
    public static String Via(){
        Console console = System.console();
        String via = null;
        boolean sbagliato = false;
        do{
        if(sbagliato)
            System.out.print("Formato via errato, riprova: ");
        else
            System.out.print("Inserisci nome della via: ");
        via = console.readLine();
        sbagliato = true;
       }while(!Regex.validateString(via));
        return via;
    }

    /** Legge e restituisce il nome del comune inserito dall'utente, assicurandosi che sia nel formato corretto. */
    public static String Comune(){
        Console console = System.console();
        String comune = null;
        boolean sbagliato = false;
        do{
        if(sbagliato)
            System.out.print("Formato comune errato, riprova: ");
        else
            System.out.print("Inserisci nome del comune: ");
        comune = console.readLine();
        sbagliato = true;
       }while(!Regex.validateString(comune));
        return comune;
    }

    /** Legge e restituisce il nome della provincia inserito dall'utente, assicurandosi che sia nel formato corretto */
     public static String Provincia(){
        Console console = System.console();
        String provincia = null;
        boolean sbagliato = false;
        do{
        if(sbagliato)
            System.out.print("Formato provincia errato, riprova: ");
        else
            System.out.print("Inserisci nome della provincia: ");
        provincia = console.readLine();
        sbagliato = true;
       }while(!Regex.validateString(provincia));
        return provincia;
    }

    /** Legge e restituisce il numero civico inserito dall'utente. */
    public static String numeroCivico(){
        Console console = System.console();
        return console.readLine("Inserisci numero civico: ");
    }

    /** Legge e restituisce lo stato inserito dall'utente. */
    public static String Stato(){
        Console console = System.console();
        return console.readLine("Inserisci Stato: ");
    }

    /** Legge e restituisce la latitudine inserita dall'utente, assicurandosi che sia nel formato corretto */
    public static String Latitudine(){
        Console console = System.console();
        String lat = null;
        do{
            lat = console.readLine("Inserisci Latitudine: ");
        }while(!Regex.validateLatitude(lat));
        return lat;
    }

    /** Legge e restituisce la longitudine inserita dall'utente, assicurandosi che sia nel formato corretto */
    public static String Longitudine(){
        Console console = System.console();
        String lon = null;
        do{
            lon = console.readLine("Inserisci Longitudine: ");
        }while(!Regex.validateLongitude(lon));
        return lon;
    }
}
