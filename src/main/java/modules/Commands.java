package modules;

import client.ClientManager;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.FileManager;
import utils.MessageSender;

import java.io.IOException;
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
        if(!FileManager.timeZoneDBFile.exists())
            FileManager.createFileObject();
        if(FileManager.checkIfAlreadyExists(channel.getGuild()) != null) {
            if (ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(channel.getGuild()))).getMinute() >= 10)
                MessageSender.sendMessage("" + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(channel.getGuild()))).getHour() + ":" + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(channel.getGuild()))).getMinute(), channel);
            else
                MessageSender.sendMessage("" + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(channel.getGuild()))).getHour() + ":0" + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(channel.getGuild()))).getMinute(), channel);
        }else{
            MessageSender.sendMessage("```Phost\nSet your timezone first! To do so type '!settimezone <yourTimezone>'\n```", channel);
        }
    }
    public static void dateCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException, IOException {
        if(!FileManager.timeZoneDBFile.exists())
            FileManager.createFileObject();
        if(FileManager.checkIfAlreadyExists(channel.getGuild()) != null) {
            MessageSender.sendMessage("" + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(channel.getGuild()))).getDayOfMonth() + "." + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(channel.getGuild()))).getMonthValue() + "." + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(channel.getGuild()))).getYear(), channel);
        }else{
            MessageSender.sendMessage("```Phost\nSet your timezone first! To do so type '!settimezone <yourTimezone>'\n```", channel);
        }
    }
    public static void weekDayCommand(IChannel channel) throws IOException, RateLimitException, DiscordException, MissingPermissionsException {
        if(!FileManager.timeZoneDBFile.exists())
            FileManager.createFileObject();
        if(FileManager.checkIfAlreadyExists(channel.getGuild()) != null){
            MessageSender.sendMessage("It's " + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(channel.getGuild()))).getDayOfWeek(), channel);
        }else{
            MessageSender.sendMessage("```Phost\nSet your timezone first! To do so type '!settimezone <yourTimezone>'\n```", channel);
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
        MessageSender.sendMessage("```HELP\n♥help / ♥hilfe\n♥botworking\n♥time / ♥zeit\n♥date / ♥datum\n♥weekday / ♥wochentag\n♥settimezone <timeZone>\n♥say <text> / ♥sag <text>\n♥dev / ♥developer / ♥entwickler\n♥invlink / ♥invitelink\n♥invlinktesting / ♥invitelinktesting\n♥koala\n♥git\n```", channel);
    }
    public static void testCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        ZoneId zone = ZoneId.of("UTC+1");
        MessageSender.sendMessage("" + ZonedDateTime.now(zone).getHour() + ":" + ZonedDateTime.now(zone).getMinute(), channel);
    }
    public static void setTimezoneCommand(IGuild guild, String zone) throws IOException {
        FileManager.writeIntoDatabase(guild, zone);
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
        MessageSender.sendMessage("WIr haben zu viele Server nd Bots. Warum machen wir das? Make Discord Great Again!", channel);
    }
    public static void devCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("Send a PM to this guy: " + ClientManager.getClientInstance().getUserByID("139354514091147264").mention(), channel);
    }



}
