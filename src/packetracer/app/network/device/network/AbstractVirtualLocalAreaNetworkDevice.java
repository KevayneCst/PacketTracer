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
	protected List<VirtualLocalAreaNetwork> vlanDatabase;

	protected AbstractVirtualLocalAreaNetworkDevice(int nbInterface) {
		super(nbInterface);
		vlanDatabase = new ArrayList<>();
		vlanDatabase.add(defaultVlan);
	}

	public List<VirtualLocalAreaNetwork> getVlanDatabase() {
		return vlanDatabase;
	}

}
