import Events.MessageReceivedEventListener;
import Events.ReadyEventListener;
import client.ClientManager;

/**
 * Created by Phost on 21.01.2017.
 */
public class main {

    public static boolean realeasemode = false;

    public static void main(String[] args){

        ClientManager.setDeveloperMode(true);
        if(!ClientManager.getDeveloperMode())
            ClientManager.newClientInstance("INSERT TOKEN HERE", true);
        else
            ClientManager.newClientInstance("INSERT TEST BOT TOKEN HERE", true);
        ClientManager.newDispatcher();
        ClientManager.getDispatcher().registerListener(new ReadyEventListener());
        ClientManager.getDispatcher().registerListener(new MessageReceivedEventListener());

    }
}
