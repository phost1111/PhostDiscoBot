package utils;

import java.io.File;
import java.io.IOException;
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

    public static void writeIntoFile(File file, String ID, ArrayList<String> toWrite) throws IOException {
        if(file == null)
            file = getAndCreateFile(file.getCanonicalPath());
        if(!file.exists())
            file.createNewFile();
        if(searchInFile != null){
            replaceOrAddToFile(file, ID, toWrite);
        }
    }

    private static void replaceOrAddToFile(File file, String id, ArrayList<String> toWrite) {
        ArrayList<String> lines = new ArrayList<String>();
    }
}
