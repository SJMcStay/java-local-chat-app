import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
@SuppressWarnings("unused")
public class ServerOutputThread extends Thread{
    public void run(){
	try{
		while (true) {//change to check if stuff is open 
			if (ChatServer.messages.size() != 0) {
				
			String message = ChatServer.messages.pop();
			for(Socket socket : ChatServer.connections){
				PrintWriter serverOut = new PrintWriter(socket.getOutputStream());
				serverOut.println(message);
			}
			//Continually loop through all messages
			//If queue is not empty then pop message off the queue
			//Loop through all connections and send popped message to each connection
			}
	    	else{/// change to check if queue is empty
				Thread.sleep(100);
			}
	}
	}catch(Exception e){
	    System.out.println("ServerOutputThread (run): " + e);
	}
    }
}
