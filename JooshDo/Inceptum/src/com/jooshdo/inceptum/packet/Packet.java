package com.jooshdo.inceptum.packet;

import com.jooshdo.inceptum.net.GameClient;
import com.jooshdo.inceptum.net.GameServer;

public abstract class Packet {

	public static enum PacketTypes {
		
		INVALID(-1),
		PING(00),
		CONNECT(01);
		
//		INVALID(-1),
//		LOGIN(00),
//		UPDATEPLAYER(01),
//		CONNECT(02),
//		DISCONNECT(03),
//		READY(04),
//		MOVE(05),
//		FULL(06),
//		NAME(07),
//		CLOSED(10),
//		SCORE(11),
//		CHAR(12),
//		DEATH(13),
//		BOMBT(14),
//		BOMBC(15),
//		PUSH(16),
//		HEART(17);
		
		private int packetId;
		
		private PacketTypes( int packetId ) {
			this.packetId = packetId;
		}

		public int getId() {
			return packetId;
		}
		
	}
	
	public byte packetId;

	public Packet( int packetId ) {
		this.packetId = (byte) packetId;
	}

	public abstract void writeData( GameClient client );

	public abstract void writeData( GameServer server );

	public String readData( byte[] data ) {
		String message = new String( data ).trim();
		return message.substring(2);
	}
	
	public abstract byte[] getData();

	public static PacketTypes lookupPacket( String id ) {
		try {
			return lookupPacket( Integer.parseInt( id ) );
		} catch( NumberFormatException e ) {
			return PacketTypes.INVALID;
		}
	}
	
	public static PacketTypes lookupPacket( int id ) {
		for( PacketTypes p: PacketTypes.values() ) {
			if( p.getId() == id ) {
				return p;
			}
		}
		return PacketTypes.INVALID;
	}
	
}
