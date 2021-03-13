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

	public static MediaAccessControl generateMACAddress() {
		String idToHex = Integer.toString(id++, 16);
		StringBuilder completed = new StringBuilder(("000000" + idToHex).substring(idToHex.length()));
		for (int i = 0, inc = 0; i < 3; i++, inc += 2) {
			completed.insert(i + inc, ':');
		}
		return new MediaAccessControl(OUI + completed.toString());
	}
}
