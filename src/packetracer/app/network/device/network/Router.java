package packetracer.app.network.device.network;

import packetracer.app.network.device.AbstractDevice;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Router extends AbstractDevice {

	private static final String DEVICE_CATEGORY = "Router";

	public Router(String name) {
		super(DEVICE_CATEGORY, name, 3);
	}

	public Router(String name, int nbInterface) {
		super(DEVICE_CATEGORY, name, nbInterface);
	}

}
