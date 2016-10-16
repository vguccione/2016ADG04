import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Scanner;

import com.ADG04.Repositorio.bussinessDelegate.BusinessDelegate;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;

public class TestClient {

	public static void main(String[] args) throws IOException {
		
		AltaEncomiendaParticular();
		System.out.println("Para finalizar escriba Exit, si no escriba Continuar.");
		
		while(getStringFromConsole("") != "Continuar"){
			
			AltaEncomiendaParticular();
		}
		
		//AltaEncomiendaParticular();
		//TestBusinesDelegate();

	}


	private static String getStringFromConsole(String msg) throws IOException{
		System.out.print(msg);
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		String line = buffer.readLine();
		return line;
	}
	
	private static float getFloatFromConsole(String msg) throws IOException{
		System.out.print(msg);
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		float line = Float.parseFloat(buffer.readLine());
		return line;
	}
	
	private static int getIntFromConsole(String msg) throws IOException{
		System.out.print(msg);
		BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(buffer.readLine());
		return line;
	}
	
	private static void AltaEncomiendaParticular() throws IOException{

		System.out.println("------------Test AltaEncomiendaParticular --------------------------");
		
		try {
			
			System.out.print("Dni Cliente: ");
			BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
			String dniCliente = buffer.readLine();
			
			System.out.print("Sucursal de origen: ");
			buffer=new BufferedReader(new InputStreamReader(System.in));
			int idSucOrigen = Integer.parseInt(buffer.readLine());
			
			System.out.print("Sucursal de destino: ");
			buffer=new BufferedReader(new InputStreamReader(System.in));
			int idSucDestino = Integer.parseInt(buffer.readLine());
					
			float largo = getFloatFromConsole("Largo: ");
			float ancho = getFloatFromConsole("Ancho: ");
			float alto = getFloatFromConsole("Alto: ");
			float peso = getFloatFromConsole("Peso: ");
			float volumen = getFloatFromConsole("Volumen: ");
			
			//(1,2,1,100,100f,430f,100f,0f,0);

			BusinessDelegate bDelegate = new BusinessDelegate();
			System.out.println("Nueva encomienda particular");
			int idEncomienda = bDelegate.nuevaEncomiedaParticular(dniCliente, 1, 2, idSucOrigen, idSucDestino, largo, ancho, alto, peso, volumen, 
					"", false, (short) 0, false, "", "", "", "", "", "", 0f, "");
			
			System.out.println("----------Encomienda: "+idEncomienda+"--------------------------------");
			Integer idenvio = bDelegate.gestionarEnvioEncomienda(idEncomienda);			
			if(idenvio != null){
				System.out.println("----------La encomienda no se pudo asignar a un envío--------------------------------");
			}
			else
			{
				System.out.println("----------La encomienda saldrá por el envío: "+ idenvio + "--------------------------------");
				System.out.println("Info del envío: ");
				DTO_EnvioPropio envio = bDelegate.getInfoEnvioPropio(idenvio);
				System.out.println("Vehiculo: "+envio.getIdVehiculo());
				System.out.println("Estado envío: "+envio.getEstado());
				
				System.out.println(envio.toString());
			}
			//System.out.println("Encomienda con 70% del peso del vehiculo 1 que esta disponible");
			/*System.out.println("Peso del Vehiculo: " + (envio.get().getPeso() - envio.getVehiculo().getTara()));
			System.out.println("Peso de la encomienda: " + enc.getPeso());
			System.out.println("Envio creado para vehiculo "+ envio.getVehiculo().getIdVehiculo());
			System.out.println("sucursal origen:  "+ envio.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio.getSucursalDestino().getDescripcion());
			System.out.println("estado envio:  "+ envio.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc.getEstado());
			System.out.println(envio.toString());
			System.out.println("------------------------------------");
			System.out.println();*/
			
			System.out.println();
					
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

		System.out.println("------------Fin Test AltaEncomiendaParticular --------------------------");
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
