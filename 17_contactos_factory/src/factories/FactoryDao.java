package factories;

import daos.DaoContactos;
import daos.DaoContactosImpl;

// Clase de factoría

public class FactoryDao {
	public static DaoContactos getDaoContactos() {
		return new DaoContactosImpl();
	}

}
