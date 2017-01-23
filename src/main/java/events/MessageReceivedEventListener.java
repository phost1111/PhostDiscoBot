package events;

import client.ClientManager;
import modules.Commands;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import utils.MessageSender;

import java.io.IOException;
import java.time.ZonedDateTime;

/**
 * Created by Phost on 21.01.2017.
 */
public class MessageReceivedEventListener {

    @EventSubscriber
    public void onMessageReceivedEvent(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException, IOException {
        IMessage message = event.getMessage();
        if(message.getContent().startsWith("!botworking")){
            Commands.botWorkingCommand(message.getChannel());
        }
        if(message.getContent().equals("!zeit") || message.getContent().equals("!time")){
            Commands.timeCommand(message.getChannel());
        }
        if(message.getContent().equals("!invlink") || message.getContent().equals("!invitelink")){
            Commands.inviteLinkCommand(message.getChannel());
        }
        if(message.getContent().startsWith("!koala")){
            Commands.koalaCommand(message.getChannel());
        }
        if(message.getContent().equals("!invlinktesting") || message.getContent().equals("!invitelinktesting")){
            Commands.inviteLinkTestingCommand(message.getChannel());
        }
        if(message.getContent().equals("!datum") || message.getContent().equals("!date")){
            Commands.dateCommand(message.getChannel());
        }
        if(message.getContent().equals("!help")){
            Commands.helpCommand(message.getChannel());
        }
        if(message.getContent().equals("!testcommand") && ClientManager.getDeveloperMode()){
            Commands.testCommand(message.getChannel());
        }
        if(message.getContent().startsWith("!settimezone ")){
            String zone = new StringBuilder(message.getContent()).delete(0,13).toString();
            Commands.setTimezoneCommand(message);
        }

    }


}
