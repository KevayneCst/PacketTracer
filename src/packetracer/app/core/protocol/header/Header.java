package packetracer.app.core.protocol.header;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class Header {

	protected int byteSizeHeader;

	public Header(int byteSizeHeader) {
		this.byteSizeHeader = byteSizeHeader;
	}

	public int getByteSizeHeader() {
		return byteSizeHeader;
	}

}
