package factories;

import daos.DaoContactos;
import daos.DaoContactosImpl;

// Clase de factor�a

public class FactoryDao {
	public static DaoContactos getDaoContactos() {
		return new DaoContactosImpl();
	}

}
