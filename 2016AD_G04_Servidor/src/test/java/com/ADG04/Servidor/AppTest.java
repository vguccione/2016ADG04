package com.ADG04.Servidor;

import java.util.List;

import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.Vehiculo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public static void main (String[] args){
    	/*List<Vehiculo> vehiculos = VehiculoDao.getInstancia().listarVehiculosDisponibles(1, 100f, 200f);
    	
    	for(Vehiculo v : vehiculos){
    		System.out.println(v.toString());
    	}*/
    }
}
