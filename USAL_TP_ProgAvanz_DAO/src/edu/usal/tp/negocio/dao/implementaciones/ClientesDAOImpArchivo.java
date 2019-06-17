package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.interfaces.IClienteDAO;

public class ClientesDAOImpArchivo implements IClienteDAO {

	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

	@Override
	public void AgregarCliente(Cliente cliente) throws IOException {
		archivo = new File("C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//cliente.txt");

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveCliente(cliente);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

	}

	private String SaveCliente(Cliente cliente) {
		return cliente.getId() + ";" + cliente.getNombre() + ";" + cliente.getApellido() + ";" + cliente.getDni() + ";"
				+ cliente.getTel() + "\n";

	}

	@Override
	public void ModificarCliente(Cliente cliente) throws IOException {
		List<Cliente> listadoCliente = GetAll();

		for (Cliente c : listadoCliente) {

			if (c.getId() == (cliente.getId())) {
				c.setId(cliente.getId());
				c.setApellido(cliente.getApellido());
				c.setNombre(cliente.getNombre());
				c.setTelID(cliente.getTel().getID());
			}

			AgregarCliente(c);

		}

	}

	@Override
	public void EliminarCliente(Cliente cliente) throws IOException {
		// TODO Auto-generated method stub

		List<Cliente> listadoClientes = GetAll();

		listadoClientes.removeIf(o -> o.getId() == cliente.getId());

		for (Cliente c : listadoClientes) {

			AgregarCliente(c);

		}

	}

	@Override
	public List<Cliente> GetAll() throws IOException {
		// TODO Auto-generated method stub

		archivo = new File("/Users/juan/Desktop/cliente.txt");
		archivoReader = new FileReader(archivo);
		archivoBufferReader = new BufferedReader(archivoReader);

		String linea;
		List<Cliente> listadoClientes = new ArrayList<>();

		while ((linea = archivoBufferReader.readLine()) != null) {
			listadoClientes.add(ParseCliente(linea));
		}

		return listadoClientes;
	}

	private Cliente ParseCliente(String linea) {
		// TODO Auto-generated method stub

		String[] atributos = linea.split(";");

		Cliente c = new Cliente();
		c.setId(Integer.valueOf(atributos[0]));

		return c;
	}

}