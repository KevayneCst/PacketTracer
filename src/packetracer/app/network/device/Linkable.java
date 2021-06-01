package packetracer.app.network.device;

public interface Linkable {

	/**
	 * Link a device with another from interface
	 *
	 * @param idSrcInterface Interface of the source device
	 * @param dstDevice      Device that we should link
	 * @param idDstInterface Interface of the destination device
	 * @return
	 */
	boolean link(int idSrcInterface, AbstractDevice dstDevice, int idDstInterface);

	/**
	 * Verify if the {@code toTest} device is linked to the current device
	 *
	 * @param toTest Device that we want to know if he is linked to our device
	 * @return
	 */
	boolean isLinked(AbstractDevice toTest);
}
