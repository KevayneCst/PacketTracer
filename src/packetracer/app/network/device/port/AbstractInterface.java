package packetracer.app.network.device.port;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class AbstractInterface {

	private final int id;
	private boolean portStatus;
	private final Connexion connexion;

	public AbstractInterface(int id) {
		this.id = id;
		portStatus = true;
		connexion = null;
	}

	public AbstractInterface(int id, Connexion connexion) {
		this.id = id;
		portStatus = true;
		this.connexion = connexion;
	}

	public void switchPortStatus() {
		portStatus = !portStatus;
	}

	public boolean isConnected() {
		return connexion != null;
	}

	public int getId() {
		return id;
	}

	public boolean isPortStatus() {
		return portStatus;
	}

	public Connexion getConnexion() {
		return connexion;
	}

	public String shortName() {
		return "Fa0/" + id;
	}

	public String fullName() {
		return "FastEthernet0/" + id;
	}

	@Override
	public String toString() {
		final String status = "\tPort: " + (portStatus ? "ENABLE" : "DISABLE");
		final String connected = "\t" + (isConnected() ? connexion.toString() : "Not connected");
		return fullName() + status + connected;
	}

}
