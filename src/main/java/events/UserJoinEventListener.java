package events;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.UserJoinEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.MessageSender;

import java.util.List;

/**
 * Created by Phost on 31.01.2017.
 */
public class UserJoinEventListener {

    @EventSubscriber
    public void onUserJoinEvent(UserJoinEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        List<IChannel> channels = event.getGuild().getChannels();
        MessageSender.sendMessage("User " + event.getUser().mention() + " joined " + event.getGuild().getName() + " " + event.getJoinTime(), channels.get(0)); //TODO: Test this!
    }

}
