package packetracer.app.network;

import packetracer.app.data.Regex;

/**
 *
 *
 * @author Kévin Constantin
 *
 */
public class Mask extends AbstractAddress {

	public Mask(String mask) {
		super(mask);
	}

	@Override
	protected String regex() {
		return Regex.IP_REGEX;
	}

	@Override
	protected String errorMessage(String arg) {
		return "Mask is not well formed : \"" + arg + "\"";
	}

	@Override
	public String toString() {
		return "Mask :" + address;
	}
}
