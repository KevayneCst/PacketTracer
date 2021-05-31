package packetracer.app.network.device;

public interface Linkable {

	/**
	 * Connect a device with another from interface
	 *
	 * @param idSrcInterface Interface of the source device
	 * @param dstDevice      Device that we should connect
	 * @param idDstInterface Interface of the destination device
	 * @return
	 */
	boolean connect(int idSrcInterface, AbstractDevice dstDevice, int idDstInterface);
}
