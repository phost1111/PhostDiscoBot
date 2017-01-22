package modules;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

/**
 * Created by Phost on 21.01.2017.
 */
public class MessageResponder {

    public static void respond(String message, MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        new MessageBuilder(client.ClientManager.getClientInstance()).appendContent(message).withChannel(event.getMessage().getChannel()).build();
    }



}
