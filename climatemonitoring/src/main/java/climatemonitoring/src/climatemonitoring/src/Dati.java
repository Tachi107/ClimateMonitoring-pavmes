//Giacomo Paviano 750742
//Alessandro Messuti 750734

package climatemonitoring.src;
import java.util.List;


/** La classe Dati è una classe utilizzata per memorizzare e gestire i dati del programma
 *   Al suo interno sono presenti 4 liste di array di stringhe che servono per memorizzare gli operatori, le coordinate geografiche/zone di interesse, i parametri climatici e infine i centri di monitoraggio.
 */
public class Dati {
    
    /** lista di vettori di stringhe contenente gli operatori */
    public List<String[]> operatori = null;
    /** lista di vettori di stringhe contenente le coordinate */
    public List<String[]> coordinate = null;
    /** lista di vettori di stringhe contenente i centri  */
    public List<String[]> centri = null;
    /** lista di vettori di stringhe contenente i parametri climatici */
    public List<String[]> parametri = null;
    
    /** costruttore che assegna ai vari campi le informazioni presenti nei file .csv appositi mediante il metodo readCSV() della classe GestioneFile */
    public Dati() {
        try{
            operatori = GestioneFile.readCSV(GestioneFile.OperatoriPath);
            coordinate = GestioneFile.readCSV(GestioneFile.CoordinatePath);
            parametri = GestioneFile.readCSV(GestioneFile.ParamPath);
            centri = GestioneFile.readCSV(GestioneFile.CentriPath);
        }
        catch(Exception e){}
    }
}
