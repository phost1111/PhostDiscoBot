package utils;

import sx.blah.discord.handle.obj.IGuild;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Phost on 25.01.2017.
 */
public class FileManager {

    public static File timeZoneDBFile;

    public static void createFileObject() throws IOException {
        timeZoneDBFile = new File("timeZoneDB.txt");
        if(!timeZoneDBFile.exists())
            timeZoneDBFile.createNewFile();
    }

    public static void writeIntoDatabase(IGuild guild, String toWrite) throws IOException {
        if(timeZoneDBFile == null)
            createFileObject();
        if(!timeZoneDBFile.exists())
            timeZoneDBFile.createNewFile();
        Boolean alreadyExistsTemp = null;
        if(checkIfAlreadyExists(guild) != null){
            alreadyExistsTemp = true;
        }else{
            alreadyExistsTemp = false;
        }
        if(alreadyExistsTemp){
            replaceInDB(guild, toWrite);
        }else{
            addToDB(guild, toWrite);
        }
    }

    public static String checkIfAlreadyExists(IGuild guild) throws IOException {
        String temp = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(timeZoneDBFile));
        while((temp = bufferedReader.readLine()) != null){
            if(temp.startsWith(guild.getID()))
                return new StringBuilder(temp).delete(0, 19).toString();
        }
        return temp;
    }

    public static void replaceInDB(IGuild guild, String toWrite) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        String temp = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(timeZoneDBFile));
        while((temp = bufferedReader.readLine()) != null){
            if(temp.startsWith(guild.getID()))
                lines.add("" + guild.getID() + " " + toWrite);
            else
                lines.add(temp);
        }
        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(timeZoneDBFile));
        for(int i = lines.size(); i >= 1; i--){
            bufferedWriter.write(lines.get(i - 1));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void addToDB(IGuild guild, String toWrite) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        String temp = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(timeZoneDBFile));
        while((temp = bufferedReader.readLine()) != null){
                lines.add(temp);
        }
        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(timeZoneDBFile));
        for(int i = lines.size(); i >= 1; i--){
            bufferedWriter.write(lines.get(i - 1));
            bufferedWriter.newLine();
        }
        bufferedWriter.write("" + guild.getID() + " " + toWrite);
        bufferedWriter.close();
    }

}
