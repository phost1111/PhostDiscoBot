package commands;

import client.ClientManager;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageList;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.FileManager;
import utils.MessageSender;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Created by Phost on 22.01.2017.
 */
public class Commands {

    public static void botWorkingCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("Bot working!", channel);
        System.out.println("" + channel.getID() + " " + channel.getName());
    }
    public static void timeCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException, IOException {
        if(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()) != null){
            if (ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()))).getMinute() >= 10)
                MessageSender.sendMessage("" + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()))).getHour() + ":" + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()))).getMinute(), channel);
            else
                MessageSender.sendMessage("" + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()))).getHour() + ":0" + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()))).getMinute(), channel);
        }else{
            MessageSender.sendMessage("```Phost\nSet your timezone first! To do so type '♥settimezone <yourTimezone>'\n```", channel);
        }
    }
    public static void dateCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException, IOException {
        if(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()) != null) {
            MessageSender.sendMessage("" + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()))).getDayOfMonth() + "." + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()))).getMonthValue() + "." + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()))).getYear(), channel);
        }else{
            MessageSender.sendMessage("```Phost\nSet your timezone first! To do so type '♥settimezone <yourTimezone>'\n```", channel);
        }
    }
    public static void weekDayCommand(IChannel channel) throws IOException, RateLimitException, DiscordException, MissingPermissionsException {
        if(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()) != null){
            MessageSender.sendMessage("It's " + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", channel.getGuild().getID()))).getDayOfWeek(), channel);
        }else{
            MessageSender.sendMessage("```Phost\nSet your timezone first! To do so type '♥settimezone <yourTimezone>'\n```", channel);
        }
    }
    public static void inviteLinkCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("https://discordapp.com/oauth2/authorize?&client_id=272381828109828097&scope=bot&permissions=536345663", channel);
    }
    public static void inviteLinkTestingCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("https://discordapp.com/oauth2/authorize?&client_id=222058371996581890&scope=bot&permissions=536345663", channel);
    }
    public static void koalaCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("http://www.koalastothemax.com/?aHR0cDovL2ltZ3VyLmNvbS9PSWowR2kxLmpwZw==", channel);
    }
    public static void helpCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("```HELP\n♥help / ♥hilfe\n♥prune / ♥clear\n♥botworking\n♥time / ♥zeit\n♥date / ♥datum\n♥weekday / ♥wochentag\n♥settimezone <timeZone>\n♥say <text> / ♥sag <text>\n♥dev / ♥developer / ♥entwickler\n♥invlink / ♥invitelink\n♥invlinktesting / ♥invitelinktesting\n♥koala\n♥git\n```", channel);
    }
    public static void testCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        ZoneId zone = ZoneId.of("UTC+1");
        MessageSender.sendMessage("" + ZonedDateTime.now(zone).getHour() + ":" + ZonedDateTime.now(zone).getMinute(), channel);
    }
    public static void setTimezoneCommand(IGuild guild, String zone) throws IOException {
        FileManager.replaceOrAddToFile("timeZoneDB", guild.getID(), zone);
    }
    public static void gitCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("https://github.com/phost1111/PhostDiscoBot", channel);
    }
    public static void sayCommand(IChannel channel, ArrayList<String> args) throws RateLimitException, DiscordException, MissingPermissionsException {
        args.remove(0);
        String out = "";
        int i = args.size();
        while(i >= 1){
            out += args.get(args.size() - i) + " ";
            i--;
        }
        MessageSender.sendMessage(out, channel);
    }
    public static void paIstTollCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("hellyeah", channel);
    }
    public static void kekCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("se sind lecker!", channel);
    }
    public static void discordCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("Wir haben zu viele Server und Bots. Warum machen wir das? Make Discord Great Again!", channel);
    }
    public static void devCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("Send a PM to this guy: " + ClientManager.getClientInstance().getUserByID("139354514091147264").mention(), channel);
    }
    public static void pruneCommand(IMessage message, String Samount) throws RateLimitException, DiscordException, MissingPermissionsException, IOException {
        if(message.getGuild().getRolesByName("PhostBotAdmin").size() <= 0){
            MessageSender.sendMessage("There is no PhostBotAdmin role on this server. You need this role to use admin commands", message.getChannel());
            return;
        }
        if(message.getAuthor().getRolesForGuild(message.getGuild()).contains(message.getGuild().getRolesByName("PhostBotAdmin").get(0)) || message.getAuthor().getID().equals(ClientManager.getBotAdminID())) {
            int amount = 0;
            try {
                amount = Integer.parseInt(Samount);
            } catch (NumberFormatException e) {
                MessageSender.sendMessage("Please use a real number for this command", message.getChannel());
                return;
            }
            if (amount < 2 || amount > 100) {
                MessageSender.sendMessage("You can only delete 2-100 messages at a time", message.getChannel());
                return;
            }
            MessageList allMessages = message.getChannel().getMessages();
            ArrayList<IMessage> toDelete = new ArrayList<IMessage>();
            if (amount > allMessages.size())
                MessageSender.sendMessage("There are not that many messages in this channel", message.getChannel());
            for (int i = amount; i >= 1; i--) {
                if (!(allMessages.get(0).getTimestamp().plusWeeks(2).isAfter(LocalDateTime.now()))) {
                    allMessages.remove(0);
                } else {
                    toDelete.add(allMessages.get(0));
                    allMessages.remove(0);
                }
            }
            toDelete.add(message);
            if (toDelete != null && toDelete.size() > 1) {
                allMessages.bulkDelete(toDelete);
            } else {
                MessageSender.sendMessage("There are not enough messages eligable to delete", message.getChannel());
            }
            if (!message.isDeleted())
                message.delete();
        }else{
            MessageSender.sendMessage("You need the PhostBotAdmin role to do that!", message.getChannel());
        }
    }



}