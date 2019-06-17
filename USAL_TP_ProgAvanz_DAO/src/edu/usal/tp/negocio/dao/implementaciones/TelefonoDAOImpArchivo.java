package edu.usal.tp.negocio.dao.implementaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import edu.usal.tp.negocio.dao.dominio.Paises;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.interfaces.ITelefonoDAO;

public class TelefonoDAOImpArchivo implements ITelefonoDAO{
	private File archivo;
	private FileWriter archivoWriter;
	private FileReader archivoReader;
	private BufferedWriter archivoBufferWriter;
	private BufferedReader archivoBufferReader;

 
	
	@Override
	public void AgregarTelefono(Telefono tel) throws IOException {
		
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		//properties.getProperty("pathTelefono");
		
		//archivo = new File(properties.getProperty("pathTelefono"));
		archivo = new File ("C://Users//menrique002//git//USAL-ProgAvanzada-TP-DAO//USAL_TP_ProgAvanz_DAO//telefonos.txt");

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

	private String SaveTelefono(Telefono tel) {
		return tel.getID()  +";" +tel.getNumPersonal() + ";" + tel.getNumLaboral()+";" + tel.getNumCelular() + "\n";
	}

	@Override
	public void ModificarTelefono(Telefono tel) throws IOException {
		List<Telefono> listadoTelefono = GetAll();

		for (Telefono t : listadoTelefono) {

			if (t.getID()==(tel.getID())) {
				t.setID(tel.getID());
				t.setNumCelular(tel.getNumCelular());
				t.setNumPersonal(tel.getNumPersonal());
				t.setNumLaboral(tel.getNumLaboral());
			}

			AgregarTelefono(t);

		}

	}

	@Override
	public void EliminarTelefono(Telefono tel) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Telefono> GetAll() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
