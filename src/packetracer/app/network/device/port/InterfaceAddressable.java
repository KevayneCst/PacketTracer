package packetracer.app.network.device.port;

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
	private InternetProtocolVersion4 ipAddress;
	private Mask subnetMask;

	public InterfaceAddressable(int id) {
		super(id);
		macAddress = ProviderMAC.generateMACAddress();
		ipAddress = null;
		subnetMask = null;
	}

	public InterfaceAddressable(int id, Connexion connexion, InternetProtocolVersion4 ipAddress, Mask subnetMask) {
		super(id, connexion);
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
	public String toString() {
		return super.toString() + "\t" + macAddress.toString() + "\t" + ipAddress.toString() + "\t"
				+ subnetMask.toString();
	}
}
