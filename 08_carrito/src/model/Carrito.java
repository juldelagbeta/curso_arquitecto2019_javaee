package model;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<Producto> productos;

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void addProducto(Producto producto) {
		productos.add(producto);
	}

}
