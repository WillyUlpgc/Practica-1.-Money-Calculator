package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Converter {
    
    private final String url;
    
    public Converter(String url){
        this.url = url;
    }

    public double getExchangeRate(){
        
       
        
        try{
            URL jsonPage = new URL(this.url);
            URLConnection conn = jsonPage.openConnection();
            BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            double exchangeValue = 0;
            int indexLine = 0;
            String inputLine;
            while ((inputLine = bf.readLine()) != null) {
                indexLine++;
                if(indexLine == 3){
                    String[] line = inputLine.split("\\s+");
                    exchangeValue = Double.parseDouble(line[2]);
                }
            }
            bf.close();
            return exchangeValue;
            
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
