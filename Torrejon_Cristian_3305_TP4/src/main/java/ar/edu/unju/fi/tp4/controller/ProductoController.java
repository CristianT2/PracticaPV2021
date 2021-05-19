/**
 * 
 */
package ar.edu.unju.fi.tp4.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;
import ar.edu.unju.fi.tp4.service.imp.ProductoServiceImp;

/**
 * @author Torrejon Cristian
 *
 */

@Controller
public class ProductoController {
	
	@Autowired
	private IProductoService productoservice;
	
	@Autowired
	private Producto producto;
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	
	@GetMapping("/producto")
	public String getFormProductoPage(Model model) {
		model.addAttribute(producto);
		LOGGER.info("METHOD: getFormProducto");
		LOGGER.info("RESULT: Se visualizo la pagina de registro");
		return "nuevo";
	}

	@PostMapping("/producto/registrar")
	public String getResultProductoPage(@ModelAttribute("producto") Producto producto) {
		productoservice.AgregarProducto(producto);
		LOGGER.info("METHOD: agregarProducto");
		LOGGER.info("RESULT: Se agrego un nuevo producto en la lista");
		return "resultado";
	}
	
	@GetMapping("/producto/ultimo")
	public ModelAndView getUltimoRegistroPage() {
		ModelAndView modelview = new ModelAndView("ultimoproducto");
		modelview.addObject("producto", productoservice.obtenerUltimoProducto(producto));
		
		LOGGER.info("METHOD: obtenerUltimoProducto ");
		LOGGER.info("RESULT: Se visualizo el ultimo producto registrado");
		return modelview;
	}

	
}
