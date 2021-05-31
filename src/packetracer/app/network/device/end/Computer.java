package packetracer.app.network.device.end;

import java.util.Objects;

import packetracer.app.network.Gateway;
import packetracer.app.network.device.AbstractDevice;

/**
 * A Computer is an {@link AbstractDevice} and who has a Gateway
 *
 * @author Kévin Constantin
 *
 */
public class Computer extends AbstractDevice {

	private Gateway gateway;

	/**
	 * Create a Computer object with 1 interface by default
	 *
	 * @param name The name of this device
	 */
	public Computer(String name) {
		super(name, 1);
		gateway = null;
	}

	/**
	 * Create a Computer object
	 *
	 * @param name        The name of this device
	 * @param nbInterface The number of interfaces of this device
	 */
	public Computer(String name, int nbInterface) {
		super(name, nbInterface);
		gateway = null;
	}

	/**
	 * Create a Computer object
	 *
	 * @param name        The name of this device
	 * @param nbInterface The number of interfaces of this device
	 * @param gateway     The gateway of this device
	 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(gateway);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Computer) {
			final Computer other = (Computer) obj;
			return gateway.equals(other.gateway) && super.equals(other);
		}
		return false;
	}

}
