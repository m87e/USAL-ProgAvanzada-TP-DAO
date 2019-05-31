package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Paises;

public interface IPaisesDAO {

	void AgregarPais(Paises pais) throws IOException;

	void ModificarPais(Paises pais);

	void EliminarPais(Paises pais);

	List<Paises> GetAll() throws IOException;

}
