package events;

import client.ClientManager;
import com.vdurmont.emoji.EmojiParser;
import console.ConsoleCommandManager;
import commands.CommandManager;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
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
        if(event.getMessage().getChannel().isPrivate() && event.getMessage().getAuthor().getID().equals(ClientManager.getBotAdminID()) && event.getMessage().getContent().startsWith("*")){
            ConsoleCommandManager.consoleCommandIn(new StringBuilder(event.getMessage().getContent()).deleteCharAt(0).toString());
            return;
        }
        if(event.getMessage().getContent().startsWith("♥")){
            CommandManager.commandIn(new StringBuilder(event.getMessage().getContent()).deleteCharAt(0).toString(), event.getMessage());
        }
        if(event.getMessage().getContent().toLowerCase().contains("zombe") || event.getMessage().getContent().toLowerCase().contains("z0mbey") || event.getMessage().getContent().toLowerCase().contains("zomb3y") || event.getMessage().getContent().toLowerCase().contains("z0mb3y") || event.getMessage().getContent().toLowerCase().contains("zimbel") || event.getMessage().getContent().toLowerCase().contains("zumbel")){
            event.getMessage().addReaction(EmojiParser.parseToUnicode(":sparkling_heart:"));
        }

    }


}
