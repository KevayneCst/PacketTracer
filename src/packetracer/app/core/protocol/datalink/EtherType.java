package packetracer.app.core.protocol.datalink;

public enum EtherType {
	IPV4(0x0800), ARP(0x0806), VLAN(0x8100);

	public static final int BYTE_SIZE = 2;
	private final int value;

	EtherType(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}
}
