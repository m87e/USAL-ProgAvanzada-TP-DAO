package edu.usal.tp.negocio.dao.main;

import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Provincias;
import edu.usal.tp.negocio.dao.factory.ProvinciasFactory;
import edu.usal.tp.negocio.dao.interfaces.IProvinciasDAO;

public class main {

	public static void main(String[] args) throws IOException {
	// Testing Provincias
		
		Provincias provincia1 = new Provincias();
		provincia1.setId("BAS");
		provincia1.setNombre("Buenos Aires");
		
		IProvinciasDAO impProvDAO = ProvinciasFactory.GetImplementation("Archivo");
		
	 	try {
	 		impProvDAO.AgregarProvincia(provincia1);
	 		provincia1.setId("TUC");
	 		provincia1.setNombre("Tucuman");
	 		impProvDAO.AgregarProvincia(provincia1);
	 		
	 		List<Provincias> listado = impProvDAO.GetAll();

			  for (Provincias prov : listado) { System.out.println(prov.getId() + " " + prov.getNombre()); }
			  
		}catch (Exception e) {
			System.out.println("El archivo no fue encontrado");
			e.printStackTrace();
		}


		 

}

}
