package packetracer.app.network.device.network;

import packetracer.app.network.device.AbstractDevice;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Router extends AbstractDevice {

	public Router() {
		super(3);
	}

	public Router(int nbInterface) {
		super(nbInterface);
	}

}
