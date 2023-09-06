//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.List;


/** La classe GestioneFile è la responsabile della gestione dei file CSV utilizzati. */
public class GestioneFile
{

    /** percorso CentriMonitoraggio.csv */
    public static final String CentriPath = "data/CentriMonitoraggio.csv";
    /** percorso CoordinateMonitoragggio.csv */
    public static final String CoordinatePath = "data/CoordinateMonitoraggio.csv";
    /** percorso OperatoriRegistrati.csv */
    public static final String OperatoriPath = "data/OperatoriRegistrati.csv";
    /** percorso ParametriClimatici.csv */
    public static final String ParamPath = "data/ParametriClimatici.csv";


    /** Questo metodo legge un file CSV dal percorso specificato e restituisce una lista di array di stringhe, dove ogni array rappresenta una riga del file CSV. */
    public static List<String[]> readCSV(String pathname) throws IOException {
        String absolutePath ="";
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            pathname = "climatemonitoring/" + pathname;
            absolutePath = new File(pathname).getAbsolutePath();        
        }
        else
            absolutePath = new File(pathname).getAbsolutePath();
        ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
            try {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    list.add(line.split(","));
                }
                bufferedReader.close();
            }
            catch (IOException e) {}
        }
        catch (FileNotFoundException ex) {}
        return list;
    }

    /** Questo metodo modifica una cella specifica in un file CSV */
    public static void editCSV(String el, int row, String path){
        try {
            List<String[]> elements = readCSV(path);
            elements.get(row)[5] = el;
            writeCSV(elements, path);
        } catch (IOException e) {}
    }

    /** simile al metodo editCSV, ma è specificamente progettato per modificare i dati di un centro di monitoraggio in un file CSV. */
    public static void editCentroMonitoraggio(String el, int row, String path){
        try{
            List<String[]> elements = readCSV(path);
            elements.set(row, el.split(","));
            writeCSV(elements, path);
        } catch(IOException e){}
        
    }

    /** Questo metodo scrive dati in un file CSV specificato dal percorso. 
     * Può accettare oggetti di vari tipi come argomento, tra cui Operatore, CentroMonitoraggio, AreaDiInteresse, ParametriClimatici, e liste di stringhe. 
     * In base al tipo di oggetto fornito, scrive le informazioni appropriate nel file. */
    public static void writeCSV(Object o, String path){
        String absolutePath = null;
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            path = "climatemonitoring/" + path;
            absolutePath = new File(path).getAbsolutePath();        
        }
        else
            absolutePath = new File(path).getAbsolutePath();
        try {
            if(o instanceof Operatore){
                BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePath, true));
                bw.write(o.toString());
                bw.newLine();
                bw.close();
            }
            else if(o instanceof CentroMonitoraggio){
                BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePath, true));
                bw.write(o.toString());
                bw.newLine();
                bw.close();
            }
            else if(o instanceof AreaDiInteresse){
                BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePath, true));
                bw.write(o.toString());
                bw.newLine();
                bw.close();
            }

            else if(o instanceof ParametriClimatici){
                BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePath, true));
                bw.write(o.toString());
                bw.newLine();
                bw.close();
            }
            else if(o instanceof List){
                BufferedWriter bwr = new BufferedWriter(new FileWriter(absolutePath, false));
                List<String[]> listObj = (List<String[]>) o;
                for(String[] s: listObj){
                    int i = 0;
                    String q = "";
                    for(String g : s){
                        q = q.concat((s.length - 1 != i ? g + "," : g)); 
                        i++;
                    }
                    bwr.write(q);
                    bwr.newLine();
                }
                bwr.close();
            }
        } catch (IOException e) {}
    }
}
