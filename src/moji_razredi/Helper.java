package moji_razredi;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.util.stream.Stream;


public class Helper {
    private String ime;

    public Helper(String ime) {
        this.ime = ime;
    }

    public static void pisanje(String json, String imeDatoteke) {
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

    public static String branje(String imeDatoteke) throws FileNotFoundException{
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(imeDatoteke), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }

    public static boolean checkDigit(String preveri) {
        int intArray[] = new int[preveri.length()];
        int vsota = 0;



        for (int i = 0; i < preveri.length(); i++) {
            intArray[i] = Character.digit(preveri.charAt(i), preveri.length());
            if (i % 2 == 0 && preveri.length() %2 ==0) {
                intArray[i] = 3 * intArray[i];
            }

            if (i % 2 == 1 && preveri.length() %2 ==1) {
                intArray[i] = 3 * intArray[i];
            }

            if (i != preveri.length() -1) {
                vsota = vsota + intArray[i];
            }
        }
        int zaokrozeno = vsota;
        int zadnastevilka = intArray[preveri.length() - 1];
        if (vsota % 10 != 0) {
            int a = vsota % 10;
            int ab = 10 - a;
            zaokrozeno = vsota + ab;

        }

        if (zadnastevilka == zaokrozeno - vsota) {
            return true;
        } else {
            return false;
        }
    }


}
