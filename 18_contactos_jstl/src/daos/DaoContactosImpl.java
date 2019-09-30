package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Contacto;
import resources.Data;

public class DaoContactosImpl implements DaoContactos {

	static DataSource ds;
	static {
		// patrón service locator
		ds = Data.getDataSource("refcontactos");
	}

	@Override
	public void altaContacto() {
		try (Connection con = ds.getConnection()) {
			String sql = "insert into contactos(nombre,email,edad) values(";
			sql += "'jdbc','jdbc@gmail.com','50'";
			Statement st = con.createStatement();
			st.execute(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void altaContacto(Contacto contacto) {

		String nombreContacto = contacto.getNombre();
		String emailContacto = contacto.getEmail();
		int edadContacto = contacto.getEdad();

		/*
		 * try(Connection con=DriverManager.getConnection(url, user, pwd)) { String
		 * sql="insert into contactos(nombre,email,edad) values(";
		 * sql+="'"+nombreContacto+"','"+emailContacto+"',"+edadContacto+")"; Statement
		 * st=con.createStatement(); st.execute(sql); } catch (SQLException ex) {
		 * ex.printStackTrace(); }
		 */

		String sql = "insert into contactos(nombre,email,edad) values(?,?,?)";

		try (Connection con = ds.getConnection(); PreparedStatement prep = con.prepareStatement(sql);) {
			// asignamos valores a los parámetros
			prep.setString(1, nombreContacto);
			prep.setString(2, emailContacto);
			prep.setInt(3, edadContacto);
			// ejecutamos
			prep.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<Contacto> recuperarContactos() {

		List<Contacto> contactos = new ArrayList<>();

		String sql = "select * from contactos";

		try (Connection con = ds.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			while (rs.next()) {
				contactos.add(new Contacto(rs.getInt("idContacto"), rs.getString("nombre"), rs.getString("email"),
						rs.getInt("edad")));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return contactos;
	}

	@Override
	public void eliminarContacto(int id) {
		String sql = "delete from contactos where idContacto=?";
		try (Connection con = ds.getConnection(); PreparedStatement prep = con.prepareStatement(sql);) {
			// asignamos valores a los parámetros
			prep.setInt(1, id);
			// ejecutamos
			prep.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
