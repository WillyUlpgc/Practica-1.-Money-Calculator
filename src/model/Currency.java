/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Currency {

    public final String name;
    public String code;
    public String sign;


    public Currency(String name) {
        this.name = name;
        this.code = "";
        this.sign = "";

    }
    
    public String getName(){
        return this.name;
    }
    
    public String getCode(){
        return this.code;
    }
    
    public String getSign(){
        return this.sign;
    }
    
    public boolean currencyInList(){
        try {
            File file = new File("currencies.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                String[] splittedLine = inputLine.split(", ");
                if (splittedLine[1].equalsIgnoreCase(this.name)) {
                    this.code = splittedLine[0];
                    this.sign = splittedLine[2];
                    return true;
                }
            }
            br.close();           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Currency.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Currency.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
