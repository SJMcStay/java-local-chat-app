import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
public class ServerOutputThread extends Thread{
    public void run(){
	try{
		while (true) {//change to check if stuff is open 
			
			for(String message : ChatServer.messages){
				
			}
	    //Continually loop through all messages
	    //If queue is not empty then pop message off the queue
	    //Loop through all connections and send popped message to each connection

	    	if(ChatServer.messages.size() == 0){/// change to check if queue is empty
				Thread.sleep(100);
			}
	}
	}catch(Exception e){
	    System.out.println("ServerOutputThread (run): " + e);
	}
    }
}
