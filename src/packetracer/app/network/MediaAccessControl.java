package packetracer.app.network;

import packetracer.app.tool.Regex;

/**
 *
 *
 * @author Kévin Constantin
 *
 */
public class MediaAccessControl extends AbstractAddress {

	public MediaAccessControl(String macAddress) {
		super(macAddress.toUpperCase());
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
