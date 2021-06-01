package packetracer.app.network.device.port;

import java.util.Objects;

import packetracer.app.network.VirtualLocalAreaNetwork;

/**
 *
 * @author Kévin Constantin
 *
 */
public class InterfaceSwitch extends AbstractInterface {

	private final VirtualLocalAreaNetwork vlan;
	private final Mode mode;

	public InterfaceSwitch(int id, VirtualLocalAreaNetwork vlan) {
		super(id);
		this.vlan = vlan;
		mode = Mode.ACCESS;
	}

	public InterfaceSwitch(int id, VirtualLocalAreaNetwork vlan, Mode mode) {
		super(id);
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(mode, vlan);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof InterfaceSwitch) {
			final InterfaceSwitch other = (InterfaceSwitch) obj;
			return mode == other.mode && Objects.equals(vlan, other.vlan) && super.equals(other);
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + vlan.toString() + "\t" + mode.toString();
	}
}
