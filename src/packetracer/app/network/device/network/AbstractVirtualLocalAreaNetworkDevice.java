package packetracer.app.network.device.network;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import packetracer.app.network.VirtualLocalAreaNetwork;
import packetracer.app.network.device.AbstractDevice;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class AbstractVirtualLocalAreaNetworkDevice extends AbstractDevice {

	protected static final VirtualLocalAreaNetwork DEFAULT_VLAN = new VirtualLocalAreaNetwork(1, "default");
	protected final List<VirtualLocalAreaNetwork> vlanDatabase;

	/**
	 * Construct an AbstractVirtualLocalAreaNetworkDevice object
	 *
	 * @param name        The name of this device
	 * @param nbInterface The number of interface of this device
	 */
	protected AbstractVirtualLocalAreaNetworkDevice(String deviceCategory, String name, int nbInterface) {
		super(deviceCategory, name, nbInterface);
		vlanDatabase = new ArrayList<>();
		vlanDatabase.add(DEFAULT_VLAN);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(DEFAULT_VLAN, vlanDatabase);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractVirtualLocalAreaNetworkDevice) {
			final AbstractVirtualLocalAreaNetworkDevice other = (AbstractVirtualLocalAreaNetworkDevice) obj;
			return DEFAULT_VLAN.equals(AbstractVirtualLocalAreaNetworkDevice.DEFAULT_VLAN)
					&& vlanDatabase.equals(other.vlanDatabase) && super.equals(other);
		}
		return false;
	}

}
