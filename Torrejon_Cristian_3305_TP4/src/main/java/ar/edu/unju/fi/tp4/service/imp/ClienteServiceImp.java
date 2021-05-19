package ar.edu.unju.fi.tp4.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;
import ar.edu.unju.fi.tp4.util.ListaCliente;

@Service("clienteImp")
public class ClienteServiceImp implements IClienteService{

	private List<Cliente> clientes ;
	

	
	@Override
	public void generarTablaClientes() {
		clientes = ListaCliente.listaClientes;
		clientes.add(new Cliente("DNI", 19089786,"Jose Perez" ,"correo@correo.com", "12345678", LocalDate.of(1990,8,15), 25,388,155098790 , LocalDate.of(2021, 4, 10)));
	}
	
	@Override
	public void agregarCliente(Cliente cliente) {
		if(clientes == null) {
			generarTablaClientes();
		}
		clientes.add(cliente);
	}

	@Override
	public List<Cliente> obtenerClientes() {
		
		
		return clientes;
	}

	

}
