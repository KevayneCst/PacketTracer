package packetracer.app.network.protocol.arp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Kévin Constantin
 *
 */
public class ARPTable {

	private static final long EXPIRATION_ENTRY = 240 * (long) 60000;
	private final Map<ARPTableEntry, Long> entries;

	/**
	 * Create an ARPTable object whose internal table is empty
	 */
	public ARPTable() {
		entries = new HashMap<>();
	}

	/**
	 * Check for each entry in {@code entries} if the duration storage is not
	 * greater than {@code EXPIRATION_ENTRY}, if this the case, then the entry is
	 * deleted from {@code entries}
	 */
	private void updateEntries() {
		final Iterator<Map.Entry<ARPTableEntry, Long>> it = entries.entrySet().iterator();
		while (it.hasNext()) {
			if (System.currentTimeMillis() - it.next().getValue() >= EXPIRATION_ENTRY) {
				it.remove();
			}
		}
	}

	/**
	 * Add an entry into the table
	 *
	 * @param entry
	 */
	public void addEntry(ARPTableEntry entry) {
		entries.put(entry, System.currentTimeMillis());
		updateEntries();
	}

	/**
	 * Clear all the table data
	 */
	public void resetARPTable() {
		entries.clear();
	}

	/**
	 * Get the last valid entries of the table
	 *
	 * @return A map of the entries whose storage time in the table is below the
	 *         expiry time
	 */
	public Map<ARPTableEntry, Long> getEntries() {
		updateEntries();
		return entries;
	}

	@Override
	public int hashCode() {
		return Objects.hash(entries);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ARPTable) {
			final ARPTable other = (ARPTable) obj;
			return entries.equals(other.entries);
		}
		return false;
	}

}
