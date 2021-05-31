package packetracer.app.network;

import java.util.Objects;

/**
 *
 * @author Kévin Constantin
 *
 */
public class VirtualLocalAreaNetwork {

	private final int vlanID;
	private final String vlanName;

	public VirtualLocalAreaNetwork(int vlanID, String vlanName) {
		this.vlanID = vlanID;
		this.vlanName = vlanName;
	}

	public int getVlanID() {
		return vlanID;
	}

	public String getVlanName() {
		return vlanName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(vlanID, vlanName);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof VirtualLocalAreaNetwork) {
			final VirtualLocalAreaNetwork other = (VirtualLocalAreaNetwork) obj;
			return vlanID == other.vlanID && vlanName.equals(other.vlanName);
		}
		return false;
	}

	@Override
	public String toString() {
		return "VLAN: " + vlanID + "|" + vlanName;
	}

}
