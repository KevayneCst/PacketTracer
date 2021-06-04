package packetracer.app.core.device.port;

import java.util.Objects;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class AbstractInterface {

	private final int id;
	private boolean portStatus;

	public AbstractInterface(int id) {
		this.id = id;
		portStatus = true;
	}

	public void switchPortStatus() {
		portStatus = !portStatus;
	}

	public int getId() {
		return id;
	}

	public boolean isPortStatus() {
		return portStatus;
	}

	public String shortName() {
		return "Fa0/" + id;
	}

	public String fullName() {
		return "FastEthernet0/" + id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, portStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractInterface) {
			final AbstractInterface other = (AbstractInterface) obj;
			return id == other.id && portStatus == other.portStatus;
		}
		return false;
	}

	@Override
	public String toString() {
		final String status = "\tPort: " + (portStatus ? "ENABLE" : "DISABLE");
		return fullName() + status;
	}

}
