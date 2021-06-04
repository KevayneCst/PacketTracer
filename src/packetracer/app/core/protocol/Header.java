package packetracer.app.core.protocol;

public abstract class Header {

	protected int byteSizeHeader;

	public Header(int actualByteSizeHeader, int neededByteSizeHeader) {
		byteSizeHeader = neededByteSizeHeader;
		assertCorrectByteSize(actualByteSizeHeader);
	}

	private void assertCorrectByteSize(int actualByteSizeHeader) {
		if (actualByteSizeHeader != byteSizeHeader) {
			String errorMsg = "Header is not well formed, the size in bytes ";
			errorMsg += actualByteSizeHeader > byteSizeHeader ? "exceeds the excepted size"
					: "is too small compared to what is excepted";
			errorMsg += " (got:" + actualByteSizeHeader + " ; excepted:" + byteSizeHeader + ")";
			throw new IllegalArgumentException(errorMsg);
		}
	}
}
