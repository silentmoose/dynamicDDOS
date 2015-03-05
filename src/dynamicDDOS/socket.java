package dynamicDDOS;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;

public class socket implements Runnable {
	private int numThreads;
	private int sleepTime;
	private boolean udp; //if udp = 0 tcp is assumed
	private String packet[];
	private int port;
	private String IP;
	public void sendString() throws InterruptedException{
		Socket sock = new Socket();
		
		DataOutputStream dOut = null;
		try {
			dOut = new DataOutputStream(sock.getOutputStream());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		try {
			for (int i = 0; i < packet.length; i++)
			{
			dOut.writeUTF(packet[i]);
			Thread.sleep(sleepTime);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			sock.connect(new InetSocketAddress(IP,port));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void run() {
		Thread[] threads = new Thread[2];
		for (int i =1;i<2;i++){
			threads[i] = new Thread(this);
		    threads[i].start();	
		}
	}
	

	public int getNumThreads() {
		return numThreads;
	}

	public void setNumThreads(int numThreads) {
		this.numThreads = numThreads;
	}


	public int getSleepTime() {
		return sleepTime;
	}


	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}


	public boolean isUdp() {
		return udp;
	}


	public void setUdp(boolean udp) {
		this.udp = udp;
	}


	public String[] getPacket() {
		return packet;
	}


	public void setPacket(String packet[]) {

		this.packet = packet;
	}



	public String getIP() {
		return IP;
	}


	public void setIP(String iP) {
		IP = iP;
	}
}// end class

