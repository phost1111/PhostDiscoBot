package client;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.DiscordException;

/**
 * Created by Phost on 21.01.2017.
 */
public class ClientManager {

    public static boolean isDeveloperMode;
    public static IDiscordClient theClient;
    public static EventDispatcher theDispatcher;
    public static String Version = "0.4.1-SNAPSHOT";
    public static String BotAdminID = "139354514091147264";


    public static void newClientInstance(String token, Boolean login){
        theClient = createClient(token, login);
    }

    public static void endClientInstance() throws DiscordException {
        getClientInstance().logout();
    }

    public static IDiscordClient getClientInstance(){
        return theClient;
    }

    public static void setPlaying(String s){
        theClient.changePlayingText(s);
    }

    public static void newDispatcher(){
        theDispatcher = getClientInstance().getDispatcher();
    }

    public static EventDispatcher getDispatcher(){
        return theDispatcher;
    }

    public static void setDeveloperMode(boolean bool){
        isDeveloperMode = bool;
    }

    public static boolean getDeveloperMode(){
        return isDeveloperMode;
    }

    public static String getBotAdminID(){
        return BotAdminID;
    }

    public static IDiscordClient createClient(String token, boolean login) { // Returns a new instance of the Discord client
        ClientBuilder clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
        clientBuilder.withToken(token); // Adds the login info to the builder
        try {
            if (login) {
                return clientBuilder.login(); // Creates the client instance and logs the client in
            } else {
                return clientBuilder.build(); // Creates the client instance but it doesn't log the client in yet, you would have to call client.login() yourself
            }
        } catch (DiscordException e) { // This is thrown if there was a problem building the client
            e.printStackTrace();
        }
        return null;
    }
}
