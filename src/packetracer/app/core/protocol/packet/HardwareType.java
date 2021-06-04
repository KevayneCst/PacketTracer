package packetracer.app.core.protocol.packet;

public enum HardwareType {
	ETHERNET(0x0001);

	public static final int BYTE_SIZE = 2;
	private final int value;

	HardwareType(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

}
