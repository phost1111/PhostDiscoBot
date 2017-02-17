package console;

import client.ClientManager;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.MessageSender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phost on 17.02.2017.
 */
public class ConsoleCommands {

    public static void readConsoleLineCommand() throws IOException, RateLimitException, DiscordException, MissingPermissionsException {
        ConsoleCommandManager.consoleCommandIn(ConsoleCommandManager.readInputLine());
    }

    public static void announceConsoleCommand(ArrayList<String> args) throws RateLimitException, DiscordException, MissingPermissionsException {
        if(args.size() > 1) {
            List<IChannel> channels = ClientManager.getClientInstance().getChannels(false);
            args.remove(0);
            String out = "";
            int o = args.size();
            while(o >= 1) {
                out += args.get(args.size() - o) + " ";
                o--;
            }
            for (int i = channels.size(); i >= 1; i--) {
                if (channels.get(i - 1).getID().equals(channels.get(i - 1).getGuild().getID())) {
                    MessageSender.sendMessage("" + out, channels.get(i - 1));
                }
            }
        }
    }

    public static void deleteMessageConsoleCommand(String messageID) throws RateLimitException, DiscordException, MissingPermissionsException {
        ClientManager.getClientInstance().getMessageByID(messageID).delete();
    }

    public static void setPlayingConsoleCommand(ArrayList<String> args) {
        args.remove(0);
        String out = "";
        int o = args.size();
        while(o >= 1) {
            out += args.get(args.size() - o) + " ";
            o--;
        }
        ClientManager.setPlaying(out);
    }

    public static void shutdownConsoleCommand() throws DiscordException {
        ClientManager.endClientInstance();
    }
}
