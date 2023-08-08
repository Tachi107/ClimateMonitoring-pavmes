import java.util.Scanner;

public class GestioneDati {
    public static String Nome(){
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();
        scanner.close();
        return nome;
    }

    public static String Cognome(){
        Scanner scanner =  new Scanner(System.in);
        System.out.print("Inserisci cognome: ");
        String cognome = scanner.nextLine();
        scanner.close();
        return cognome;
    }
    
    public static String eMail(){
        Scanner scanner =  new Scanner(System.in);
        String email = null;
        boolean sbagliato = false;
       do{
        if(sbagliato)
            System.out.print("Formato e-mail errato, riprova: ");
        else
            System.out.print("Inserisci e-mail: ");
        email = scanner.nextLine();
        sbagliato = true;
       }while(!Regex.validateEmail(email));
        scanner.close();
        return email;
    }

    public static String Password(){
        Scanner scanner =  new Scanner(System.in);
        String password = null;
        boolean sbagliato = false;
        do{
        if(sbagliato)
            System.out.print("Formato password errato, riprova: ");
        else
            System.out.print("Inserisci password: ");
        password = scanner.nextLine();
        sbagliato = true;
       }while(!Regex.validatePSW(password));
        scanner.close();
        return password;
    }

    public static String CF(){
        Scanner scanner =  new Scanner(System.in);
        String cf = null;
        boolean sbagliato = false;
        do{
        if(sbagliato)
            System.out.print("Formato codice fiscale errato, riprova: ");
        else
            System.out.print("Inserisci codice fiscale: ");
        cf = scanner.nextLine();
        sbagliato = true;
       }while(!Regex.validateCF(cf));
        scanner.close();
        return cf;
    }
}
