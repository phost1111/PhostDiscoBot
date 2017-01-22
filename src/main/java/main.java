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
            ClientManager.newClientInstance("MjcyMzgxODI4MTA5ODI4MDk3.C2UK-Q.IAIm-WPqzVkiS9Ux3C3sDgwrPhU", true);
        else
            ClientManager.newClientInstance("MjIyMDU4MzcxOTk2NTgxODkw.C2UMgA.H7WmR72Uf_z4hEc12o1otpOt78M", true);
        ClientManager.newDispatcher();
        ClientManager.getDispatcher().registerListener(new ReadyEventListener());
        ClientManager.getDispatcher().registerListener(new MessageReceivedEventListener());

    }
}
