package packetracer.app.core;

import java.util.Objects;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class AbstractAddress {

	protected String address;
	protected int byteSizeAddress;

	protected AbstractAddress(String address, int byteSizeAddress) {
		init(address);
		this.byteSizeAddress = byteSizeAddress;
	}

	private void init(String address) {
		if (!addressWellFormed(address)) {
			throw new IllegalArgumentException(errorMessage(address));
		}
		this.address = address;
	}

	private boolean addressWellFormed(String toCheck) {
		return toCheck.matches(regex());
	}

	protected abstract String regex();

	protected abstract String errorMessage(String arg);

	public String getAddress() {
		return address;
	}

	public int getByteSizeAddress() {
		return byteSizeAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, byteSizeAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractAddress) {
			final AbstractAddress other = (AbstractAddress) obj;
			return Objects.equals(address, other.address) && byteSizeAddress == other.byteSizeAddress;
		}
		return false;
	}

	@Override
	public String toString() {
		final String byteMsg = byteSizeAddress + (byteSizeAddress == 1 ? "byte" : "bytes");
		return "Abstract address : " + address + " encoded on " + byteMsg;
	}
}
