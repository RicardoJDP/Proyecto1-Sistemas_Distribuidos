package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Log {
    //Clase para realizar el log 
    private BufferedWriter buffered;
    private String ruta;
    
    //Constructor para el log
    public Log(String ruta) throws IOException {
        this.ruta = ruta;
        this.open(true);
    }

    //Constructor para el log con condicion para tener en log en blanco cuando se use
    public Log(String ruta, boolean reset) throws IOException {
        this.ruta = ruta;
        this.open(!reset);
    }

    //metodo para abrir el archivo log
    private void open(boolean append) throws IOException {
        this.buffered = new BufferedWriter(new FileWriter(this.ruta, append));
    }

    //metodo para escribir en el archivo log
    public void addLine(String line) throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        String formatoFecha = sdf.format(new Date());
        this.open(true);
        this.buffered.write("[" + formatoFecha + "] " + line + "\n");
        this.close();
    }

    //metodo para saber lo que esta escrito en el archivo log
    public String[] getLines() throws FileNotFoundException, IOException {

        ArrayList<String> linesFile = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(this.ruta));

        String line;
        while ((line = br.readLine()) != null) {
            linesFile.add(line);
        }
        
        br.close();

        String[] lines = new String[linesFile.size()];
        
        for (int i = 0; i < linesFile.size(); i++) {
            lines[i] = linesFile.get(i);
        }
        
        return lines;
    }
    
    //metodo para poner en blanco el archivo log
    public void resetLog() throws IOException{
        this.open(false);
        this.close();
    }
    
    //metodo para cerrar el archivo log
    private void close() throws IOException{
        this.buffered.close();
    }
    

}
