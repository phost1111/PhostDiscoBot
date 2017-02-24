package utils;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Phost on 24.02.2017.
 */
public class FileManager2 {

    public static File getAndCreateFile(String fileName) throws IOException {
        File file = new File(fileName + ".txt");
        if(!file.exists())
            file.createNewFile();
        return file;
    }


    public static String searchInFile(File file, String ID) throws IOException {
        String temp = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while((temp = bufferedReader.readLine()) != null){
            if(temp.startsWith(ID))
                return new StringBuilder(temp).delete(0, ID.length() + 1).toString();
        }
        return temp;
    }

    public static String searchInFile(String fileString, String ID) throws IOException {
        File file = getAndCreateFile(fileString);
        String temp = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while((temp = bufferedReader.readLine()) != null){
            if(temp.startsWith(ID))
                return new StringBuilder(temp).delete(0, ID.length() + 1).toString();
        }
        return temp;
    }


    public static void replaceOrAddToFile(File file, String ID, String toWrite) throws IOException {
        if(file == null)
            file = getAndCreateFile(file.getCanonicalPath());
        if(!file.exists())
            file.createNewFile();
        ArrayList<String> lines = new ArrayList<String>();
        String temp;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while((temp = bufferedReader.readLine()) != null){
            if(!temp.startsWith(ID))
                lines.add(temp);
        }
        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for(int i = lines.size(); i >= 1; i--){
            bufferedWriter.write(lines.get(i - 1));
            bufferedWriter.newLine();
        }
        bufferedWriter.write(ID + " " + toWrite);
        bufferedWriter.close();
    }

    public static void replaceOrAddToFile(String fileString, String ID, String toWrite) throws IOException {
        File file = getAndCreateFile(fileString);
        if(file == null)
            file = getAndCreateFile(file.getCanonicalPath());
        if(!file.exists())
            file.createNewFile();
        ArrayList<String> lines = new ArrayList<String>();
        String temp;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while((temp = bufferedReader.readLine()) != null){
            if(!temp.startsWith(ID))
                lines.add(temp);
        }
        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for(int i = lines.size(); i >= 1; i--){
            bufferedWriter.write(lines.get(i - 1));
            bufferedWriter.newLine();
        }
        bufferedWriter.write(ID + " " + toWrite);
        bufferedWriter.close();
    }
}
