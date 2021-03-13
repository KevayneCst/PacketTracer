package packetracer.app.network;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Gateway {

	private InternetProtocolVersion4 defaultGateway;

	public Gateway(InternetProtocolVersion4 defaultGateway) {
		this.defaultGateway = defaultGateway;
	}

	public InternetProtocolVersion4 getDefaultGateway() {
		return defaultGateway;
	}

}
