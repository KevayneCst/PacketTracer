package packetracer.app.network;

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
	public String toString() {
		return "VLAN: " + vlanID + "|" + vlanName;
	}

}
