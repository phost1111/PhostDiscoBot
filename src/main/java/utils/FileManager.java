package utils;

import sx.blah.discord.handle.obj.IChannel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Phost on 23.01.2017.
 */
public class FileManager {

    public static File timeZoneDBFile;
    public static Formatter formatter;

    public static File getTimeZoneFBFileObject() {
        return timeZoneDBFile;
    }

    public static void writeIntoFile(IChannel channel, String toWrite) throws IOException {
        formatter = null;
        if(timeZoneDBFile == null)
            timeZoneDBFile = new File("timeZoneDB.txt");
        if(!timeZoneDBFile.exists()) {
            timeZoneDBFile.createNewFile();
            System.out.println("New File created!");
        }
        String fileContent = "";
        Scanner fileReader = new Scanner(timeZoneDBFile);
        while(fileReader.hasNext()){
            System.out.println("has next");
            fileContent += fileReader.next();
        }
        System.out.println("DateiInhalt: " + fileContent);
        formatter = new Formatter("timeZoneDB.txt");
        formatter.format(fileContent);
        formatter.format("%s\n", toWrite);
        formatter.close();
    }

}
