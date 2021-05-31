package packetracer.app.network.device.port;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(connectedDevice, connectedInterface);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Connexion) {
			final Connexion other = (Connexion) obj;
			return connectedDevice.equals(other.connectedDevice) && connectedInterface.equals(other.connectedInterface);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Connected to: " + connectedDevice.getName() + " on " + connectedInterface.fullName();
	}
}
