package packetracer.app.core.protocol;

import packetracer.app.core.MediaAccessControl;
import packetracer.app.core.protocol.datalink.EtherType;

public class MACHeader extends Header {

	public static final int BYTE_SIZE = 14;
	private final MediaAccessControl destination;
	private final MediaAccessControl source;
	private final EtherType ethertype;

	public MACHeader(MediaAccessControl destination, MediaAccessControl source, EtherType ethertype) {
		super(MediaAccessControl.BYTE_SIZE * 2 + EtherType.BYTE_SIZE, BYTE_SIZE);
		this.destination = destination;
		this.source = source;
		this.ethertype = ethertype;
	}

	public MediaAccessControl getDestination() {
		return destination;
	}

	public MediaAccessControl getSource() {
		return source;
	}

	public EtherType getEthertype() {
		return ethertype;
	}
}
