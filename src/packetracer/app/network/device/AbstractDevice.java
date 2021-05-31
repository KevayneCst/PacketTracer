package packetracer.app.network.device;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import packetracer.app.network.device.port.AbstractInterface;
import packetracer.app.network.device.port.Connexion;
import packetracer.app.network.device.port.InterfaceAddressable;
import packetracer.app.network.protocol.arp.ARPTable;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class AbstractDevice implements Linkable {

	protected final String deviceCategory;
	protected final String name;
	protected final Map<AbstractInterface, Connexion> interfaces;
	protected final ARPTable arpTable;

	/**
	 * Create an AbstractDevice object
	 *
	 * @param deviceCategory Device category (Computer, Switch, Router...)
	 * @param name           The name of this device
	 * @param nbInterfaces   The number of interfaces of this device
	 */
	public AbstractDevice(String deviceCategory, String name, int nbInterfaces) {
		this.deviceCategory = deviceCategory;
		this.name = name;
		interfaces = new LinkedHashMap<>();
		arpTable = new ARPTable();
		init(nbInterfaces);
	}

	/**
	 * Create an AbstractDevice object
	 *
	 * @param deviceCategory Device category (Computer, Switch, Router...)
	 * @param name           The name of this device
	 * @param interfaces     A map of interfaces to assign to this device
	 */
	public AbstractDevice(String deviceCategory, String name, Map<AbstractInterface, Connexion> interfaces) {
		this.deviceCategory = deviceCategory;
		this.name = name;
		this.interfaces = interfaces;
		arpTable = new ARPTable();
	}

	/**
	 * Init the {@code interfaces} list attribute with a number of elements equal to
	 * {@code nbInterface} parameter
	 *
	 * @param nbInterface The number of interfaces of this device
	 */
	protected void init(int nbInterface) {
		for (int i = 0; i < nbInterface; i++) {
			interfaces.put(new InterfaceAddressable(i + 1), null);
		}
	}

	@Override
	public boolean connect(int idSrcInterface, AbstractDevice dstDevice, int idDstInterface) {
		final AbstractInterface key = interfaces.keySet().toArray(new AbstractInterface[0])[idSrcInterface - 1];
		final Connexion link = interfaces.get(key);
		if (key.isPortStatus() && link != null) {
			final AbstractInterface keyDst = dstDevice.interfaces.keySet()
					.toArray(new AbstractInterface[0])[idDstInterface - 1];
			dstDevice.interfaces.put(keyDst, new Connexion(key, this));
			interfaces.put(key, new Connexion(keyDst, dstDevice));
			return true;
		}
		return false;
	}

	public String getDeviceCategory() {
		return deviceCategory;
	}

	public String getName() {
		return name;
	}

	public Map<AbstractInterface, Connexion> getInterfaces() {
		return interfaces;
	}

	public ARPTable getARPTable() {
		return arpTable;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arpTable, interfaces, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractDevice) {
			final AbstractDevice other = (AbstractDevice) obj;
			return arpTable.equals(other.arpTable) && interfaces.equals(other.interfaces) && name.equals(other.name);
		}
		return false;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(deviceCategory + ": \"" + name + "\"");
		sb.append("\tInterfaces: " + interfaces.size());
		for (final Map.Entry<AbstractInterface, Connexion> map : interfaces.entrySet()) {
			sb.append("\n" + map.getKey().toString());
			final Connexion value = map.getValue();
			if (value != null) {
				sb.append("\t" + value.toString());
			} else {
				sb.append("\tNot connected");
			}
		}
		sb.append("\n" + arpTable.toString() + "\n");
		return sb.toString();
	}

}
