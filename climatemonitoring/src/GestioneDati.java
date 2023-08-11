import java.io.Console;

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
        Console console = System.console();
        String password = null;
        boolean sbagliato = false;
        do{
        if(sbagliato)
            System.out.print("Formato password errato, riprova!\nRicorda di utilizzare almeno:\n\tuna lettera maiuscola\n\tuna lettera minuscola\n\tun carattere speciale\n\tun numero\n\tla lunghezza deve essere tra gli 8 e i 20 caratteri)");
        else
            System.out.print("Inserisci password: ");
        password = console.readLine(); //Si può utilizzare il console.readPassword(); torna però un array di char
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
}
