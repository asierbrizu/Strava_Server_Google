package google.remote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class LoginGoogleService extends UnicastRemoteObject implements ILoginGoogle {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> cuentas=new HashMap<>();
	
	
	//Attribute for the Singleton pattern
	public static LoginGoogleService instance;
			
	private LoginGoogleService() throws RemoteException {
		super();
		cuentas.put("david", "zapatilla");
		cuentas.put("asier", "calcetines");
	}
	
	public static LoginGoogleService getInstance() {
		if (instance == null) {
			try {
				instance = new LoginGoogleService();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}
	public boolean comprobarContrasenya(String email, String contrasenya) throws RemoteException {
		return (cuentas.containsKey(email)&&cuentas.get(email).equals(contrasenya));
	}
}