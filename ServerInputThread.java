import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ServerInputThread extends Thread{

	private String username;
	private Socket socket;

    public void run(){
	try{
		Boolean firstMessage = true;
		InputStream in = socket.getInputStream();
		while (!socket.isClosed()) {
			String message06;
			if(firstMessage){
				this.username = message;
				firstMessage = false;
			}



			
		}
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
		socket = clientSocket;


	    
	}catch(Exception e){
	    System.out.println("ServerInputThread (Constructor)"+e);
	    System.exit(1);
	}
    }
}
