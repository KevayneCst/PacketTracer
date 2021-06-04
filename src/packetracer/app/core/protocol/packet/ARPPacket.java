package packetracer.app.core.protocol.packet;

import packetracer.app.core.InternetProtocolVersion4;
import packetracer.app.core.MediaAccessControl;
import packetracer.app.core.protocol.header.EtherType;

public class ARPPacket extends Packet {

	public static final int BYTE_SIZE = 28;
	protected HardwareType hardwareType;
	protected EtherType protocolType;
	protected int macByteSize;
	protected int ipByteSize;
	protected MediaAccessControl sourceMac;
	protected InternetProtocolVersion4 sourceIp;
	protected MediaAccessControl targetMac;
	protected InternetProtocolVersion4 targetIp;

	public ARPPacket() {

	}

}
