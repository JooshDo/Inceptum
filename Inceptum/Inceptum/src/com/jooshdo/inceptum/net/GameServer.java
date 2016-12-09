package com.jooshdo.inceptum.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.jooshdo.inceptum.packet.Packet;
import com.jooshdo.inceptum.packet.Packet.PacketTypes;
import com.jooshdo.inceptum.packet.Packet00Ping;

public class GameServer extends Thread {

	public boolean running = false;
	
	private DatagramSocket socket;
	//private List<PlayerMP> connectedPlayers = new ArrayList<PlayerMP>();
	
	private Calendar cal;
	private SimpleDateFormat sdf;
	
	public GameServer() {
		this.sdf = new SimpleDateFormat( "HH:mm:ss" );
		try {
			this.socket = new DatagramSocket( 25565 );
		} catch ( SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while( running ) {
			cal = Calendar.getInstance();
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket( data, data.length );
			try {
				socket.receive( packet );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
			parsePacket( packet.getData(), packet.getAddress(), packet.getPort() );
		}
	}
	
	public void startServer() {
		cal = Calendar.getInstance();
		running = true;
		start();
		System.out.println( "[" + sdf.format( cal.getTime() ) + "] " + "[Server]: " + "Server started!" );
	}
	
	@SuppressWarnings("deprecation")
	public void stopServer() {
		cal = Calendar.getInstance();
		running = false;
		stop();
		socket.disconnect();
		socket.close();
		System.out.println( "[" + sdf.format( cal.getTime() ) + "] " + "[Server]: " + "Stopping server!" );
	}
	
	private void parsePacket( byte[] data, InetAddress address, int port ) {
		String message = new String( data ).trim();
		PacketTypes type = Packet.lookupPacket( message.substring( 0, 2 ) );
		Packet packet = null;
		switch (type) {
		default:
		case INVALID:
			break;
		case PING:
			packet = new Packet00Ping();
			System.out.println( "pong" + packet.packetId );
			break;
			
		}
	}
	
	public void sendData( byte[] data, InetAddress ipAddress, int port ) {
		DatagramPacket packet = new DatagramPacket( data, data.length, ipAddress, port );
		try {
			socket.send( packet );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

//	public void sendDataToAllClients(byte[] data) {
//		for( PlayerMP p: connectedPlayers ) {
//			sendData( data, p.ipAddress, p.port );
//		}
//	}
	
}
