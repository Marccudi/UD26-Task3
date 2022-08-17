package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVentaDAO;
import com.example.demo.dto.Venta;
@Service
public class VentaServiceImpl {
	@Autowired
	IVentaDAO VentaDAO;
	
public List<Venta> listarVentas() {
		
		return VentaDAO.findAll();
	}

	
	public Venta guardarVenta(Venta venta) {
		
		return VentaDAO.save(venta);
	}

	
	public Venta ventaXID(int id) {
		
		return VentaDAO.findById(id).get();
	}

	
	public Venta actualizarVenta(Venta venta) {
		
		return VentaDAO.save(venta);
	}

	
	public void eliminarVenta(int id) {
		
		VentaDAO.deleteById(id);
		
	}
}
