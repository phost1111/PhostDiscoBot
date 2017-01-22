package utils;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

/**
 * Created by Phost on 21.01.2017.
 */
public class MessageSender {

    public static void sendMessage(String message, IChannel channel) throws RateLimitException, DiscordException, MissingPermissionsException {
        channel.sendMessage(message);
    }

}
