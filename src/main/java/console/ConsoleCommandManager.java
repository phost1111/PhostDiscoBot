package console;

import client.ClientManager;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.MessageSender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Phost on 17.02.2017.
 */
public class ConsoleCommandManager {

    public static String readInputLine() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }


    public static void consoleCommandIn(String consoleCommand) throws IOException, RateLimitException, DiscordException, MissingPermissionsException {
        ArrayList<String> args = new ArrayList<String>();
        Scanner scanner = new Scanner(consoleCommand);
        while(scanner.hasNext()){
            args.add(scanner.next());
        }

        if(args.get(0).equals("rl")){
            ConsoleCommands.readConsoleLineCommand();
            return;
        }

        if(args.get(0).equals("announce")){
            ConsoleCommands.announceConsoleCommand(args);
            return;
        }

        if(args.get(0).equals("delmsg")){
            ConsoleCommands.deleteMessageConsoleCommand(args.get(1));
            return;
        }

        if(args.get(0).equals("setplaying")){
            ConsoleCommands.setPlayingConsoleCommand(args);
            return;
        }

        if(args.get(0).equals("shutdown")){
            ConsoleCommands.shutdownConsoleCommand();
            return;
        }

        if(args.get(0).equals("write")){
            ConsoleCommands.writeConsoleCommand(args);
            return;
        }

        if(args.get(0).equals("help")){
            ConsoleCommands.helpConsoleCommand(ClientManager.getClientInstance().getOrCreatePMChannel(ClientManager.getClientInstance().getUserByID(ClientManager.getBotAdminID())));
            return;
        }

        if(args.get(0).equals("delchannel")){
            ConsoleCommands.deleteChannelConsoleCommand(args.get(1));
            return;
        }

        if(args.get(0).equals("createchannel")){
            ConsoleCommands.createChannelConsoleCommand(args);
            return;
        }

        if(args.get(0).equals("delvchannel")){
            ConsoleCommands.deleteVoiceChannelConsoleCommand(args.get(1));
            return;
        }

        if(args.get(0).equals("createvchannel")){
            ConsoleCommands.createVoiceChannelConsoleCommand(args);
            return;
        }

        if(args.get(0).equals("createinv")){
            ConsoleCommands.createInviteConsoleCommand(args.get(1));
        }
    }
}
