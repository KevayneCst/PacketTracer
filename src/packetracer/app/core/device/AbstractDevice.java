package packetracer.app.core.device;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import packetracer.app.core.device.network.ARPTable;
import packetracer.app.core.device.port.AbstractInterface;
import packetracer.app.core.device.port.Connexion;
import packetracer.app.core.device.port.InterfaceAddressable;

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
	public final boolean link(int idSrcInterface, AbstractDevice dstDevice, int idDstInterface) {
		final AbstractInterface key = interfaces.keySet().toArray(new AbstractInterface[0])[idSrcInterface - 1];
		final Connexion link = interfaces.get(key);
		if (key.isPortStatus() && link == null) {
			final AbstractInterface keyDst = dstDevice.interfaces.keySet()
					.toArray(new AbstractInterface[0])[idDstInterface - 1];
			dstDevice.interfaces.put(keyDst, new Connexion(key, this));
			interfaces.put(key, new Connexion(keyDst, dstDevice));
			return true;
		}
		return false;
	}

	@Override
	public final boolean isLinked(AbstractDevice toTest) {
		final Iterator<Map.Entry<AbstractInterface, Connexion>> it = interfaces.entrySet().iterator();
		while (it.hasNext()) {
			final Connexion value = it.next().getValue();
			if (value != null && value.getConnectedDevice().equals(toTest)) {
				return true;
			}
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
		return Objects.hash(arpTable, interfaces, name, deviceCategory);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractDevice) {
			final AbstractDevice other = (AbstractDevice) obj;
			return Objects.equals(arpTable, other.arpTable) && Objects.equals(interfaces, other.interfaces)
					&& Objects.equals(name, other.name) && Objects.equals(deviceCategory, other.deviceCategory);
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
