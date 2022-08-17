package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinaDAO;
import com.example.demo.dto.Maquina;

@Service
public class MaquinaServiceImpl {
	@Autowired
	IMaquinaDAO MaquinaDAO;
	
public List<Maquina> listarMaquinas() {
		
		return MaquinaDAO.findAll();
	}

	
	public Maquina guardarMaquina(Maquina maquina) {
		
		return MaquinaDAO.save(maquina);
	}

	
	public Maquina maquinaXID(int id) {
		
		return MaquinaDAO.findById(id).get();
	}

	
	public Maquina actualizarMaquina(Maquina maquina) {
		
		return MaquinaDAO.save(maquina);
	}

	
	public void eliminarMaquina(int id) {
		
		MaquinaDAO.deleteById(id);
		
	}
}
