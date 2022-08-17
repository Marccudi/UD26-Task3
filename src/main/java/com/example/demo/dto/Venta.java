package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "cajero")
	Cajero cajero;
	@ManyToOne
    @JoinColumn(name = "maquina")
	Maquina maquina;
	@ManyToOne
    @JoinColumn(name = "producto")
	Producto producto;
	public Venta() {
	}
	public Venta(int id, Cajero cajero, Maquina maquina, Producto producto) {
		this.id = id;
		this.cajero = cajero;
		this.maquina = maquina;
		this.producto = producto;
	}

	public int getId() {
		return id;
	}
	public Cajero getCajero() {
		return cajero;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", maquina=" + maquina + ", producto=" + producto + "]";
	}

	
	

}
