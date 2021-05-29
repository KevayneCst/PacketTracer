package packetracer.app.network.device;

import java.util.ArrayList;
import java.util.List;

import packetracer.app.network.device.port.AbstractInterface;
import packetracer.app.network.device.port.InterfaceAddressable;
import packetracer.app.network.protocol.arp.ARPTable;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class AbstractDevice {

	private final String name;
	protected final List<AbstractInterface> interfaces;
	protected final ARPTable arpTable;

	/**
	 * Create an AbstractDevice object
	 *
	 * @param name         The name of this device
	 * @param nbInterfaces The number of interfaces of this device
	 */
	public AbstractDevice(String name, int nbInterfaces) {
		this.name = name;
		interfaces = new ArrayList<>();
		arpTable = new ARPTable();
		init(nbInterfaces);
	}

	/**
	 * Create an AbstractDevice object
	 *
	 * @param name       The name of this device
	 * @param interfaces A list of interfaces to assign to this device
	 */
	public AbstractDevice(String name, List<AbstractInterface> interfaces) {
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
			interfaces.add(new InterfaceAddressable(i + 1));
		}
	}

	public String getName() {
		return name;
	}

	public List<AbstractInterface> getInterfaces() {
		return interfaces;
	}

	public ARPTable getARPTable() {
		return arpTable;
	}

}
