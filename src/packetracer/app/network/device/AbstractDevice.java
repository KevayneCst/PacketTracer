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

	protected List<AbstractInterface> interfaces;

	public AbstractDevice(int nbInterfaces) {
		interfaces = new ArrayList<>();
		init(nbInterfaces);
	}

	public AbstractDevice(List<AbstractInterface> interfaces) {
		this.interfaces = interfaces;
	}

	protected void init(int nbInterface) {
		for (int i = 0; i < nbInterface; i++) {
			interfaces.add(new InterfaceAddressable(i + 1));
		}
	}

	public List<AbstractInterface> getInterfaces() {
		return interfaces;
	}

}
