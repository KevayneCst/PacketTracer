package packetracer.app.core.protocol.frame;

import packetracer.app.core.protocol.FrameCheckSequence;
import packetracer.app.core.protocol.header.MACHeader;
import packetracer.app.core.protocol.packet.Packet;

/**
 *
 * @author Kévin Constantin
 *
 */
public class EthernetFrame extends Frame {

	public static final int BYTE_SIZE_MIN = 64;
	public static final int BYTE_SIZE_MAX = 1518;

	protected MACHeader macHeader;
	protected Packet data;
	protected FrameCheckSequence crcChecksum;

	public EthernetFrame(int byteSizeFrame) {
		super(byteSizeFrame, BYTE_SIZE_MIN, BYTE_SIZE_MAX);
	}

}
