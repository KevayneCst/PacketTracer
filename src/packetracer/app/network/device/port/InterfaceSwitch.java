package packetracer.app.network.device.port;

import packetracer.app.network.VirtualLocalAreaNetwork;

/**
 *
 * @author Kévin Constantin
 *
 */
public class InterfaceSwitch extends AbstractInterface {

	private VirtualLocalAreaNetwork vlan;
	private Mode mode;

	public InterfaceSwitch(int id, VirtualLocalAreaNetwork vlan) {
		super(id);
		this.vlan = vlan;
		mode = Mode.ACCESS;
	}

	public InterfaceSwitch(int id, Connexion connexion, VirtualLocalAreaNetwork vlan, Mode mode) {
		super(id, connexion);
		this.vlan = vlan;
		this.mode = mode;
	}

	public VirtualLocalAreaNetwork getVlan() {
		return vlan;
	}

	public Mode getMode() {
		return mode;
	}

	public enum Mode {
		ACCESS, TRUNK;

		@Override
		public String toString() {
			return "Mode: " + name();
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + vlan.toString() + "\t" + mode.toString();
	}
}
