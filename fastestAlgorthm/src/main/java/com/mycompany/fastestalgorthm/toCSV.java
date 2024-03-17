/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fastestalgorthm;
import java.io.*;
import com.opencsv.CSVWriter;
/**
 *
 * @author dylancicone
 */
public class toCSV {
    public toCSV() {
        
    }
    
    public void writeData(String filePath, int iterations, String[] data1, String[] data2, String[] data3){
        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            
            try (CSVWriter writer = new CSVWriter(outputfile)) {
                String[] trials = new String[iterations+1];
                trials[0] = "Trials";
                for(int i = 1; i < trials.length; i++){
                    trials[i] = "" + i;
                }
                writer.writeNext(trials);
                writer.writeNext(data1);
                writer.writeNext(data2);
                writer.writeNext(data3);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
