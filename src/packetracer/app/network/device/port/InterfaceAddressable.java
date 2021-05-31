package packetracer.app.network.device.port;

import java.util.Objects;

import packetracer.app.network.InternetProtocolVersion4;
import packetracer.app.network.Mask;
import packetracer.app.network.MediaAccessControl;
import packetracer.app.network.provider.ProviderMAC;

/**
 *
 * @author Kévin Constantin
 *
 */
public class InterfaceAddressable extends AbstractInterface {

	private final MediaAccessControl macAddress;
	private final InternetProtocolVersion4 ipAddress;
	private final Mask subnetMask;

	public InterfaceAddressable(int id) {
		super(id);
		macAddress = ProviderMAC.generateMACAddress();
		ipAddress = null;
		subnetMask = null;
	}

	public InterfaceAddressable(int id, InternetProtocolVersion4 ipAddress, Mask subnetMask) {
		super(id);
		macAddress = ProviderMAC.generateMACAddress();
		this.ipAddress = ipAddress;
		this.subnetMask = subnetMask;
	}

	public MediaAccessControl getMacAddress() {
		return macAddress;
	}

	public InternetProtocolVersion4 getIpAddress() {
		return ipAddress;
	}

	public Mask getSubnetMask() {
		return subnetMask;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(ipAddress, macAddress, subnetMask);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof InterfaceAddressable) {
			final InterfaceAddressable other = (InterfaceAddressable) obj;
			return ipAddress.equals(other.ipAddress) && macAddress.equals(other.macAddress)
					&& subnetMask.equals(other.subnetMask) && super.equals(other);
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + macAddress.toString() + "\t" + ipAddress.toString() + "\t"
				+ subnetMask.toString();
	}
}
