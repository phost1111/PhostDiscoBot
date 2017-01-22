package events;

import client.ClientManager;
import utils.MessageSender;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.List;

/**
 * Created by Phost on 21.01.2017.
 */
public class ReadyEventListener {

    @EventSubscriber
    public void onReadyEvent(ReadyEvent event) throws RateLimitException, DiscordException, MissingPermissionsException {
        List<IChannel> channels = ClientManager.getClientInstance().getChannels(true);
        List<IGuild> guilds = ClientManager.getClientInstance().getGuilds();
        System.out.println("GUILDS: ");
        for (int i = guilds.size(); i >= 1; i--) {
            System.out.println(guilds.get(i - 1).getName());
        }
        System.out.println("CHANNELS: ");
        for (int i = channels.size(); i >= 1; i--) {
            System.out.println(channels.get(i - 1).getName());
            if (channels.get(i - 1).getName().equals("general")) {
                if(!ClientManager.getDeveloperMode())
                    MessageSender.sendMessage("Bot online! V." + ClientManager.Version, channels.get(i - 1));
            }
        }
    }

}
