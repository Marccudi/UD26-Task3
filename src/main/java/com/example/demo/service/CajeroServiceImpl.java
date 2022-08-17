package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajeroDAO;
import com.example.demo.dto.Cajero;

@Service
public class CajeroServiceImpl {
	@Autowired
	ICajeroDAO CajeroDAO;
	
public List<Cajero> listarCajeros() {
		
		return CajeroDAO.findAll();
	}

	
	public Cajero guardarCajero(Cajero cajero) {
		
		return CajeroDAO.save(cajero);
	}

	
	public Cajero cajeroXID(int id) {
		
		return CajeroDAO.findById(id).get();
	}

	
	public Cajero actualizarCajero(Cajero cajero) {
		
		return CajeroDAO.save(cajero);
	}

	
	public void eliminarCajero(int id) {
		
		CajeroDAO.deleteById(id);
		
	}
}
