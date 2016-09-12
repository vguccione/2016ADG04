import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG94.bean.Cliente.DTO_Cliente;

public class TestClient {

	public static void main(String[] args) {
		
		TestBusinesDelegate();

	}

	public static void TestBusinesDelegate(){
		
		try {
			
			BusinessDelegate bDelegate = new BusinessDelegate();
			
			System.out.println("Test get Cliente:");
			DTO_Cliente cliente;
			
			cliente = bDelegate.getClienteByCuit("23324372644");
			System.out.println(cliente.getCuit());
			System.out.println(cliente.getRazonSocial());
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
