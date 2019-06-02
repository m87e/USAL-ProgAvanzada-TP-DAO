package edu.usal.tp.negocio.dao.implementaciones;

import java.io.*;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Paises;
import edu.usal.tp.negocio.dao.interfaces.IPaisesDAO;

public class PaisesDAOImplArchivo implements IPaisesDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarPais(Paises pais) throws IOException {
		// TODO Auto-generated method stub

		archivo = new File("/Users/juan/Desktop/paises.txt");
		archivoWriter = new FileWriter(archivo);
		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SavePais(pais);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SavePais(Paises pais) {
		return pais.getId() + ";" + pais.getNombre() + "\n";

	}

	@Override
	public void ModificarPais(Paises oldPais, Paises newPais) throws IOException {
		// TODO Auto-generated method stub

		List<Paises> listadoPaises = GetAll();

		String nLinea;

		for (Paises p : listadoPaises) {

			if (p.getId() == oldPais.getId()) {
				p.setId(newPais.getId());
				p.setNombre(newPais.getNombre());
			}

		}

	}

	@Override
	public void EliminarPais(Paises pais) throws IOException {
		// TODO Auto-generated method stub

		List<Paises> listadoPaises = GetAll();

		String nLinea;

		for (Paises p : listadoPaises) {

			if (p.getId() == pais.getId()) {
				p.setId(null);
				p.setNombre(null);
			}

		}

	}

	@Override
	public List<Paises> GetAll() throws IOException {
		// TODO Auto-generated method stub
		archivo = new File("/Users/juan/Desktop/paises.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Paises> listadoPaises = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoPaises.add(ParsePais(linea));
		}

		return listadoPaises;

	}

	private Paises ParsePais(String linea) {

		String[] atributos = linea.split(";");

		Paises pais = new Paises();
		pais.setId(atributos[0]);
		pais.setNombre(atributos[1]);

		return pais;

	}

}
