package packetracer.app.core.protocol;

public abstract class Frame {

	protected final int minByteSizeFrame;
	protected final int maxByteSizeFrame;
	protected int byteSizeFrame;

	public Frame(int actualByteSizeFrame, int minByteSizeFrame, int maxByteSizeFrame) {
		this.minByteSizeFrame = minByteSizeFrame;
		this.maxByteSizeFrame = maxByteSizeFrame;
		assertCorrectFrameSize(actualByteSizeFrame);
	}

	private void assertCorrectFrameSize(int actualByteSizeFrame) {
		if (actualByteSizeFrame < minByteSizeFrame || actualByteSizeFrame > maxByteSizeFrame) {
			final String msgRange = "[" + minByteSizeFrame + ";" + maxByteSizeFrame + "] bytes ";
			final String msgGot = "(got:" + actualByteSizeFrame + ")";
			throw new IllegalArgumentException(
					"Frame is not well formed, size in bytes doesn't fit between " + msgRange + msgGot);
		}
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
