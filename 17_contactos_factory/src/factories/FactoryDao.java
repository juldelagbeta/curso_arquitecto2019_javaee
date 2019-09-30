package factories;

import daos.DaoContactos;
import daos.DaoContactosImpl;

// Clase de factoría
// modificado en casa

public class FactoryDao {
	public static DaoContactos getDaoContactos() {
		return new DaoContactosImpl();
	}

}
