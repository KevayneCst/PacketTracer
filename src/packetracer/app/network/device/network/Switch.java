package packetracer.app.network.device.network;

import packetracer.app.network.device.port.InterfaceSwitch;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Switch extends AbstractVirtualLocalAreaNetworkDevice {

	public Switch() {
		super(24);
	}

	public Switch(int nbInterface) {
		super(nbInterface);
	}

	@Override
	protected void init(int nbInterface) {
		for (int i = 0; i < nbInterface; i++) {
			interfaces.add(new InterfaceSwitch(i + 1, defaultVlan));
		}
	}

}
