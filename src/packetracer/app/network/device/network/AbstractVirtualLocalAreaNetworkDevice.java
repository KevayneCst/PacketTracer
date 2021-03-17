package packetracer.app.network.device.network;

import java.util.ArrayList;
import java.util.List;

import packetracer.app.network.VirtualLocalAreaNetwork;
import packetracer.app.network.device.AbstractDevice;

/**
 *
 * @author Kévin Constantin
 *
 */
public class AbstractVirtualLocalAreaNetworkDevice extends AbstractDevice {

	protected VirtualLocalAreaNetwork defaultVlan = new VirtualLocalAreaNetwork(1, "default");
	protected final List<VirtualLocalAreaNetwork> vlanDatabase;

	protected AbstractVirtualLocalAreaNetworkDevice(String name, int nbInterface) {
		super(name, nbInterface);
		vlanDatabase = new ArrayList<>();
		vlanDatabase.add(defaultVlan);
	}

	public boolean addVlan(int vlanID, String vlanName) {
		return vlanDatabase.add(new VirtualLocalAreaNetwork(vlanID, vlanName));
	}

	public boolean deleteVlan(int vlanID) {
		return vlanDatabase.removeIf(vlan -> vlan.getVlanID() == vlanID);
	}

	public List<VirtualLocalAreaNetwork> getVlanDatabase() {
		return vlanDatabase;
	}

}
