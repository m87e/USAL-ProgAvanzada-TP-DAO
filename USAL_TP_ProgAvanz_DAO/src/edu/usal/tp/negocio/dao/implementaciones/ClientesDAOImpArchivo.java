package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		archivo = new File ("C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//cliente.txt");

		if (!archivo.exists()) {
			archivoWriter = new FileWriter(archivo);
		} else {
			archivoWriter = new FileWriter(archivo, true);
		}

		archivoBufferWriter = new BufferedWriter(archivoWriter);

		String str = SaveTelefono(tel);

		archivoBufferWriter.write(str);
		archivoBufferWriter.close();
		archivoWriter.close();

		
	}
	@Override
	public void ModificarCliente(Cliente cliente) throws IOException {
		List<Cliente> listadoCliente = GetAll();

		for (Cliente c : listadoCliente) {

			if (c.getId()==(cliente.getId())) {
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
		
	}
	@Override
	public List<Cliente> GetAll() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
