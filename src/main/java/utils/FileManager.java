package utils;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;

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

    public static void writeIntoDatabase(IGuild guild, String toWrite) throws IOException {
        if (timeZoneDBFile == null)
            timeZoneDBFile = new File("timeZoneDB.txt");
        if (!timeZoneDBFile.exists()) {
            timeZoneDBFile.createNewFile();
            System.out.println("New File created!");
        }
        String alreadyExistsInDBCheckTemp = null;
        alreadyExistsInDBCheckTemp = searchInDatabase(guild);
        if (alreadyExistsInDBCheckTemp != null) {
            replaceInDatabase(guild, toWrite);
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(timeZoneDBFile));
        String temp = null;
        ArrayList<String> lines = new ArrayList<String>();
        while ((temp = bufferedReader.readLine()) != null) {
            lines.add(0, temp);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(timeZoneDBFile));
        for (int i = lines.size(); i >= 1; i--) {
            bufferedWriter.write(lines.get(i - 1));
            bufferedWriter.newLine();
        }
        bufferedWriter.write("" + guild.getID() + " " + toWrite);
        bufferedReader.close();
        bufferedWriter.close();
    }

    public static String searchInDatabase(IGuild guild) throws IOException {
        if (timeZoneDBFile == null || !timeZoneDBFile.exists())
            return null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(timeZoneDBFile));
        String temp = null;
        ArrayList<String> lines = new ArrayList<String>();
        while ((temp = bufferedReader.readLine()) != null) {
            lines.add(0, temp);
        }
        for (int i = lines.size(); i >= 1; i--) {
            if (lines.get(i - 1).startsWith(guild.getID()))
                return new StringBuilder(lines.get(i - 1)).delete(0, 19).toString();
        }
        return null;

    }

    public static void replaceInDatabase(IGuild guild, String toWrite) throws IOException {
        if (timeZoneDBFile == null)
            timeZoneDBFile = new File("timeZoneDB.txt");
        if (!timeZoneDBFile.exists()) {
            timeZoneDBFile.createNewFile();
            System.out.println("New File created!");

        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(timeZoneDBFile));
        String temp = null;
        ArrayList<String> lines = new ArrayList<String>();
        while ((temp = bufferedReader.readLine()) != null) {
            lines.add(0, temp);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(timeZoneDBFile));
        removeLoop(lines, guild);
        for (int i = lines.size(); i >= 1; i--) {
            bufferedWriter.write(lines.get(i - 1));
            bufferedWriter.newLine();
        }
        bufferedWriter.write("" + guild.getID() + " " + toWrite);
        bufferedReader.close();
        bufferedReader.close();
    }
    public static void removeLoop(ArrayList<String> lines, IGuild guild){
        boolean removeLoopTemp = false;
        for (int i = lines.size(); i >= 1; i--) {
            if(lines.get(i - 1).startsWith(guild.getID())){
                lines.remove(i - 1);
                removeLoopTemp = true;
            }
            if(removeLoopTemp){
                removeLoop(lines, guild);
            }
        }
    }
}

