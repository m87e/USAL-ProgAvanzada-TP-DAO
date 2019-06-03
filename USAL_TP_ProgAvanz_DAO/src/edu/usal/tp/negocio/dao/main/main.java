package edu.usal.tp.negocio.dao.main;

import java.io.IOException;

import edu.usal.tp.negocio.dao.dominio.Provincias;
import edu.usal.tp.negocio.dao.factory.ProvinciasFactory;
import edu.usal.tp.negocio.dao.interfaces.IProvinciasDAO;

public class main {

	public static void main(String[] args) throws IOException {
	// Testing Provincias
		
		Provincias provincia = null;
		
		IProvinciasDAO IProvinciaDAO;
		IProvinciaDAO = ProvinciasFactory.GetImplementation("Archivo");
		
		IProvinciaDAO.AgregarProvincia(provincia);
		
		
		
}

}
