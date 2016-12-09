package com.jooshdo.inceptum.packet;

import com.jooshdo.inceptum.net.GameClient;
import com.jooshdo.inceptum.net.GameServer;

public class Packet00Ping extends Packet {
	
	public Packet00Ping( byte[] data ) {
		super( 00 );
	}
	public Packet00Ping() {
		super( 00 );
	}

	@Override
	public void writeData( GameClient client ) {
		client.sendData( getData() );
	}

	@Override
	public void writeData( GameServer server ) {
		//server.sendDataToAllClients( getData() );
	}
	
	@Override
	public byte[] getData() {
		return ( "00" ).getBytes();
	}

}
