package com.jooshdo.inceptum.entity.player;

import java.net.InetAddress;

public class PlayerMP extends Player {

	private String username;
	private InetAddress ip;
	private int port;
	
	public PlayerMP( int x, int y, int character, String username, InetAddress ip, int port ) {
		super( x, y, character );
		this.username = username;
		this.ip = ip;
		this.port = port;
	}
	
	public String getUsername() {
		return username;
	}
	
	public InetAddress getIP() {
		return ip;
	}
	
	public int getPort() {
		return port;
	}

}
