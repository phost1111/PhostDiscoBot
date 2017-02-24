package events;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.member.UserBanEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.FileManager;
import utils.MessageSender;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Phost on 05.02.2017.
 */
public class UserBanEventListener {

    @EventSubscriber
    public void onUserBanEvent(UserBanEvent event) throws RateLimitException, DiscordException, MissingPermissionsException, IOException {
        if (FileManager.searchInFile("timeZoneDB", event.getGuild().getID()) != null) {
            if (ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getMinute() >= 10)
                MessageSender.sendMessage("User " + event.getUser().mention() + " just got banned from " + event.getGuild().getName() + "!" + " ```" + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getDayOfMonth() + "." + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getMonthValue() + "." + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getYear() + " " + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getHour() + ":" + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getMinute() + "```", event.getGuild().getChannelByID(event.getGuild().getID()));
            else
                MessageSender.sendMessage("User " + event.getUser().mention() + " just got banned from " + event.getGuild().getName() + "!" + " ```" + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getDayOfMonth() + "." + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getMonthValue() + "." + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getYear() + " " + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getHour() + ":0" + ZonedDateTime.now(ZoneId.of(FileManager.searchInFile("timeZoneDB", event.getGuild().getID()))).getMinute() + "```", event.getGuild().getChannelByID(event.getGuild().getID()));
        }else{
            MessageSender.sendMessage("```Phost\nCouldn't send message with ban info because no timezone was set on this server! To do so type '♥settimezone <yourTimezone>'\n```", event.getGuild().getChannelByID(event.getGuild().getID()));
        }
    }
}
