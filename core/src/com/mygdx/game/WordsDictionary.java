package com.mygdx.game;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class WordsDictionary {

    private static ArrayList<String> words = new ArrayList<>();

    public WordsDictionary()
    {
        try {
            loadDictionary();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDictionary () throws Exception
    {
        String filePath = new File("").getAbsolutePath();
        //filePath = filePath.substring(0,filePath.length()-4);
        filePath = filePath.concat("\\desktop\\build\\resources");
        filePath = filePath.concat("\\main\\data\\1000_parole_italiane_comuni.txt");
        FileReader fr = new FileReader(filePath);

        int i;
        int c = 0;
        String tmp = "";

        while ((i=fr.read()) != -1)
        {
            if((char) i != '\n')
                tmp = tmp + (char) i;
            else
            {
                words.add(c,tmp);
                tmp = "";
                c++;
            }
        }
    }

    public static String getSingleWord()
    {
        Random r = new Random();
        return words.get(r.nextInt(999));
    }
}
