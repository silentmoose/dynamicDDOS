package dynamicDDOS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketAddress;
/*
private int numThreads;
	private int sleepTime;
	private boolean udp; //if udp = 0 tcp is assumed
	private String packet[];
	private SocketAddress url;
	private int port;
 */
import java.util.Arrays;

public class main {
	private static String packet[];
	private static socket sock = new socket();
	public static void main(String args[]){
		
		if (args.length != 5)
		{
			System.out.println("Usage: Java main (Number of Threads) (udp: 0 for tcp, 1 for udp) (IP address) (port) (sleep time: 0 if no sleep");
			System.exit(1);
		}
		try {
			getPackets();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setParams(args,sock);
		Thread t = new Thread(sock);
		t.start();
		
		
		
	}
	public static void setParams(String args[], socket sock){
		sock.setNumThreads(Integer.parseInt(args[0]));
		sock.setPacket(packet);
		sock.setSleepTime(Integer.parseInt(args[4]));
		boolean b = (Integer.parseInt(args[1]) != 0);
		sock.setUdp(b);
		sock.setIP(args[2]);
	}
	
	public static void getPackets() throws IOException{
		System.out.println("Enter number of different packets");
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String s = br.readLine();
		int nop = Integer.parseInt(s);
		System.out.println();
		System.out.println(nop);
		String packet[] = new String[nop];
		System.out.println("Enter Each Packet Sepretly: Press enter after each packet");
		
		for ( int i = 0;i < nop; i++)
		{
				packet[i] = br.readLine();
				System.out.println("read");
				System.out.println(sock.getNumThreads());
		}
	
	}

}
