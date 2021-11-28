package google.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginGoogle extends Remote{
	public boolean comprobarContrasenya(String email, String contrasenya) throws RemoteException;
}
