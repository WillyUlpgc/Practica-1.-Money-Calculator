
package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Currency;

public class ListOfCurrencies {
    
    public List<String> currenciesList;
    
    public List<String> getList(){
        return this.currenciesList;
    }
    
    public ListOfCurrencies(){
        try {
            File file = new File("currencies.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String inputLine;
            this.currenciesList = new ArrayList<String>();
            while ((inputLine = br.readLine()) != null) {
                String[] arr = inputLine.split(", ");
                this.currenciesList.add(arr[1]);
            }
            
            br.close();           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Currency.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Currency.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
