package moji_razredi;

import com.google.gson.Gson;
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


}
