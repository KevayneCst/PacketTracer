package packetracer.app.core;

import packetracer.app.core.tool.Regex;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Mask extends AbstractAddress {

	public static final int BYTE_SIZE = 4;

	public Mask(String mask) {
		super(mask, BYTE_SIZE);
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
		return "Mask: " + address;
	}
}
