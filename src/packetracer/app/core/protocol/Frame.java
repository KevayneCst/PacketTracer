package packetracer.app.core.protocol;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class Frame {

	protected final int minByteSizeFrame;
	protected final int maxByteSizeFrame;
	protected int byteSizeFrame;

	public Frame(int byteSizeFrame, int minByteSizeFrame, int maxByteSizeFrame) {
		this.minByteSizeFrame = minByteSizeFrame;
		this.maxByteSizeFrame = maxByteSizeFrame;
		this.byteSizeFrame = byteSizeFrame;
	}

	public int getMinByteSizeFrame() {
		return minByteSizeFrame;
	}

	public int getMaxByteSizeFrame() {
		return maxByteSizeFrame;
	}

	public int getByteSizeFrame() {
		return byteSizeFrame;
	}
}
