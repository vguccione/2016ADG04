import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG94.bean.Administracion.DTO_Usuario;
import com.ADG94.bean.Cliente.DTO_ClienteParticular;

public class TestClient {

	public static void main(String[] args) {
		
		TestBusinesDelegate();

	}

	public static void TestBusinesDelegate(){
		
		try {
			
			BusinessDelegate bDelegate = new BusinessDelegate();
			
			System.out.println("Test get Cliente:");
			DTO_ClienteParticular cliente;
			
			cliente = bDelegate.getClienteParticularByDni("1234578");
			System.out.println(cliente.getDni());
			System.out.println(cliente.getNombre());
			System.out.println(cliente.getApellido());
			System.out.print("Test finished...");
			
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println();
			
			System.out.println("Test get Usuario:");
			DTO_Usuario usuario;
			
			usuario = bDelegate.getUsuario("32437264");
			System.out.println(usuario.getDni());
			System.out.println(usuario.getNombre());
			System.out.println(usuario.getApellido());
			System.out.print("Test finished...");
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
