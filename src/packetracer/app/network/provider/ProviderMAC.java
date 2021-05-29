package packetracer.app.network.provider;

import packetracer.app.network.MediaAccessControl;

/**
 * Class that will offer a unique MAC Address
 *
 * @author Kévin Constantin
 *
 */
public class ProviderMAC {

	private static final String OUI = "FF:FF:0A";
	private static int id = 0;

	private ProviderMAC() {
	}

	/**
	 * Generate a unique MAC Address where the first 3 bytes are equals to
	 * {@code OUI} final attribute, and where the last 3 bytes are equal to
	 * {@code id} attribute who is incremented after each call of this function
	 *
	 * @return
	 */
	public static MediaAccessControl generateMACAddress() {
		final String idToHex = Integer.toString(id++, 16);
		final StringBuilder completed = new StringBuilder(("000000" + idToHex).substring(idToHex.length()));
		for (int i = 0, inc = 0; i < 3; i++, inc += 2) {
			completed.insert(i + inc, ':');
		}
		return new MediaAccessControl(OUI + completed.toString());
	}
}
