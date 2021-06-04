package packetracer.app.core;

import packetracer.app.core.tool.Regex;

/**
 *
 *
 * @author Kévin Constantin
 *
 */
public class MediaAccessControl extends AbstractAddress {

	public static final int BYTE_SIZE = 6;
	public static final MediaAccessControl BROADCAST = new MediaAccessControl("FF:FF:FF:FF:FF:FF");

	public MediaAccessControl(String macAddress) {
		super(macAddress.toUpperCase(), BYTE_SIZE);
	}

	@Override
	protected String regex() {
		return Regex.MAC_REGEX;
	}

	@Override
	protected String errorMessage(String arg) {
		return "MAC Address is not well formed : \"" + arg + "\"";
	}

	@Override
	public String toString() {
		return "@MAC: " + address;
	}
}
