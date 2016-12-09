package com.jooshdo.inceptum.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.jooshdo.inceptum.packet.Packet;
import com.jooshdo.inceptum.packet.Packet.PacketTypes;
import com.jooshdo.inceptum.packet.Packet00Ping;

public class GameClient extends Thread {

	public boolean running = false;
	
	private InetAddress ipAddress;
	private DatagramSocket socket;

	private Calendar cal;
	private SimpleDateFormat sdf;
	
	public GameClient( String ipAddress ) {
		this.sdf = new SimpleDateFormat( "HH:mm:ss" );
		try {
			this.ipAddress = InetAddress.getByName( ipAddress );
			this.socket = new DatagramSocket();
		} catch (UnknownHostException | SocketException e) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			parsePacket( packet.getData(), packet.getAddress(), packet.getPort() );
		}
	}
	
	public void startClient() {
		cal = Calendar.getInstance();
		running = true;
		start();
		System.out.println( "[" + sdf.format( cal.getTime() ) + "] " + "[Client]: " + "Connecting to server!" );
	}
	
	@SuppressWarnings("deprecation")
	public void stopClient() {
		cal = Calendar.getInstance();
		running = false;
		stop();
		socket.close();
		System.out.println( "[" + sdf.format( cal.getTime() ) + "] " + "[Client]: " + "Disconnecting from server!" );
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
			packet = new Packet00Ping( data );
			System.out.println( packet.packetId );
			break;

		}
	}
	
	public void sendData( byte[] data ) {
		DatagramPacket packet = new DatagramPacket( data, data.length, ipAddress, 25565 );
		try {
			socket.send( packet );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
