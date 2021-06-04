package packetracer.app.core.device.network;

import packetracer.app.core.device.port.InterfaceSwitch;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Switch extends AbstractVirtualLocalAreaNetworkDevice {

	private static final String DEVICE_CATEGORY = "Switch";

	public Switch(String name) {
		super(DEVICE_CATEGORY, name, 24);
	}

	public Switch(String name, int nbInterface) {
		super(DEVICE_CATEGORY, name, nbInterface);
	}

	@Override
	protected void init(int nbInterface) {
		for (int i = 0; i < nbInterface; i++) {
			interfaces.put(new InterfaceSwitch(i + 1, DEFAULT_VLAN), null);
		}
	}

}
