package events;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.time.ZonedDateTime;

/**
 * Created by Phost on 21.01.2017.
 */
public class MessageReceivedEventListener {

    @EventSubscriber
    public void onMessageReceivedEvent(MessageReceivedEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        IMessage message = event.getMessage();
        if(message.getContent().startsWith("!botworking")){
            modules.MessageResponder.respond("Bot working!", event);
            System.out.println("" + event.getMessage().getChannel().getID() + " " + event.getMessage().getChannel().getName());
        }
        if(message.getContent().startsWith("!zeit") || message.getContent().startsWith("!time")){
            modules.MessageResponder.respond("" + ZonedDateTime.now().getHour() + ":" + ZonedDateTime.now().getMinute(), event);
        }
        if(message.getContent().equals("!invlink") || message.getContent().equals("!invitelink")){
            modules.MessageResponder.respond("https://discordapp.com/oauth2/authorize?&client_id=272381828109828097&scope=bot&permissions=0x00000008", event);
        }
        if(message.getContent().startsWith("!koala")){
            modules.MessageResponder.respond("http://www.koalastothemax.com/?aHR0cDovL2ltZ3VyLmNvbS9PSWowR2kxLmpwZw==", event);
        }
        if(message.getContent().equals("!invlinktesting") || message.getContent().equals("!invitelinktesting")){
            modules.MessageResponder.respond("https://discordapp.com/oauth2/authorize?&client_id=222058371996581890&scope=bot&permissions=0x00000008", event);
        }
    }


}
