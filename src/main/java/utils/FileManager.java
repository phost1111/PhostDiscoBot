package utils;

import sx.blah.discord.handle.obj.IChannel;

import java.io.*;
import java.util.ArrayList;
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
        BufferedReader bufferedReader = new BufferedReader(new FileReader(timeZoneDBFile));
        String temp = null;
        ArrayList<String> lines = new ArrayList<String>();
        while((temp = bufferedReader.readLine()) != null){
            lines.add(temp);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(timeZoneDBFile));
        for(int i = lines.size(); i >= 1; i--){
            bufferedWriter.write(lines.get(i - 1));
            bufferedWriter.newLine();
        }
        bufferedWriter.write("" + channel.getID() + toWrite);
        bufferedReader.close();
        bufferedWriter.close();
    }

}
