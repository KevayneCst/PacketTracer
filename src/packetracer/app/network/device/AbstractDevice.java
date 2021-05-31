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

	private final String name;
	protected final Map<AbstractInterface, Connexion> interfaces;
	protected final ARPTable arpTable;

	/**
	 * Create an AbstractDevice object
	 *
	 * @param name         The name of this device
	 * @param nbInterfaces The number of interfaces of this device
	 */
	public AbstractDevice(String name, int nbInterfaces) {
		this.name = name;
		interfaces = new LinkedHashMap<>();
		arpTable = new ARPTable();
		init(nbInterfaces);
	}

	/**
	 * Create an AbstractDevice object
	 *
	 * @param name       The name of this device
	 * @param interfaces A map of interfaces to assign to this device
	 */
	public AbstractDevice(String name, Map<AbstractInterface, Connexion> interfaces) {
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

}
