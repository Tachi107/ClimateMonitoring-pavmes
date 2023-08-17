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
            elements.get(row)[5] = el;
            writeCSV(elements, path);
        } catch (IOException e) {}
    }
    public static void writeCSV(Object o, String path){
        String absolutePath = new File(path).getAbsolutePath();
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
                    System.out.println(q);
                    bwr.write(q);
                    bwr.newLine();
                }
                bwr.close();
            }
        } catch (IOException e) {}
    }
}
