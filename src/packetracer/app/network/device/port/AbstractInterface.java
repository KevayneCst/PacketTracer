package packetracer.app.network.device.port;

/**
 *
 * @author Kévin Constantin
 *
 */
public abstract class AbstractInterface {

	private int id;
	private boolean portStatus;
	private Connexion connexion;

	public AbstractInterface(int id) {
		this.id = id;
		portStatus = true;
		connexion = null;
	}

	public AbstractInterface(int id, boolean portStatus, Connexion connexion) {
		this.id = id;
		this.portStatus = portStatus;
		this.connexion = connexion;
	}

	public boolean isConnected() {
		return connexion == null;
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

	public String fullName() {
		return "Fa0/" + id;
	}

}
