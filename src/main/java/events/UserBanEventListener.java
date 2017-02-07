package events;

import client.ClientManager;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.UserBanEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.FileManager;
import utils.MessageSender;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Phost on 05.02.2017.
 */
public class UserBanEventListener {

    @EventSubscriber
    public void onUserBanEvent(UserBanEvent event) throws RateLimitException, DiscordException, MissingPermissionsException, IOException {
        List<IChannel> channels = event.getGuild().getChannels();
        for (int i = channels.size(); i >= 1; i--) {
            if (channels.get(i - 1).getName().equals("general")) {
                if(FileManager.checkIfAlreadyExists(event.getGuild()) != null) {
                    if (ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getMinute() >= 10)
                        MessageSender.sendMessage("User " + event.getUser().mention() + " just got banned from " + event.getGuild().getName() + "!" + " ```" + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getDayOfMonth() + "." + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getMonthValue() + "." + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getYear() + " " + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getHour() + ":" + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getMinute() + "```", channels.get(i - 1));
                    else
                        MessageSender.sendMessage("User " + event.getUser().mention() + " just got banned from " + event.getGuild().getName() + "!" + " ```" + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getDayOfMonth() + "." + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getMonthValue() + "." + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getYear() + " " + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getHour() + ":0" + ZonedDateTime.now(ZoneId.of(FileManager.checkIfAlreadyExists(event.getGuild()))).getMinute() + "```", channels.get(i - 1));
                }else{
                    MessageSender.sendMessage("```Phost\nCouldn't send message with ban info because no timezone was set on this server! To do so type '♥settimezone <yourTimezone>'\n```", channels.get(i - 1));
                }
            }
        }
    }
}
