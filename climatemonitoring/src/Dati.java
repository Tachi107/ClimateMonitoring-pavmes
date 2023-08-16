
import java.util.List;

public class Dati {
    
    public List<String[]> operatori = null;
    public List<String[]> coordinate = null;
    public List<String[]> centri = null;
    public List<String[]> parametri = null;
    
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
