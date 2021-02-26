package cse3040ex2401;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			System.out.println("connecting to server, IP: " + serverIp);
			Socket socket = new Socket(serverIp, 7777);
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			System.out.println("message from server: " + dis.readUTF());
			System.out.println("disconnecting...");
			dis.close();
			socket.close();
			System.out.println("disconnected from server.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
