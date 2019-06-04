package edu.usal.tp.negocio.dao.implementaciones;

import java.io.*;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.interfaces.IAerolineaDAO;

public class AerolineaDAOImplArchivo implements IAerolineaDAO {
 
	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarAerolinea(Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub
		archivo = new File("/Users/juan/Desktop/aerolineas.txt");
		archivoWriter = new FileWriter(archivo);
		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveAerolinea(aerolinea);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveAerolinea(Aerolinea aerolinea) {
		// TODO Auto-generated method stub
		return aerolinea.getId() + ";" + aerolinea.getNombre() + ";" + aerolinea.getAlianza() + "\n";
	}

	@Override
	public void ModificarAerolinea(Aerolinea oldAerolinea, Aerolinea newAerolinea) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarAerolinea(Aerolinea pais) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Aerolinea> GetAll() throws IOException {
		// TODO Auto-generated method stub

		archivo = new File("/Users/juan/Desktop/aerolineas.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;

		List<Aerolinea> listadoAerolineas = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoAerolineas.add(parseAerolinea(linea));
		}

		return null;

	}

	private Aerolinea parseAerolinea(String linea) {

		String[] atributos = linea.split(";");

		Aerolinea aerolinea = new Aerolinea();
		aerolinea.setId(atributos[0]);
		aerolinea.setNombre(atributos[1]);
		aerolinea.setAlianza(atributos[2]);

		return aerolinea;
	}

}
