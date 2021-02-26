package cse3040fp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Book implements Comparable<Book> {

	private String title;
	private String author;

	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public String toString() {
		return title + "\t" + author;
	}

	@Override
	public int compareTo(Book o) {
		return this.title.compareToIgnoreCase(o.getTitle());
	}
}

class BookReader {
	static TreeMap<Book, String> map = new TreeMap<Book, String>();

	public static void readData(String str) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(str));
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found.");
			return;
		}
		while (true) {
			try {
				String line = br.readLine();
				if (line == null)
					break;
				String[] token = line.split("\t");
				map.put(new Book(token[0], token[1]), token[2]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BookReader.txtUpdate();
		return;
	}

	public static void txtUpdate() {
		try {
			PrintWriter pw = new PrintWriter("books.txt");
			String str = "";
			Iterator<Entry<Book, String>> it = BookReader.map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Book, String> entry = it.next();
				Book book = entry.getKey();
				str = book.getTitle() + "\t" + book.getAuthor() + "\t" + entry.getValue();
				pw.println(str);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addtxt(String title, String author, String state) {
		map.put(new Book(title, author), state);
		BookReader.txtUpdate();
	}
}

public class Server {
	HashMap<String, DataOutputStream> clients;

	Server() {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);
	}

	public void start(String args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(Integer.parseInt(args));
			System.out.println("server has started.");
			while (true) {
				socket = serverSocket.accept();
				System.out.println("a new connection from [" + socket.getInetAddress() + ":" + socket.getPort() + "]");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.print("Please give the port number as an argument.");
			System.exit(0);
		}
		BookReader.readData("books.txt");
		new Server().start(args[0]);
	}

	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
			}
		}

		public void addBook() {
			String title = "";
			String author = "";

			try {
				out.writeUTF("add-title> ");
				title = in.readUTF();
				if (title.trim().equals("")) {
					return;
				}
				out.writeUTF("add-author> ");
				author = in.readUTF();
				if (author.trim().equals("")) {
					return;
				}
				Iterator<Entry<Book, String>> it = BookReader.map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<Book, String> entry = it.next();
					Book book = entry.getKey();
					if (title.equalsIgnoreCase(book.getTitle())) {
						out.writeUTF("The book already exists in the list.\n");
						return;
					}
				}
				BookReader.addtxt(title, author, "-");
				out.writeUTF("A new book added to the list.\n");
			} catch (IOException e) {
				// ignore
			}
			return;
		}

		public void borrowBook(String name) {
			String title = "";
			try {
				out.writeUTF("borrow-title> ");
				title = in.readUTF();
				if (title.trim().equals(""))
					return;
				Iterator<Entry<Book, String>> it = BookReader.map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<Book, String> entry = it.next();
					Book book = entry.getKey();
					if (title.equalsIgnoreCase(book.getTitle())) {
						if (entry.getValue().equals("-")) {
							BookReader.addtxt(book.getTitle(), book.getAuthor(), name);
							out.writeUTF("You borrowed a book. - " + book.getTitle() + "\n");
							return;
						} else {
							out.writeUTF("The book is not available.\n");
							return;
						}

					}
				}
				out.writeUTF("The book is not available.\n");
				return;

			} catch (IOException e) {
				// ignore
			}
			return;
		}

		public void returnBook(String name) {
			String title = "";
			try {
				out.writeUTF("return-title> ");
				title = in.readUTF();
				if (title.trim().equals(""))
					return;
				Iterator<Entry<Book, String>> it = BookReader.map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<Book, String> entry = it.next();
					Book book = entry.getKey();
					if (title.equalsIgnoreCase(book.getTitle())) {
						if (entry.getValue().equals(name)) {
							BookReader.addtxt(book.getTitle(), book.getAuthor(), "-");
							out.writeUTF("You returned a book. - " + book.getTitle() + "\n");
							return;
						} else {
							out.writeUTF("You did not borrow the book.\n");
							return;
						}
					}
				}
				out.writeUTF("You did not borrow the book.\n");
				return;
			} catch (IOException e) {
				// ignore
			}
			return;
		}

		public void infoBook(String name) {
			int cnt = 0;
			Map<String, String> temp = new LinkedHashMap<String, String>();
			try {
				Iterator<Entry<Book, String>> it = BookReader.map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<Book, String> entry = it.next();
					Book book = entry.getKey();
					if (entry.getValue().equals(name)) {
						temp.put(book.getTitle(), book.getAuthor());
						cnt++;
					}
				}
				out.writeUTF("You are currently borrowing " + cnt + " books:\n");
				Iterator<Entry<String, String>> itTemp = temp.entrySet().iterator();
				int i = 1;
				while (itTemp.hasNext()) {
					Map.Entry<String, String> entry = itTemp.next();
					out.writeUTF(i++ + ". " + entry.getKey() + ", " + entry.getValue() + "\n");
				}
			} catch (IOException e) {
				// ignore
			}
			return;
		}

		public void searchBook() {
			String word = "";
			int cnt = 0;
			TreeMap<String, String> temp = new TreeMap<String, String>();
			try {
				while (true) {
					out.writeUTF("search-string> ");
					word = in.readUTF();
					if (word.equals(""))
						return;
					if (word.length() >= 3) {
						break;
					}
					out.writeUTF("Search string must be longer than 2 characters.\n");
				}
				Iterator<Entry<Book, String>> it = BookReader.map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<Book, String> entry = it.next();
					Book book = entry.getKey();
					if (book.getTitle().toUpperCase().contains(word.toUpperCase())
							|| book.getAuthor().toUpperCase().contains(word.toUpperCase())) {
						temp.put(book.getTitle(), book.getAuthor());
						cnt++;
					}
				}
				out.writeUTF("Your search matched " + cnt + " results.\n");
				Iterator<Entry<String, String>> itTemp = temp.entrySet().iterator();
				int i = 1;
				while (itTemp.hasNext()) {
					Map.Entry<String, String> entry = itTemp.next();
					out.writeUTF(i++ + ". " + entry.getKey() + ", " + entry.getValue() + "\n");
				}
			} catch (IOException e) {
				// ignore
			}
			return;
		}

		public void commandBook() {
			try {
				out.writeUTF("[available commands]\n" + "add: add a new book to the list of books.\n"
						+ "borrow: borrow a book from the library.\n" + "return: return a book to the library.\n"
						+ "info: show list of books I am currently borrowing.\n" + "search: search for books.\n");
			} catch (IOException e) {
				// ignore
			}
		}

		public void run() {
			String name = "";
			String temp = "";

			try {
				name = in.readUTF();

				clients.put(name, out);
				out.writeUTF("Hello " + name + "!\n");
				System.out.println("Current number of users: " + clients.size());
				while (in != null) {
					out.writeUTF(name + ">> ");
					temp = in.readUTF();
					if (temp.equals("add")) {
						addBook();
					} else if (temp.equals("borrow")) {
						borrowBook(name);
					} else if (temp.equals("return")) {
						returnBook(name);
					} else if (temp.equals("info")) {
						infoBook(name);
					} else if (temp.equals("search")) {
						searchBook();
					} else {
						commandBook();
					}

				}
			} catch (IOException e) {
// ignore
			} finally {
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + " has disconnected.");
				System.out.println("Current number of users: " + clients.size());
			}
		}
	}
}
