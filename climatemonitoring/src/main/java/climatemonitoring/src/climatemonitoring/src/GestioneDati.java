//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.io.Console;
import java.util.List;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;


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

    public static String numeroCivico(){
        Console console = System.console();
        return console.readLine("Inserisci numero civico: ");
    }

    public static String Stato(){
        Console console = System.console();
        return console.readLine("Inserisci Stato: ");
    }

    public static String Latitudine(){
        Console console = System.console();
        String lat = null;
        do{
            lat = console.readLine("Inserisci Latitudine: ");
        }while(!Regex.validateLatitude(lat));
        return lat;
    }

    public static String Longitudine(){
        Console console = System.console();
        String lon = null;
        do{
            lon = console.readLine("Inserisci Longitudine: ");
        }while(!Regex.validateLongitude(lon));
        return lon;
    }
}
