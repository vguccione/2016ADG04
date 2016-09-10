import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG94.bean.ClienteDTO;


public class Test {

	public static void main(String[] args) {
		// 
		try 
		{
			BusinessDelegate bDelegate = new BusinessDelegate();
			
			System.out.print("Test get Cliente:");
			ClienteDTO cliente = bDelegate.getCliente("23324372644");
			System.out.print(cliente.getCuit());
			System.out.print(cliente.getRazonSocial());
			System.out.print("Test finished...");
		} 
		catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}

}
