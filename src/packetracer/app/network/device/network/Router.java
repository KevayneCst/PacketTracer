package packetracer.app.network.device.network;

import packetracer.app.network.device.AbstractDevice;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Router extends AbstractDevice {

	public Router(String name) {
		super(name, 3);
	}

	public Router(String name, int nbInterface) {
		super(name, nbInterface);
	}

}
