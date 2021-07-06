import events.*;
import client.ClientManager;

import java.io.IOException;
import java.util.Scanner;


/**
 * The Main class which starts the Bot
 *
 * Created by Phost on 21.01.2017
 */
public class Main {

    /**
     *	Tells the bot if he is in dev-Mode or not
     */
    public static boolean devModeEnabled = false;

    public static void main(String[] args) throws IOException {

	if (args.length > 0) {
	    if (args[0].toLowerString().equals("-devmode")) {
		Main.devModeEnabled = true;
	    }
	}
	
        ClientManager.setDeveloperMode(Main.devModeEnabled);
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
