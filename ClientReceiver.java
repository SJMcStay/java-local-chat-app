import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
@SuppressWarnings("unused")

public class ClientReceiver extends Thread{



	private BufferedReader clientReader;
    public void run(){
		//TODO: fix true loop
	while(true){
	    try{
			Thread.sleep(100);
		    String message;
			if(clientReader.ready()){
				if((message = clientReader.readLine())!= null){
					System.out.println(message);
				}
			}
	        //Sleep for 100 miliseconds if message is null
	    }catch(Exception e){
		System.out.println("ClientReceiver: " + e);
		System.exit(1);
	    }
	    
	}
    }
    ClientReceiver(BufferedReader in){
		clientReader = in;
	//takes the input stream from the server socket connected to client instance

    }
}
