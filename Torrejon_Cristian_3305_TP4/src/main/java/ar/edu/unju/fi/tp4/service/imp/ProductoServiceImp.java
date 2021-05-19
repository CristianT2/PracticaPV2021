package ar.edu.unju.fi.tp4.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {
	
	private List<Producto> productos = new ArrayList<Producto>();

	@Override
	public void AgregarProducto(Producto producto) {
		
		productos.add(producto);
	}

	@Override
	public Producto obtenerUltimoProducto(Producto producto) {
		int indiceUltProd = productos.size()-1;
		producto = productos.get(indiceUltProd);
		
		return producto;
	}

	

	


}
