package moji_razredi;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    private String ime;

    public Helper(String ime) {
        this.ime = ime;
    }

    public static void pisanje(String json, String imeDatoteke){
        try {
            File file = new File(imeDatoteke);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static boolean checkDigit(String preveri) {
        int intArray[] = new int[preveri.length()];
        int vsota = 0;
        for (int i = 0; i < preveri.length(); i++) {
            intArray[i] = Character.digit(preveri.charAt(i), 10);
            if(i % 2 == 1){
                intArray[i] = 3 * intArray[i];
            }
            if(i != preveri.length() -1) {
                vsota = vsota + intArray[i];
            }
        }
        int zaokrozeno = vsota;
        int zadnastevilka = intArray[preveri.length()-1];
        if(vsota % 10 != 0){
            int a = vsota % 10;
            int ab =  10 - a;
            zaokrozeno = vsota +ab;

        }

        if(zadnastevilka == zaokrozeno - vsota) {
            return true;
        }
        else{
            return false;
        }
    }


}
