package modules;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.FileManager;
import utils.MessageSender;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by Phost on 22.01.2017.
 */
public class Commands {

    public static void botWorkingCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("Bot working!", channel);
        System.out.println("" + channel.getID() + " " + channel.getName());
    }
    public static void timeCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        if(ZonedDateTime.now().getMinute() >= 10)
            MessageSender.sendMessage("" + ZonedDateTime.now().getHour() + ":" + ZonedDateTime.now().getMinute(), channel);
        else
            MessageSender.sendMessage("" + ZonedDateTime.now().getHour() + ":0" + ZonedDateTime.now().getMinute(), channel);
    }
    public static void dateCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("" + ZonedDateTime.now().getDayOfMonth() + "." + ZonedDateTime.now().getMonthValue() + "." + ZonedDateTime.now().getYear(), channel);
    }
    public static void inviteLinkCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("https://discordapp.com/oauth2/authorize?&client_id=272381828109828097&scope=bot&permissions=0x00000008", channel);
    }
    public static void inviteLinkTestingCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("https://discordapp.com/oauth2/authorize?&client_id=222058371996581890&scope=bot&permissions=0x00000008", channel);
    }
    public static void koalaCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("http://www.koalastothemax.com/?aHR0cDovL2ltZ3VyLmNvbS9PSWowR2kxLmpwZw==", channel);
    }
    public static void helpCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        MessageSender.sendMessage("```HELP\n!botworking\n!time / !zeit\n!date / !datum\n!invlink / !invitelink\n!invlinktesting / !invitelinktesting\n!koala\n```", channel);
    }
    public static void testCommand(IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        ZoneId zone = ZoneId.of("UTC+1");
        MessageSender.sendMessage("" + ZonedDateTime.now(zone).getHour() + ":" + ZonedDateTime.now(zone).getMinute(), channel);
    }
    public static void setTimezoneCommand(IMessage message) throws IOException {
        FileManager.writeIntoFile(message.getChannel(), "test");
    }



}