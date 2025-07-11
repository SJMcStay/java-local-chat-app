import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;
import java.net.*;
import java.io.*;
@SuppressWarnings("unused")

public class ChatServer{
    public static volatile ArrayList<Socket> connections = new ArrayList<>();
    public static volatile LinkedList<String> messages = new LinkedList<>();

    public static void main(String[] args){
	try{
	    try(ServerSocket serverSocket = new ServerSocket(0,0, InetAddress.getByName(args[0]))){
			//serverSocket.bind(null);
			System.out.println("IP Address: "+ serverSocket.getInetAddress());
			System.out.println("Port: " + serverSocket.getLocalPort());
			while (true) {
				Socket clientSocket = serverSocket.accept();

				ServerInputThread inputThread = new ServerInputThread(clientSocket);
				ServerOutputThread out = new ServerOutputThread();
				inputThread.start();
				out.start();


			}
		//construct a while loop to continually accept sockets
	    }catch(Exception e){
		System.out.println("ChatServer: "+e);
	    }
	}catch(Exception e){
	    System.out.println("ChatServer: "+e);
	}
    }

}
//172.18.254.145