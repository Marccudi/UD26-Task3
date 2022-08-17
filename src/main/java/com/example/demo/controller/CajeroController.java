package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cajero;
import com.example.demo.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros(){
		return cajeroServiceImpl.listarCajeros();
	}
	
	@PostMapping("/cajeros")
	public Cajero salvarCajero(@RequestBody Cajero cajero) {
		
		return cajeroServiceImpl.guardarCajero(cajero);
	}
	
	@GetMapping("/cajeros/{codigo}")
	public Cajero cajeroXID(@PathVariable(name="codigo") int codigo) {
		
		Cajero cajero_xid= new Cajero();
		
		cajero_xid=cajeroServiceImpl.cajeroXID(codigo);
		
		
		return cajero_xid;
	}
	
	@PutMapping("/cajeros/{codigo}")
	public Cajero actualizarCajero(@PathVariable(name="codigo")int codigo,@RequestBody Cajero cajero) {
		
		Cajero cajero_seleccionado= new Cajero();
		Cajero cajero_actualizado= new Cajero();
		
		cajero_seleccionado= cajeroServiceImpl.cajeroXID(codigo);
		
		cajero_seleccionado.setNomapels(cajero.getNomapels());
		
		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);
		
		
		return cajero_actualizado;
	}
	
	@DeleteMapping("/cajeros/{codigo}")
	public void eleiminarCajero(@PathVariable(name="codigo")int codigo) {
		cajeroServiceImpl.eliminarCajero(codigo);
	}
	
	
}