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
                    MenuAccedi(cc);
                    break;
                case 3: 
                    System.out.println("Registrati");
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
            if((cc.Accedi(GestioneDati.eMail(), GestioneDati.Password())) != -1){
                System.out.println("Benvenuto " + cc.dati.operatori.get(index)[0]);
            }
            else
                System.out.println("Vai al menu registrazione");

    }
}