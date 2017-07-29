import events.*;
import client.ClientManager;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Phost on 21.01.2017.
 */



public class main {

    public static void main(String[] args) throws IOException {

        ClientManager.setDeveloperMode(false);   //THIS TELLS THE BOT WHETHER HE IS IN DEV MODE OR NOT
        System.out.println("Please enter your bot Token");
        ClientManager.newClientInstance(new Scanner(System.in).next(), true);
        ClientManager.newDispatcher();
        ClientManager.getDispatcher().registerListener(new ReadyEventListener());
        ClientManager.getDispatcher().registerListener(new MessageReceivedEventListener());
        ClientManager.getDispatcher().registerListener(new UserJoinEventListener());
        ClientManager.getDispatcher().registerListener(new UserBanEventListener());
        ClientManager.getDispatcher().registerListener(new UserLeaveEventListener());
    }
}
