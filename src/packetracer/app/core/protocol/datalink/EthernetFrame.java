package packetracer.app.core.protocol.datalink;

import packetracer.app.core.protocol.Frame;
import packetracer.app.core.protocol.MACHeader;

/**
 *
 * @author Kévin Constantin
 *
 */
public class EthernetFrame extends Frame {

	public static final int BYTE_SIZE_MIN = 64;
	public static final int BYTE_SIZE_MAX = 1518;

	protected MACHeader macHeader;

	public EthernetFrame(int byteSizeFrame) {
		super(byteSizeFrame, BYTE_SIZE_MIN, BYTE_SIZE_MAX);
	}

}
