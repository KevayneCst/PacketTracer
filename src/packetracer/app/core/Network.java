package packetracer.app.core;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Network {

	private final InternetProtocolVersion4 networkIP;

	public Network(InternetProtocolVersion4 networkIP) {
		this.networkIP = networkIP;
	}

	public InternetProtocolVersion4 getNetworkIP() {
		return networkIP;
	}

}
