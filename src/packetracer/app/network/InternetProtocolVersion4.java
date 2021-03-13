package packetracer.app.network;

import packetracer.app.data.Regex;

/**
 *
 *
 * @author Kévin Constantin
 *
 */
public class InternetProtocolVersion4 extends AbstractAddress {

	public InternetProtocolVersion4(String ipAddress) {
		super(ipAddress);
	}

	@Override
	protected String regex() {
		return Regex.IP_REGEX;
	}

	@Override
	protected String errorMessage(String arg) {
		return "IP Address is not well formed : \"" + arg + "\"";
	}

	@Override
	public String toString() {
		return "@IP :" + address;
	}

}
