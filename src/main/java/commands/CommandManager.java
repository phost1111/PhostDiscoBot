package commands;

import client.ClientManager;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.MessageSender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Phost on 30.01.2017.
 */
public class CommandManager {

    public static void commandIn(String command, IMessage message) throws RateLimitException, DiscordException, MissingPermissionsException, IOException {
        ArrayList<String> args = new ArrayList<String>();
        ArrayList<String> tempCharList = new ArrayList<String>();
        String temp = null;
        int i = 0;
        boolean guildHasAdminRole;
        Scanner scanner = new Scanner(command);
        while(scanner.hasNext()){
            args.add(scanner.next());
        }
        if(message.getGuild().getRolesByName("PhostBotAdmin").size() <= 0){
            MessageSender.sendMessage("There is no PhostBotAdmin role on this server. You need this role to use admin commands", message.getChannel());
            guildHasAdminRole = false;
        }else{
            guildHasAdminRole = true;
        }
        if(args.get(0).equals("botworking")){
            Commands.botWorkingCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("settimezone")){
            if(args.size() > 1)
                Commands.setTimezoneCommand(message.getGuild(), args.get(1));
            else
                MessageSender.sendMessage("Use the command like this: ```♥settimezone <yourTimezone>```", message.getChannel());
            return;
        }
        if(args.get(0).equals("time") || args.get(0).equals("zeit")){
            Commands.timeCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("date") || args.get(0).equals("datum")){
            Commands.dateCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("weekday") || args.get(0).equals("wochentag")){
            Commands.weekDayCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("invlink") || args.get(0).equals("invitelink")){
            Commands.inviteLinkCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("invlinktesting") || args.get(0).equals("invitelinktesting")){
            Commands.inviteLinkTestingCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("koala")){
            Commands.koalaCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("help") || args.get(0).equals("hilfe")){
            Commands.helpCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("testcommand") && ClientManager.getDeveloperMode()){
            Commands.testCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("git")){
            Commands.gitCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("say") || args.get(0).equals("sag")){
            Commands.sayCommand(message.getChannel(), args);
            return;
        }
        if(args.get(0).equals("paisttoll")){
            Commands.paIstTollCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("kek")){
            Commands.kekCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("discord")){
            Commands.discordCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("dev") || args.get(0).equals("calldev") || args.get(0).equals("developer") || args.get(0).equals("entwickler")){
            Commands.devCommand(message.getChannel());
            return;
        }
        if(args.get(0).equals("prune") || args.get(0).equals("clear")){
            if(!guildHasAdminRole)
                return;
            if(args.size() > 1)
                Commands.pruneCommand(message, args.get(1));
            else
                MessageSender.sendMessage("Please provide how many messages you want to delete", message.getChannel());
            return;
        }
        if(args.get(0).equals("ttt")){
            Commands.tttCommand(args, message);
            return;
        }
        if(args.get(0).equals("tttread")){
            Commands.tttReadCommand(args.get(1), message);
            return;
        }
        if(args.get(0).equals("giverole")){
            if(!guildHasAdminRole)
                return;
            Commands.giveRoleCommand(args, message);
            return;
        }

    }

}
