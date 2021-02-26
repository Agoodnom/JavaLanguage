package cse3040_fp_20171630;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	static class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;
		String name;

		ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch (Exception e) {
			}
		}
		@SuppressWarnings("all")
		public void run() {
			Scanner scanner = new Scanner(System.in);
			try {
				if (out != null) {
					out.writeUTF(name);
				}
				while (out != null) {
					out.writeUTF(scanner.nextLine());
				}
			} catch (IOException e) {
			}
		}
	}

	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;

		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
			}
		}

		public void run() {
			while (in != null) {
				try {
					System.out.print(in.readUTF());
				} catch (IOException e) {
				}
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		if (args.length != 2) {
			System.out.print("Please give the IP address and port number as arguments.");
			System.exit(0);
		}
		try {
			String serverIp = args[0];
			Scanner sc = new Scanner(System.in);
			String name = "";
			Socket socket = new Socket(serverIp, Integer.parseInt(args[1]));
			while(true) {
				System.out.print("Enter userID>> ");
				name = sc.nextLine();
				if(name.matches("^[a-z0-9]*$")&&name.length()!=0) {
					Thread sender = new Thread(new ClientSender(socket, name));
					Thread receiver = new Thread(new ClientReceiver(socket));
					sender.start();
					receiver.start();
					break;
				}
				else {
					System.out.println("UserID must be a single word with lowercase alphabets and numbers.");
				}
			}
			
		} catch (ConnectException ce) {
			System.out.print("Connection establishment failed.");
			System.exit(0);
		} catch (Exception e) {
		}
	}
}