package packetracer.app.network.device.port;

import packetracer.app.network.device.AbstractDevice;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Connexion {

	private final AbstractInterface connectedInterface;
	private final AbstractDevice connectedDevice;

	public Connexion(AbstractInterface connectedInterface, AbstractDevice connectedDevice) {
		this.connectedInterface = connectedInterface;
		this.connectedDevice = connectedDevice;
	}

	public AbstractInterface getConnectedInterface() {
		return connectedInterface;
	}

	public AbstractDevice getConnectedDevice() {
		return connectedDevice;
	}

	@Override
	public String toString() {
		return "Connected to: " + connectedDevice.getName() + " on " + connectedInterface.fullName();
	}
}
