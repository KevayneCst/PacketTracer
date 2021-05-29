package packetracer.app.network.protocol.arp;

import packetracer.app.network.InternetProtocolVersion4;
import packetracer.app.network.MediaAccessControl;

/**
 *
 * @author Kévin Constantin
 *
 */
public class ARPTableEntry {

	private final InternetProtocolVersion4 ipAddress;
	private final MediaAccessControl hardwareAddress;
	private final int interfaceID;

	public ARPTableEntry(InternetProtocolVersion4 ipAddress, MediaAccessControl hardwareAddress, int interfaceID) {
		this.ipAddress = ipAddress;
		this.hardwareAddress = hardwareAddress;
		this.interfaceID = interfaceID;
	}

	public InternetProtocolVersion4 getIpAddress() {
		return ipAddress;
	}

	public MediaAccessControl getHardwareAddress() {
		return hardwareAddress;
	}

	public int getInterfaceID() {
		return interfaceID;
	}

}
