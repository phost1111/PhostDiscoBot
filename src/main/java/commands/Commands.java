package commands;

import client.ClientManager;
import sx.blah.discord.handle.obj.*;
import sx.blah.discord.util.*;
import utils.FileManager;
import utils.MessageSender;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

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
        MessageSender.sendMessage("```HELP\n♥help / ♥hilfe\n♥prune / ♥clear\n♥giverole <RoleName> <@Users> / gvrle\n♥removerole <RoleName> <@Users> / takerole / tkrle / rmrle\n♥botworking\n♥time / ♥zeit\n♥date / ♥datum\n♥weekday / ♥wochentag\n♥settimezone <timeZone>\n♥say <text> / ♥sag <text>\n♥dev / ♥developer / ♥entwickler\n♥invlink / ♥invitelink\n♥invlinktesting / ♥invitelinktesting\n♥koala\n♥git\n```", channel);
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
            MessageHistory allMessages = message.getChannel().getMessageHistory();
            MessageHistory toDelete = new MessageHistory();
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
                message.getChannel().bulkDelete(toDelete);
            } else {
                MessageSender.sendMessage("There are not enough messages eligable to delete", message.getChannel());
            }
            if (!message.isDeleted())
                message.delete();
        }else{
            MessageSender.sendMessage("You need the PhostBotAdmin role to do that!", message.getChannel());
        }
    }


    public static void tttCommand(ArrayList<String> args, IMessage message) throws IOException {
        if(!(message.getAuthor().getID().equals(("139354514091147264")) || message.getAuthor().getID().equals("193344274279038995") || message.getAuthor().getID().equals("139741926147489792") || message.getAuthor().getID().equals("142739474147835904") || message.getAuthor().getID().equals("139387827291947008") || message.getAuthor().getID().equals("139384920920293376")))   //PHILIPP, GREGOR, LIONEL, LUCA, JULIUS, PA
            return;
        if(!(message.getGuild().getID().equals("139354710875439104") || message.getGuild().getID().equals("150699679137529858") || message.getGuild().getID().equals("208000784279797761") || message.getGuild().getID().equals("273512583057899522")))
            return;
        if(args.size() < 3)
            return;
        String temp = "";
        String date = args.get(1);
        args.remove(0);
        args.remove(0);
        String text = "";
        int i = args.size();
        while(i >= 1){
            text += args.get(args.size() - i) + " ";
            i--;
        }
        FileManager.replaceOrAddToFile(date, message.getAuthor().getName() + ":", text);
    }

    public static void tttReadCommand(String ID, IMessage message) throws IOException {
        if(!(message.getAuthor().getID().equals(("139354514091147264")) || message.getAuthor().getID().equals("193344274279038995") || message.getAuthor().getID().equals("139741926147489792") || message.getAuthor().getID().equals("142739474147835904") || message.getAuthor().getID().equals("139387827291947008") || message.getAuthor().getID().equals("139384920920293376")))   //PHILIPP, GREGOR, LIONEL, LUCA, JULIUS, PA
            return;
        if(!(message.getGuild().getID().equals("139354710875439104") || message.getGuild().getID().equals("150699679137529858") || message.getGuild().getID().equals("208000784279797761") || message.getGuild().getID().equals("273512583057899522")))
            return;
        ArrayList<String> lines = FileManager.getFileLinesAsArrayList(ID);
        String output = "";
        for(int i = lines.size(); i > 0; i--){
            output += lines.get(i - 1) + "\n";
        }
        MessageSender.sendMessage(output, message.getChannel());
    }

    public static void giveRoleCommand(ArrayList<String> args, IMessage message) {
        if(!(ClientManager.getClientInstance().getOurUser().getPermissionsForGuild(message.getGuild()).contains(Permissions.MANAGE_ROLES))){
            MessageSender.sendMessage("I need the permission to manage roles for this command to work.", message.getChannel());
            return;
        }
        if(args.size() < 3) {
            MessageSender.sendMessage("Use this command like this: ♥giverole <role> <@user>", message.getChannel());
            return;
        }
        if(!(message.getAuthor().getRolesForGuild(message.getGuild()).contains(message.getGuild().getRolesByName("PhostBotAdmin").get(0)) || message.getAuthor().getID().equals(ClientManager.getBotAdminID()))){
            MessageSender.sendMessage("You need PhostBotAdmin to do that!", message.getChannel());
            return;
        }
        List<IUser> mentions = message.getMentions();
        if (mentions.size() <= 0) {
            MessageSender.sendMessage("You need to mention the person you want to assign the role to", message.getChannel());
        }
        List<IRole> roles = message.getGuild().getRolesByName(args.get(1));
        if (roles.size() != 1){
            MessageSender.sendMessage("There are multiple or no roles with that name!", message.getChannel());
            return;
        }
        IRole role = roles.get(0);
        for(int i = 0; i < mentions.size(); i++){
            mentions.get(i).addRole(role);
        }
    }

    public static void removeRoleCommand(ArrayList<String> args, IMessage message) {
        if(!(ClientManager.getClientInstance().getOurUser().getPermissionsForGuild(message.getGuild()).contains(Permissions.MANAGE_ROLES))){
            MessageSender.sendMessage("I need the permission to manage roles for this command to work.", message.getChannel());
            return;
        }
        if(args.size() < 3) {
            MessageSender.sendMessage("Use this command like this: ♥removerole <role> <@user>", message.getChannel());
            return;
        }
        if(!(message.getAuthor().getRolesForGuild(message.getGuild()).contains(message.getGuild().getRolesByName("PhostBotAdmin").get(0)) || message.getAuthor().getID().equals(ClientManager.getBotAdminID()))){
            MessageSender.sendMessage("You need PhostBotAdmin to do that!", message.getChannel());
            return;
        }
        List<IUser> mentions = message.getMentions();
        if (mentions.size() <= 0) {
            MessageSender.sendMessage("You need to mention the person you want to remove the role of", message.getChannel());
        }
        List<IRole> roles = message.getGuild().getRolesByName(args.get(1));
        if (roles.size() != 1){
            MessageSender.sendMessage("There are multiple or no roles with that name!", message.getChannel());
            return;
        }
        IRole role = roles.get(0);
        for(int i = 0; i < mentions.size(); i++){
            mentions.get(i).removeRole(role);
        }
    }
}