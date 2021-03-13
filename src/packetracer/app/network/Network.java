package packetracer.app.network;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Network {

	private InternetProtocolVersion4 networkIP;

	public Network(InternetProtocolVersion4 networkIP) {
		this.networkIP = networkIP;
	}

	public InternetProtocolVersion4 getNetworkIP() {
		return networkIP;
	}

}
