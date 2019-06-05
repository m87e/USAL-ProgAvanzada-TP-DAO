package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Vuelos;

public interface IVuelosDAO {

	void AgregarVuelo(Vuelos vuelos) throws IOException;

	void ModificarVuelo(Vuelos oldVuelo, Vuelos newVuelo) throws IOException;

	void EliminarVuelo(Vuelos vuelos) throws IOException;

	List<Vuelos> GetAll() throws IOException;

}
