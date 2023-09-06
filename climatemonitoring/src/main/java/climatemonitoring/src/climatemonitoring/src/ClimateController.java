//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.io.Console;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.shape.Point;
import java.time.format.DateTimeFormatter;

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
        List<String[]> centriMonitoraggio = null;
        List<String[]> operatori = null;
        try{
            centriMonitoraggio = GestioneFile.readCSV(GestioneFile.CentriPath);
            operatori = GestioneFile.readCSV(GestioneFile.OperatoriPath);
        }catch(Exception e){}
        
        boolean trovato = false;
        int row = 0;
        int index = 0;
        
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
                index++;
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
         List<String[]> operatori = null, centri = null, coordinate = null;
        try {
            operatori = GestioneFile.readCSV(GestioneFile.OperatoriPath);
            centri = GestioneFile.readCSV(GestioneFile.CentriPath);
            coordinate = GestioneFile.readCSV(GestioneFile.CoordinatePath);
        } catch (IOException e) { }
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
                        if(ar.length > 1){
                            if(ar[1].equals(nomeArea)){
                            System.out.println("Area già presente verrai reindirizzato al menù...");
                            try {
                                Thread.sleep(2500);
                            } catch (InterruptedException e) {}
                        return;
                        }
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
                            CentroMonitoraggio cm = new CentroMonitoraggio(Integer.parseInt(cen[0]), cen[1], cen[2] + cen[3] + cen[4]);
                            for(int i = 5; i < cen.length; i++){
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
        List<String[]> operatori = null, centri = null, coordinate = null;
        try {
            operatori = GestioneFile.readCSV(GestioneFile.OperatoriPath);
            centri = GestioneFile.readCSV(GestioneFile.CentriPath);
            coordinate = GestioneFile.readCSV(GestioneFile.CoordinatePath);
        } catch (IOException e) { }
        List<String> areeParam = new ArrayList<String>();
        Console console = System.console();
        String codiceCentro = null;
        String codiceArea = null;
        String[] centroMon = null;
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
                        if(aree[0].equals(codiceCentro))
                            centroMon = aree;
                    }
                        for(int i = 5; i < centroMon.length; i++){
                            for(String[] coord : coordinate){
                                if(centroMon[i].equals(coord[0])){
                                    areeParam.add(centroMon[i]);
                                    System.out.println(centroMon[i] + " - " + coord[1]);
                                }
                            }
                        }
                    do{
                        if(areeParam.size() == 0){
                            System.out.println("Aree non ancora inserite...verrai reindirizzato al menù");
                            try{
                                Thread.sleep(2500);
                            }catch(Exception e){}
                            return;
                        }
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

    public String cercaAreaGeografica(){
        Console console = System.console();
        List<String[]> coordinate = dati.coordinate;
        List<String> aree = new ArrayList<String>();
        boolean trovato = false;
        String città = null, nome = null;

        do{
            nome = console.readLine("inserisci nome città: ");
            for(String[] cord : coordinate){
                if(cord.length >1){
                    if(cord[1].contains(nome)){
                    System.out.println(cord[0] + " - " + cord[1]);
                    aree.add(cord[1]);
                    }
                }
            }
        }while(aree.size() == 0);

        if(aree.size() == 1)
            return aree.get(0);
        else{
            do{
                città = console.readLine("Inserisci il nome della città che vuoi selezionare: ");
                for(String a : aree){
                    if(a.equals(città)){
                        trovato = true;
                        break;
                    }
                }
            }while(!trovato);
            return città;
        }
    }
    public String cercaAreaGeografica(String latitude, String longitude){
        List<String[]> coordinate = dati.coordinate;
        List<Point> spatialIndex;
        SpatialContext context = SpatialContext.GEO;
        spatialIndex = new ArrayList<>();
        String città = null;

        SpatialContext thisContext = SpatialContext.GEO;
        Point queryPoint = thisContext.getShapeFactory().pointXY(Double.parseDouble(latitude), Double.parseDouble(longitude));
        Point nearestPoint = null;
        double minDistance = Double.MAX_VALUE;

        for(String[] coord : coordinate){
            if(coord.length > 1){
                double lat = Double.parseDouble(coord[5].split("\"")[1]);
                double lon = Double.parseDouble(coord[6].split("\"")[0]);
                spatialIndex.add(context.getShapeFactory().pointXY(lat, lon));
            }
        } 

        for (Point shape : spatialIndex) {
            double distance = context.getDistCalc().distance(queryPoint, (Point) shape);
            if (distance < minDistance) {

                minDistance = distance;
                nearestPoint = shape;
            }
        }

        for(String[] coord : coordinate){
            if(coord.length > 1){
                if(nearestPoint.getX() == Double.parseDouble(coord[5].split("\"")[1]) && nearestPoint.getY() == Double.parseDouble(coord[6].split("\"")[0])){
                    città = coord[1];
            }
            }
        }
        return città;
    }

    public void VisualizzaAreaGeografica(String città){
        List<String[]> parametri = dati.parametri;
        List<String[]> coordinate = dati.coordinate;
        String codCittà = null;
        boolean trovato = false;
        int numRilevazioni = 0;
        Console console = System.console();
        LocalDate Datas = LocalDate.MIN;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<ParametriClimatici> parametriClim = new ArrayList<>();


        for(String[] coord : coordinate){
            if(coord.length > 1){
                if(coord[1].equals(città)){
                    clearScreen();
                    if(numRilevazioni <1){
                        System.out.println(String.format("Codice: %s\nNome: %s\nStato: %s\nLatitudine: %s\nLongitudine: %s", coord[0], coord[1], coord[4], coord[5].split("\"")[1], coord[6].split("\"")[0]));
                        codCittà = coord[0];
                    }
                    numRilevazioni++;
                }
            }
            
        }
        for(String[] param : parametri){
            if(param[1].equals(codCittà)){
                for(int i = 0; i < numRilevazioni; i++){
                    LocalDate data = LocalDate.parse(param[2], formatter);
                    if(data.isAfter(Datas)){
                        Datas = data;
                    }
                }
                ParametriClimatici pc = new ParametriClimatici();
                Map<String, ArrayList<String>> dizyParam = new HashMap<>();
                for(int i = 0; i < pc.nomiParametri.length; i++){
                    dizyParam.put(pc.nomiParametri[i], new ArrayList<String>());
                    for(int j = 3; j < param.length; j++){
                        dizyParam.get(pc.nomiParametri[i]).add(param[j].split("[")[1]);
                        dizyParam.get(pc.nomiParametri[i]).add(param[j++].split("]")[0]);
                    }   
                }
                pc.Parametri = dizyParam;
                parametriClim.add(pc);

                trovato = true;
            }
        }
        if(!trovato){
            System.out.println("\nDati non disponibili...Verrai reindrizzato al menù(Premi un qualsiasi tasto e poi invio)");
            console.readLine();
        }
        else{
            int[] avgValue = new int[7];

            for(ParametriClimatici pc : parametriClim){
                for(int i = 0; i < avgValue.length; i++){
                    avgValue[i] += Integer.parseInt(pc.Parametri.get(pc.nomiParametri[i]));
                }
            }
            System.out.println(String.format("Numero Rilevazioni: %d\nData ultima rilevazione: %s\n", numRilevazioni, Datas.toString()));
            console.readLine();
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        } 
}
