package packetracer.app.network;

import java.util.Objects;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Gateway {

	private final InternetProtocolVersion4 defaultGateway;

	public Gateway(InternetProtocolVersion4 defaultGateway) {
		this.defaultGateway = defaultGateway;
	}

	public InternetProtocolVersion4 getDefaultGateway() {
		return defaultGateway;
	}

	@Override
	public int hashCode() {
		return Objects.hash(defaultGateway);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Gateway) {
			final Gateway other = (Gateway) obj;
			return defaultGateway.equals(other.defaultGateway);
		}
		return false;
	}

	@Override
	public String toString() {
		return "@IPGateway: " + defaultGateway.getAddress();
	}

}
