package climatemonitoring.src;
import java.util.Scanner;

public class ClimateMonitor
{
    public static void main(String[] array){
        Menu();
    }
    
    public static void Menu() {
        ClimateController cc = new ClimateController();
        final Scanner scanner = new Scanner(System.in);
        clearScreen();
        int nextInt;
        do{
            System.out.println("*********CLIMATE MONITOR*********");
            System.out.print("1. Visualizza Clima\n2. Accedi\n3. Registrati\n4. Chiudi programma\nScegli una delle opzioni: ");
            nextInt = scanner.nextInt();
            switch (nextInt) {
                case 1:
                    System.out.println("Visualizza Clima");
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
        scanner.close();
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

                Scanner sc = new Scanner(System.in);
                int nextInt;
                do{
                    System.out.print("1. Accedi\n2. Registrati\n3. Torna al menù iniziale\nScegli un opzione: ");
                    nextInt = sc.nextInt();
                    switch (nextInt) {
                        case 1:
                            System.out.println("Accedi");
                            MenuAccedi(cc);
                            break;
                        case 2:
                            System.out.println("Registrati");
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
                sc.close();
            }
    }

    public static void menuUtente(ClimateController cc, String codiceUtente){
        Scanner sc = new Scanner(System.in);
        int index = 0;
        do 
        {
            System.out.print("1. Crea centro monitoraggio\n2. Aggiungi aree di interesse\n3. Inserire parametri per area di interesse\n4. Esci\nScegli un opzione: ");
            index = sc.nextInt();
            switch(index){
                case 1: 
                    clearScreen();
                    System.out.println("*****Crea centro monitoraggio*****");
                    cc.registraCentroAree(codiceUtente);
                    menuUtente(cc, codiceUtente);
                    break;
                case 2: 
                    clearScreen();
                    System.out.println("*****Aggiungi aree di interesse*****");
                    break;
                case 3: 
                    clearScreen();
                    System.out.println("*****Inserire parametri per area di interesse*****");
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

        }while(index != 1 && index != 2 && index != 3);

        sc.close();
    }

    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
    }  
}