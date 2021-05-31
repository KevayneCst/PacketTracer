package packetracer.app.network.device.network;

import packetracer.app.network.device.port.InterfaceSwitch;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Switch extends AbstractVirtualLocalAreaNetworkDevice {

	public Switch(String name) {
		super(name, 24);
	}

	public Switch(String name, int nbInterface) {
		super(name, nbInterface);
	}

	@Override
	protected void init(int nbInterface) {
		for (int i = 0; i < nbInterface; i++) {
			interfaces.put(new InterfaceSwitch(i + 1, defaultVlan), null);
		}
	}

}
