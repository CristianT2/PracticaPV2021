package ar.edu.unju.fi.tp4.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;

@Controller
public class ClienteController {
	
	private static final Log LOGGER = LogFactory.getLog(ClienteController.class);
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("clienteImp")
	private IClienteService clienteService;
	
	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}

	@GetMapping("/cliente/nuevo")
	public String getFormClientePege(Model model) {
		
		model.addAttribute("cliente", cliente);
		
		LOGGER.info("METHOD: GetFormClientePage");
		LOGGER.info("RESULT: Se visualizo la pagina de formulario de registro de clientes");
		
		return "nuevocliente";
	}
	
	@PostMapping("/cliente/guardar")
	public ModelAndView getListaClientePage(@ModelAttribute("cliente") Cliente cliente) {
		ModelAndView modelView = new ModelAndView("clientes");
		clienteService.agregarCliente(cliente);
		modelView.addObject("clientes", clienteService.obtenerClientes());
		
		LOGGER.info("METHOD: agregarCliente");
		LOGGER.info("RESULT: Se registro un nuevo cliente");
		LOGGER.info("METHOD: obtenerCliente");
		LOGGER.info("RESULT: Se visualiza los datos del cliente obtenidos en el formulario de registro");
		return modelView;
	}
	
	
	@GetMapping("/cliente/listado")
	public ModelAndView getTodosLosClientesPage() {
		ModelAndView modelView = new ModelAndView("clientes");
		if(clienteService.obtenerClientes() == null) {
			clienteService.generarTablaClientes();
		}
		modelView.addObject("clientes", clienteService.obtenerClientes());
		
		LOGGER.info("METHOD: obtenerClientes");
		LOGGER.info("RESULT: Se visualizo la lista de todos los clientes registrados");
		return modelView;
	}

}
