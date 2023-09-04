package climatemonitoring.src;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class ClimateController {
    public Dati dati = null;

    public ClimateController(){
        dati = new Dati();
    }

    public int Accedi(String email, String pwd){
            List<String[]> operatori = dati.operatori;
            for(String[] s: operatori){
                 if(s[3].equals(email) && s[4].equals(pwd)){
                    System.out.println("Hai effettuato l'accesso");
                    return operatori.indexOf(s);
                }
            }
        return -1;
    }

    public boolean CercaOperatore(String codice){
        List<String[]> operatori = dati.operatori;
        boolean trovato = false;
        for(String[] s: operatori){
            if(s[3].equals(codice))
                trovato = true;
        }
        if(!trovato)
            return false;
        else
            return true;
    }

    public void registrazione(){
        List<String[]> operatori = dati.operatori;
        Operatore o = new Operatore(GestioneDati.Nome(), GestioneDati.Cognome(), GestioneDati.CF(), GestioneDati.eMail(), GestioneDati.Password(), GestioneDati.CentroMonitoraggio());
        if(operatori.size()<2){
            operatori.add(o.toString().split(","));
            GestioneFile.writeCSV(o, GestioneFile.OperatoriPath);
            System.out.println("Utente Registrato\n");
        }
        else{
            if(!CercaOperatore(o.toString().split(",")[3])){
                operatori.add(o.toString().split(","));
                GestioneFile.writeCSV(o, GestioneFile.OperatoriPath);
                System.out.println("Utente Registrato\n");
            }
            else{
                System.out.println("Utente già registrato\n");
                try {
                    System.out.println("Attendi 5 secondi e verrai reindirizzato al menù...");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}
        }
        }
    }

    public void registraCentroAree(String codiceUtente){
        List<String[]> centriMonitoraggio = dati.centri;
        List<String[]> operatori = dati.operatori;
        boolean trovato = false;
        int row = 0;
        
        CentroMonitoraggio cm = new CentroMonitoraggio(centriMonitoraggio.size()+1, GestioneDati.Nome(), new Indirizzo(GestioneDati.Via(), GestioneDati.numeroCivico(), GestioneDati.Comune(), GestioneDati.Provincia(), GestioneDati.CAP()).toString());
        cm.AggiungiAree(dati);
        if(centriMonitoraggio.size()<2){
            for(String[] s: operatori){
                if(s[3].equals(codiceUtente)){
                    if(s[5].equals("-1")){
                    GestioneFile.editCSV(Integer.toString(cm.codice), row, GestioneFile.OperatoriPath);
                    centriMonitoraggio.add(cm.toString().split(","));
                    GestioneFile.writeCSV(cm, GestioneFile.CentriPath);
                    System.out.println("Centro Registrato\n");
                    return;
                    }
                    else{
                        try {
                            System.out.println("L'operatore ha già un centro associato...\n\nVerrai reindirizzato alla pagina iniziale...");
                            Thread.sleep(3000);
                            return;
                        } catch (InterruptedException e) {}
                    }
                } 
                row++; 
            }

        }
        else{
        for(String[] s: centriMonitoraggio){
            if(s[1].equals(cm.toString().split(",")[1])){
                trovato = true;
            }
        }
        if(!trovato){
            for(String[] s: operatori){
                if(s[3].equals(codiceUtente)){
                    if(s[5].equals("-1")){
                        GestioneFile.editCSV(Integer.toString(cm.codice), row, GestioneFile.OperatoriPath);
                        centriMonitoraggio.add(cm.toString().split(","));
                        GestioneFile.writeCSV(cm, GestioneFile.CentriPath);
                        System.out.println("Centro Registrato\n");
                        return;
                    }
                    else{
                        try {
                            System.out.println("L'operatore ha già un centro associato...\nVerrai reindirizzato alla pagina iniziale...\n\n");
                            Thread.sleep(3000);
                            return;
                        } catch (InterruptedException e) {}
                    }
                } 
                row++; 
            }
        }
        else{
            System.out.println("Centro già registrato\n");
            try {
                System.out.println("Attendi 5 secondi e verrai reindirizzato al menù...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
        }
        }
    }

    public void AggiungiAreaDiInteresse(String codiceUtente){
        List<String[]> operatori = dati.operatori;
        List<String[]> centri = dati.centri;
        List<String[]> coordinate = dati.coordinate;
        String codiceCentro = null;
        String codice = null;
        boolean trovato = false;
        String lat = null, lon = null;
        Console console = System.console();
        int row = 0;

        for(String[] op: operatori){
            if(codiceUtente.equals(op[3])){
                codiceCentro  = op[5];
                if(Integer.parseInt(codiceCentro) == -1){
                    System.out.println("L'operatore non ha nessun centro registrato.\nRegistra un centro di monitoraggio prima");
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {}
                    return;
                }
                else{
                    String nomeArea = console.readLine("Inserisci nome dell'area che vuoi registrare: ");
                    do{
                        trovato = false;
                        codice = console.readLine("Inserisci un codice che non sia già presente: ");
                        for(String[] cod : coordinate){
                            if(cod[0].equals(codice)){
                                trovato = true;
                                break;
                            }
                        }
                    }while(trovato);
                    for(String[] ar : coordinate){
                        if(ar[1].equals(nomeArea)){
                            System.out.println("Area già presente verrai reindirizzato al menù...");
                            try {
                                Thread.sleep(2500);
                            } catch (InterruptedException e) {}
                        return;
                        }
                    }
                    do{
                        clearScreen();
                        lat = console.readLine("Inserisci latitudine: "); 
                        lon = console.readLine("Inserisci longitudine: ");
                    }while(!Regex.validateLatitude(lat) && !Regex.validateLongitude(lon));
                    AreaDiInteresse AdI = new AreaDiInteresse(codice, nomeArea, GestioneDati.Stato(), lat, lon);

                    GestioneFile.writeCSV(AdI, GestioneFile.CoordinatePath);
                    for(String[]cen : centri){
                        if(cen[0].equals(codiceCentro)){
                            CentroMonitoraggio cm = new CentroMonitoraggio(Integer.parseInt(cen[0]), cen[1], cen[2] + cen[3] + cen[4] + cen[5]);
                            for(int i = 6; i < cen.length; i++){
                                cm.Aree.add(Integer.parseInt(cen[i]));
                            }
                            cm.Aree.add(Integer.parseInt(AdI.code));
                            GestioneFile.editCentroMonitoraggio(cm.toString(), row, GestioneFile.CentriPath);
                        }
                        row++;
                    }
                }
            }
        }

    }

    public void RegistraParametriClimatici(String codiceUtente){
        List<String[]> operatori = dati.operatori;
        List<String[]> centri = dati.centri;
        List<String[]> coordinate = dati.coordinate;
        List<String> areeParam = new ArrayList<String>();
        Console console = System.console();
        String codiceCentro = null;
        String codiceArea = null;
        for(String[] op : operatori){
            if(codiceUtente.equals(op[3])){
                codiceCentro = op[5];
                if(Integer.parseInt(codiceCentro) == -1){
                    System.out.println("L'operatore non ha nessun centro registrato.\nRegistra un centro di monitoraggio prima");
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {}
                    return;
                }
                else{
                    for(String[] aree : centri){
                        for(int i = 6; i < aree.length; i++){
                            for(String[] coord : coordinate){
                                if(aree[i].equals(coord[0])){
                                    areeParam.add(aree[i]);
                                    System.out.println(aree[i] + " - " + coord[1]);
                                }
                            }
                        }
                    }
                    do{
                        codiceArea = console.readLine("Di che area di interesse vuoi inserire i parametri?(Inserisci il codice) ");
                        if(!areeParam.contains(codiceArea)){
                            System.out.println("Codice inesistente, riprova");
                        }
                    }while(!areeParam.contains(codiceArea));
                    ParametriClimatici pm = new ParametriClimatici(codiceCentro, codiceArea);
                    GestioneFile.writeCSV(pm, GestioneFile.ParamPath);
                }
            }
        }

    }


    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        } 
}
