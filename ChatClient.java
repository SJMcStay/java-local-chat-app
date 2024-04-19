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

        ClientReceiver clientReceiver = new ClientReceiver(clientIn);
        clientReceiver.start();

            int numtime = 1;

            while (!clientSocket.isClosed()) {
                if (numtime ==1) {
                    System.out.println("Please enter a username");
                }
                else if (numtime == 2) {
                    System.out.println("Select a username color b: Blue, r: Red, y: Yellow, g: Green");
                }
                String clientInput = userInput.nextLine();

                clientOut.println(clientInput);
                clientOut.flush();
                numtime += 1;
                if(clientInput.equals("q!\n")){
                    System.out.println("quit thingy runs");
                    clientSocket.close();
                }
            }
            userInput.close();
            System.exit(0);
        } catch (Exception e) {
            System.err.println("ChatClient: " + e);
            System.exit(1);
        }
    }


}
