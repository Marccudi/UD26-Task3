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

import com.example.demo.dto.Maquina;
import com.example.demo.service.MaquinaServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaController {

	@Autowired
	MaquinaServiceImpl maquinaServiceImpl;
	
	@GetMapping("/maquinas")
	public List<Maquina> listarMaquinas(){
		return maquinaServiceImpl.listarMaquinas();
	}
	
	@PostMapping("/maquinas")
	public Maquina salvarMaquina(@RequestBody Maquina maquina) {
		
		return maquinaServiceImpl.guardarMaquina(maquina);
	}
	
	@GetMapping("/maquinas/{codigo}")
	public Maquina maquinaXID(@PathVariable(name="codigo") int codigo) {
		
		Maquina maquina_xid= new Maquina();
		
		maquina_xid=maquinaServiceImpl.maquinaXID(codigo);
		
		
		return maquina_xid;
	}
	
	@PutMapping("/maquinas/{codigo}")
	public Maquina actualizarMaquina(@PathVariable(name="codigo")int codigo,@RequestBody Maquina maquina) {
		
		Maquina maquina_seleccionado= new Maquina();
		Maquina maquina_actualizado= new Maquina();
		
		maquina_seleccionado= maquinaServiceImpl.maquinaXID(codigo);
		
		maquina_seleccionado.setPiso(maquina.getPiso());
		
		maquina_actualizado = maquinaServiceImpl.actualizarMaquina(maquina_seleccionado);
		
		
		return maquina_actualizado;
	}
	
	@DeleteMapping("/maquinas/{codigo}")
	public void eleiminarMaquina(@PathVariable(name="codigo")int codigo) {
		maquinaServiceImpl.eliminarMaquina(codigo);
	}
	
	
}