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

import com.example.demo.dto.Producto;
import com.example.demo.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		return productoServiceImpl.listarProductos();
	}
	
	@PostMapping("/productos")
	public Producto salvarProducto(@RequestBody Producto producto) {
		
		return productoServiceImpl.guardarProducto(producto);
	}
	
	@GetMapping("/productos/{codigo}")
	public Producto productoXID(@PathVariable(name="codigo") int codigo) {
		
		Producto producto_xid= new Producto();
		
		producto_xid=productoServiceImpl.productoXID(codigo);
		
		
		return producto_xid;
	}
	
	@PutMapping("/productos/{codigo}")
	public Producto actualizarProducto(@PathVariable(name="codigo")int codigo,@RequestBody Producto producto) {
		
		Producto producto_seleccionado= new Producto();
		Producto producto_actualizado= new Producto();
		
		producto_seleccionado= productoServiceImpl.productoXID(codigo);
		
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);
		
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/productos/{codigo}")
	public void eleiminarProducto(@PathVariable(name="codigo")int codigo) {
		productoServiceImpl.eliminarProducto(codigo);
	}
	
	
}