import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
@SuppressWarnings("unused")

public class ServerInputThread extends Thread{

	private String username;
	private Socket socket;
	private String color;
    private static final String ANSI_RESET = "\u001B[0m";


    public void run(){
	try{
		Boolean firstMessage = true;
		BufferedReader clientReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

		String message;
		while (( message = clientReader.readLine())!= null) {
				if(firstMessage){

					this.username = message;
					firstMessage = false;
					message = clientReader.readLine();
					this.color = colorSelector(message);
					ChatServer.connections.add(socket);	
					ChatServer.messages.add("|-----Server: " + this.username + " has connected-----|");
					}
				else{
					message = this.color + this.username + ": " + ANSI_RESET + message;
					ChatServer.messages.add(message);
				}
				
			
		}
		// could break code
		message = "|-----Server: "+ this.username + " has disconnected-----|";
		ChatServer.messages.add(message);

		ChatServer.connections.remove(this.socket);
		
	    //Read in a line representing the username
	    //Set the username field
	    //Add a new socket to the static connection list

	    //Continually read input from the client socket
	    //Add that input to the messages list with the username infront "JR: lorum ipsum"
	}catch(Exception e){
	    System.out.println("ServerInputThread (run): " + e);
	    System.exit(1);
	}
    }

    public ServerInputThread(Socket clientSocket){
	try{
		this.socket = clientSocket;


	    
	}catch(Exception e){
	    System.out.println("ServerInputThread (Constructor)"+e);
	    System.exit(1);
	}
    }
	private String colorSelector(String color){
		switch (color) {
			case "g":
			// GREEN COLOR
				return "\u001B[32m";
			case "r":
			// RED COLOR
				return "\u001B[31m";
			case "b":
			//BLUE COLOR
				return "\u001B[34m";
			case "y":
			// YELLOW COLOR
				return "\u001B[33m";
			default:
				return ANSI_RESET;
		}
	}
}

