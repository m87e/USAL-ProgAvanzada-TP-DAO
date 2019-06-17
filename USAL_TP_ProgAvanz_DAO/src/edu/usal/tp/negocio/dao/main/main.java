package edu.usal.tp.negocio.dao.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Provincias;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.factory.ProvinciasFactory;
import edu.usal.tp.negocio.dao.factory.TelefonoFactory;
import edu.usal.tp.negocio.dao.interfaces.IProvinciasDAO;
import edu.usal.tp.negocio.dao.interfaces.ITelefonoDAO;
import edu.usal.tp.negocio.dao.util.IOGeneral;

public class main {

	public static void main(String[] args) throws IOException {

		System.out.println("Testing");
		System.out.println("1- Provincias");
		System.out.println("2- Telefono");

		int op = IOGeneral.leerInt("Opcion", "Error");

		switch (op) {
		case 1:
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

				for (Provincias prov : listado) {
					System.out.println(prov.getId() + " " + prov.getNombre());
				}

			} catch (Exception e) {
				System.out.println("El archivo no fue encontrado");
				e.printStackTrace();
			}
			break;

		case 2:
			// Testing Provincias
			Telefono tel = new Telefono();
			tel.setNumCelular("156797679");
			tel.setNumLaboral("54544");
			tel.setNumPersonal("564613218");

			ITelefonoDAO impTelDAO = TelefonoFactory.GetImplementation("Archivo");

			try {
				impTelDAO.AgregarTelefono(tel);
				tel.setNumCelular("1123");
				tel.setNumLaboral("12314");
				tel.setNumPersonal("123148");
				impTelDAO.AgregarTelefono(tel);

				List<Telefono> listado = impTelDAO.GetAll();

				for (Telefono tel1 : listado) {
					System.out.println(tel1.getNumCelular() + " " + tel1.getNumLaboral() + tel1.getNumPersonal());
				}

			} catch (Exception e) {
				System.out.println("El archivo no fue encontrado");
				e.printStackTrace();
			}

			break;

		case 3:
			// Testing Clientes
			Cliente cli1 = new Cliente();
			cli1.setNombre("Pedro");
			cli1.setApellido("Smith");
			cli1.setDni("859494854");
			cli1.setEmail("afdf@rfgerfg.com");

			// cli1.setTelefono("1", "4324234", "23423", "234234");

			break;

		default:
			break;
		}

	}

}
