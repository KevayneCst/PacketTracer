package packetracer.app.network.device.end;

import packetracer.app.network.Gateway;
import packetracer.app.network.device.AbstractDevice;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Computer extends AbstractDevice {

	private Gateway gateway;

	public Computer(String name) {
		super(name, 1);
		gateway = null;
	}

	public Computer(String name, int nbInterface) {
		super(name, nbInterface);
		gateway = null;
	}

	public Computer(String name, int nbInterface, Gateway gateway) {
		super(name, nbInterface);
		this.gateway = gateway;
	}

	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}

	public Gateway getGateway() {
		return gateway;
	}

}
