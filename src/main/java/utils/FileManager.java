package utils;

import sx.blah.discord.handle.obj.IChannel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Phost on 23.01.2017.
 */
public class FileManager {

    public static File timeZoneDBFile;
    public static FileWriter fileWriter;

    public static File getTimeZoneFBFileObject() {
        return timeZoneDBFile;
    }

    public static void writeIntoFile(IChannel channel, String toWrite) throws IOException {
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
        fileWriter = new FileWriter(timeZoneDBFile);
        fileWriter.write(fileContent + "\n" + channel.getID() + toWrite);
        fileWriter.close();
    }

}
