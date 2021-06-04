package packetracer.app.core.device.network;

import java.util.Objects;

import packetracer.app.core.InternetProtocolVersion4;
import packetracer.app.core.MediaAccessControl;

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

	@Override
	public int hashCode() {
		return Objects.hash(hardwareAddress, interfaceID, ipAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ARPTableEntry) {
			final ARPTableEntry other = (ARPTableEntry) obj;
			return Objects.equals(ipAddress, other.ipAddress) && interfaceID == other.interfaceID
					&& Objects.equals(hardwareAddress, other.hardwareAddress);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Interface n°" + interfaceID + "\t" + hardwareAddress + "\t" + ipAddress;
	}

}
