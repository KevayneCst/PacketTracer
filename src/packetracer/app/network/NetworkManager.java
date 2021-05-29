package packetracer.app.network;

public class NetworkManager {

	private final InternetProtocolVersion4 ipv4;
	private final Mask mask;

	public NetworkManager(InternetProtocolVersion4 ipv4, Mask mask) {
		this.ipv4 = ipv4;
		this.mask = mask;
	}

	public InternetProtocolVersion4 getIpv4() {
		return ipv4;
	}

	public Mask getMask() {
		return mask;
	}

	@Override
	public String toString() {
		return ipv4.address + "";
	}
}
