package packetracer.app.core.protocol.packet;

public enum OpCode {

	ARP_REQUEST(0x0001), ARP_REPLY(0x0002);

	public static final int BYTE_SIZE = 2;
	private final int value;

	OpCode(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

}
