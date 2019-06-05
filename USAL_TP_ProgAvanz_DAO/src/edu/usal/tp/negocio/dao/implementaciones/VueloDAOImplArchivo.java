package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Vuelos;
import edu.usal.tp.negocio.dao.interfaces.IVuelosDAO;

public class VueloDAOImplArchivo implements IVuelosDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarVuelo(Vuelos vuelos) throws IOException {
		// TODO Auto-generated method stub
		archivo = new File("/Users/juan/Desktop/vuelos.txt");

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveVuelos(vuelos);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveVuelos(Vuelos vuelos) {
		// TODO Auto-generated method stub
		return vuelos.getNumVuelo() + ";" + vuelos.getAeropuertoLlegada() + ";" + "\n";
	}

	@Override
	public void ModificarVuelo(Vuelos oldVuelo, Vuelos newVuelo) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarVuelo(Vuelos vuelos) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vuelos> GetAll() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
