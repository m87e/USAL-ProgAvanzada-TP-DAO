package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.util.*;

import edu.usal.tp.negocio.dao.dominio.Cliente;

public interface IClienteDAO {

	void AgregarCliente(Cliente cliente) throws IOException;

	void ModificarCliente(Cliente oldCliente, Cliente newCliente) throws IOException;

	void EliminarCliente(Cliente cliente) throws IOException;

	List<Cliente> GetAll() throws IOException;

}
