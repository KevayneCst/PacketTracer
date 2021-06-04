package packetracer.app.core;

import packetracer.app.core.tool.Regex;

/**
 *
 * @author Kévin Constantin
 *
 */
public class InternetProtocolVersion4 extends AbstractAddress {

	public static final int BYTE_SIZE = 4;

	public InternetProtocolVersion4(String ipAddress) {
		super(ipAddress, BYTE_SIZE);
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
		return "@IP: " + address;
	}

}
