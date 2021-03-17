package packetracer.app.network.device;

import java.util.ArrayList;
import java.util.List;

import packetracer.app.network.device.port.AbstractInterface;
import packetracer.app.network.device.port.InterfaceAddressable;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class AbstractDevice {

	private final String name;
	protected final List<AbstractInterface> interfaces;

	public AbstractDevice(String name, int nbInterfaces) {
		this.name = name;
		interfaces = new ArrayList<>();
		init(nbInterfaces);
	}

	public AbstractDevice(String name, List<AbstractInterface> interfaces) {
		this.name = name;
		this.interfaces = interfaces;
	}

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

}
