package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductoDAO;
import com.example.demo.dto.Producto;

@Service
public class ProductoServiceImpl {
	@Autowired
	IProductoDAO ProductoDAO;
	
public List<Producto> listarProductos() {
		
		return ProductoDAO.findAll();
	}

	
	public Producto guardarProducto(Producto producto) {
		
		return ProductoDAO.save(producto);
	}

	
	public Producto productoXID(int id) {
		
		return ProductoDAO.findById(id).get();
	}

	
	public Producto actualizarProducto(Producto producto) {
		
		return ProductoDAO.save(producto);
	}

	
	public void eliminarProducto(int id) {
		
		ProductoDAO.deleteById(id);
		
	}
}
