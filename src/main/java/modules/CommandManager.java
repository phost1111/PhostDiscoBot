package modules;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Phost on 30.01.2017.
 */
public class CommandManager {

    public static void commandIn(IChannel channel, String command) throws RateLimitException, DiscordException, MissingPermissionsException {
        ArrayList<String> args = new ArrayList<String>();
        ArrayList<Character> tempCharList = new ArrayList<Character>();
        String temp = null;
        int i = 0;
        Scanner scanner = new Scanner(command);
        while(scanner.hasNext()){
            if((temp = scanner.next()) != " "){
                tempCharList.add(temp.charAt(0));
            }else{
                args.add(tempCharList.toString());
                tempCharList = null;
            }
        }
        if(args.get(0).equals("botworking")){
            Commands.botWorkingCommand(channel);
        }

    }

}
