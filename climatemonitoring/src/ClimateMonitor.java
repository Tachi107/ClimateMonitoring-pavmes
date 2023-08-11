import java.util.Scanner;

public class ClimateMonitor
{
    public static void main(String[] array){
        Menu();
    }
    
    public static void Menu() {
        ClimateController cc = new ClimateController();
        final Scanner scanner = new Scanner(System.in);
        int nextInt;
        do{
            System.out.println("1. Visualizza Clima\n2. Accedi\n3. Registrati\nCosa vuoi fare?");
            nextInt = scanner.nextInt();
            switch (nextInt) {
                case 1:
                    System.out.println("Visualizza Clima");
                    break;
                case 2:
                    System.out.println("Accedi");
                    break;
                case 3: 
                    System.out.println("Registrati");
                    cc.Registrati();
                    break;
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
            if((index =cc.Accedi(GestioneDati.eMail(), GestioneDati.Password())) != -1){
                System.out.println("Benvenuto " + cc.dati.operatori.get(index)[0]);
            }
            else{
                System.out.println("Email o password errata!\n");
                
        
                
                Scanner sc = new Scanner(System.in);
                int nextInt;
                do{
                    System.out.print("1. Accedi\n2.Registrati\n3. Torna al menù iniziale\nCosa vuoi fare?");
                    nextInt = sc.nextInt();
                    switch (nextInt) {
                        case 1:
                            System.out.println("Accedi");
                            MenuAccedi(cc);
                            break;
                        case 2:
                            System.out.println("Registrati");
                            cc.Registrati();
                            //Gestire accedi all'interno della classe CC
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
}