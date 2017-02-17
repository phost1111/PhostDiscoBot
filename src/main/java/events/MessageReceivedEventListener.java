package events;

import client.ClientManager;
import modules.CommandManager;
import modules.Commands;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.io.IOException;

/**
 * Created by Phost on 21.01.2017.
 */
public class MessageReceivedEventListener {

    @EventSubscriber
    public void onMessageReceivedEvent(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException, IOException {
        if(event.getMessage().getContent().startsWith("♥")){
            CommandManager.commandIn(new StringBuilder(event.getMessage().getContent()).deleteCharAt(0).toString(), event.getMessage());
                System.out.println("Command received: " + event.getMessage().getContent() + " by: " + event.getMessage().getAuthor().getName() + " in Channel: " + event.getMessage().getChannel().getName() + " in Guild: " + event.getMessage().getGuild().getName());

        }else{
                System.out.println("Message received: " + event.getMessage().getContent() + " by: " + event.getMessage().getAuthor().getName() + " in Channel: " + event.getMessage().getChannel().getName() + " in Guild: " + event.getMessage().getGuild().getName());
        }


    }


}
