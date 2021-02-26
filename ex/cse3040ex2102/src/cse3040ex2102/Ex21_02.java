package cse3040ex2102;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex21_02 {

	public static void main(String[] args) {
		InetAddress ip = null;
		int i;
		
		try { 
			ip = InetAddress.getByName("www.naver.com");

			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress(): " + Arrays.toString(ipAddr));
			
			String result = "";
			for(i=0; i<ipAddr.length-1;i++) {
				result +=(ipAddr[i]<0)?ipAddr[i]+256:ipAddr[i];
				result +=".";
			}
			result +=(ipAddr[i]<0)?ipAddr[i]+256:ipAddr[i];
			
			System.out.println("dotted decimal: " + result);
			System.out.println();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
