import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.List;

public class GestioneFile
{
    public static final String CentriPath = "data/CentriMonitoraggio.csv";
    public static final String CoordinatePath = "data/CoordinateMonitoraggio.csv";
    public static final String OperatoriPath = "data/OperatoriRegistrati.csv";
    public static final String ParamPath = "data/ParametriClimatici.csv";
    
    public static List<String[]> readCSV(final String pathname) throws IOException {
        final String absolutePath = new File(pathname).getAbsolutePath();
        final ArrayList<String[]> list = new ArrayList<String[]>();
        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath));
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

    public static void editCSV(String el, int row, String path){
        try {
            List<String[]> elements = readCSV(path);
            elements.get(row)[6] = el;
            writeCSV(elements, path);
        } catch (IOException e) {}
    }
    public static void writeCSV(Object o, String path){
        String absolutePath = new File(path).getAbsolutePath();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(absolutePath, true));
            if(o instanceof Operatore){
                bw.write(o.toString());
                bw.newLine();
            }
            else if(o instanceof CentroMonitoraggio){
                bw.write(o.toString());
                bw.newLine();
            }
            else if(o instanceof List){
                List<String[]> listObj = (List<String[]>) o;
                for(String[] s: listObj){
                    int i = 1;
                    String q = null;
                    for(String g: s){
                        q = (s.length == i ? g + "," : g); 
                        i++;
                    }
                    bw.write(q);
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {}
    }
}
