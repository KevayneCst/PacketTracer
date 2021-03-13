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

	public Computer() {
		super(1);
		gateway = null;
	}

	public Computer(int nbInterface) {
		super(nbInterface);
		gateway = null;
	}

	public Computer(int nbInterface, Gateway gateway) {
		super(nbInterface);
		this.gateway = gateway;
	}

	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}

	public Gateway getGateway() {
		return gateway;
	}

}
