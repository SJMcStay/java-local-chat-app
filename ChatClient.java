import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.lang.Thread;
import java.net.*;
import java.io.*;
@SuppressWarnings("unused")

public class ChatClient{
    // SHOULD BE DONE IF NO LINKED LIST IMPLEMNT NEEDED
    
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println(
			       "Usage: java ChatClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
 
        try(Socket clientSocket = new Socket(hostName,portNumber)){
            
	    //Connect to the server by instantiating a Socket object
	    //Set the Socket output stream to a PrintWriter object
        PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream());
	    //Set the Socket input stream to a Buffered Reader
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));     	    
	    //Read in username from terminal
        Scanner userInput = new Scanner(System.in);
        boolean firstMessage = true;
        while (firstMessage) {
            String input = userInput.nextLine();
            if (input != null) {
                clientOut.print(input);
                firstMessage = false;
            }
        }


	    //Send username string to server
	    //Fire up a ClientReceiver thread -- did not yet do this 
        ClientReceiver clientReceiver = new ClientReceiver(clientIn);
        clientReceiver.run();

	    while (clientSocket.isConnected()) {
            // might need to change to while lopp to print old messages 

            
            }

            // write section
            String clientInput = userInput.nextLine();
            if (clientInput != null) {
                    clientOut.print(clientInput);
            }
        userInput.close();
        } catch (Exception e) {
            System.err.println("ChatClient: " + e);
            System.exit(1);
        }
    }


}
