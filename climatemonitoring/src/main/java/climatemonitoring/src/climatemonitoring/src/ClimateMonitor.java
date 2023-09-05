//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.io.Console;

public class ClimateMonitor
{
    public static void main(String[] array){
        Menu();
    }
    
    public static void Menu() {
        ClimateController cc = new ClimateController();
        Console console = System.console();
        clearScreen();
        String nextString;
        int nextInt;
        do{
            do{
                clearScreen();
                System.out.println("*********CLIMATE MONITOR*********");
                System.out.print("1. Visualizza Clima\n2. Accedi\n3. Registrati\n4. Chiudi programma\nScegli una delle opzioni: ");
                nextString = console.readLine();
            }while(nextString == null || nextString.isEmpty() || !Regex.isNumeric(nextString));
            nextInt = Integer.parseInt(nextString);
            switch (nextInt) {
                case 1:
                    System.out.println("Visualizza Clima");
                    MenuGuest(cc);
                    break;
                case 2:
                    MenuAccedi(cc);
                    break;
                case 3: 
                    clearScreen();
                    System.out.println("*****REGISTRATI*****");
                    cc.registrazione();
                    MenuAccedi(cc);
                    break;
                case 4:
                    System.out.println("Chiusura programma in corso...");
                    try {
                        Thread.sleep(2000);
                        System.exit(0);
                    } catch (InterruptedException e) {}
                default:
                    System.out.println("Riprova\n\n\n");
                    break;
                }
            }
        while (nextInt != 1 && nextInt != 2 && nextInt != 3);
    }

    public static void MenuGuest(ClimateController cc){
        Console console = System.console();
        clearScreen();
        String nextString;
        int nextInt;
        String città = null;
        do{
            do{
                clearScreen();
                System.out.println("*********GUEST MENU*********");
                System.out.print("1. Ricerca per nome\n2. Ricerca per coordinate\n3. Torna al menù principale\nScegli una delle opzioni: ");
                nextString = console.readLine();
            }while(nextString == null || nextString.isEmpty() || !Regex.isNumeric(nextString));
            nextInt = Integer.parseInt(nextString);
            switch (nextInt) {
                case 1:
                    System.out.println("Ricerca per nome");
                    città = cc.cercaAreaGeografica();
                    cc.VisualizzaAreaGeografica(città);
                    break;
                case 2:
                    clearScreen();
                    System.out.println("Ricerca per coordinate");
                    città = cc.cercaAreaGeografica(GestioneDati.Latitudine(), GestioneDati.Latitudine());
                    cc.VisualizzaAreaGeografica(città);
                    break;
                case 3: 
                    clearScreen();
                    System.out.println("Torna al menù");
                    Menu();
                    break;
                default:
                    System.out.println("Riprova\n\n\n");
                    break;
                }
            }
        while (true);
    }

    public static void MenuAccedi(ClimateController cc){
        int index = 0;

        clearScreen();
        System.out.println("*****ACCESSO*****");
            if((index =cc.Accedi(GestioneDati.eMail(), GestioneDati.Password())) != -1){
                System.out.println("Benvenuto " + cc.dati.operatori.get(index)[0]);
                menuUtente(cc, cc.dati.operatori.get(index)[3]);
            }
            else{
                System.out.println("Email o password errata!\n");

                Console console = System.console();
                int nextInt;
                String nextString;
                do{
                    do{
                        clearScreen();
                        System.out.print("1. Accedi\n2. Registrati\n3. Torna al menù iniziale\nScegli un opzione: ");
                        nextString = console.readLine();
                    }while(nextString == null || nextString.isEmpty() || !Regex.isNumeric(nextString));
                
                    nextInt = Integer.parseInt(nextString);
                    switch (nextInt) {
                        case 1:
                            clearScreen();
                            System.out.println("*****Accedi*****");
                            MenuAccedi(cc);
                            break;
                        case 2:
                            clearScreen();
                            System.out.println("*****Registrati*****");
                            cc.registrazione();
                            
                            MenuAccedi(cc);
                            break;
                        case 3: 
                            System.out.println("Torna al menù iniziale");
                            Menu();
                            break;
                        default:
                            System.out.println("Riprova\n\n\n");
                            break;
                    }
                }while (nextInt != 1 && nextInt != 2 && nextInt != 3);
            }
    }

    public static void menuUtente(ClimateController cc, String codiceUtente){
        Console console = System.console();
        int index = 0;
        String nextString;
        do 
        {
            do{
                clearScreen();
                System.out.print("1. Crea centro monitoraggio\n2. Registra Area di interesse\n3. Inserire parametri per area di interesse\n4. Esci\nScegli un opzione: ");
                nextString = console.readLine();
            }while(nextString == null || nextString.isEmpty() || !Regex.isNumeric(nextString));
            
            index = Integer.parseInt(nextString);
            switch(index){
                case 1: 
                    clearScreen();
                    System.out.println("*****Crea centro monitoraggio*****");
                    cc.registraCentroAree(codiceUtente);
                    menuUtente(cc, codiceUtente);
                    break;
                case 2: 
                    clearScreen();
                    System.out.println("*****Registra Area di interesse*****");
                    cc.AggiungiAreaDiInteresse(codiceUtente);
                    break;
                case 3: 
                    clearScreen();
                    System.out.println("*****Inserire parametri per area di interesse*****");
                    cc.RegistraParametriClimatici(codiceUtente);
                    break;
                case 4: 
                    System.out.println("*****Esci*****");
                    Menu();
                    break;
                default:
                    clearScreen();
                    System.out.println("Riprova\n\n\n");
                    break;
            }
        }while(true);
    }

    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    }  
}