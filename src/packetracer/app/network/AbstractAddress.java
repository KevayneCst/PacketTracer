package packetracer.app.network;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class AbstractAddress {

	protected String address;

	protected AbstractAddress(String address) {
		init(address);
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

	@Override
	public String toString() {
		return "Abstract address : " + address;
	}
}
