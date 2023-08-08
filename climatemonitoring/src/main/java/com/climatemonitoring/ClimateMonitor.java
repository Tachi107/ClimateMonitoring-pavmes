import java.util.Scanner;

public class ClimateMonitor {
    
    public static void main(String[] args){
        Menu();
    }


    public static void Menu(){
        int value  = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Visualizza Clima\n2. Accedi\n3. Registrati\nCosa vuoi fare?");
            value = sc.nextInt();
            switch(value){
                case 1:
                    System.out.println("Utente normale");
                    break;
                case 2: 
                    System.out.println("Accedi");
                    break;
                case 3: 
                    System.out.println("Registrati");
                    break;
                default:
                    System.out.println("Riprova\n\n\n");
            }
        }while(value != 1 && value != 2 && value != 3);
        sc.close();
    }
}
