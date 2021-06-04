package packetracer.app.core.tool;

/**
 *
 * @author Kévin Constantin
 *
 */
public class Regex {

	private Regex() {
	}

	public static final String MAC_REGEX = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
	public static final String IP_REGEX = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
}
