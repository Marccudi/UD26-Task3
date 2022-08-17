package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="maquinas_registradoras")
public class Maquina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column
	private int piso;
	
	@OneToMany
	@JoinColumn(name = "maquina")
	private List<Venta> venta;

	public Maquina() {
	}
	public Maquina(int codigo, int piso, List<Venta> venta) {
		this.codigo = codigo;
		this.piso = piso;
		this.venta = venta;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getPiso() {
		return piso;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venta")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Maquina [codigo=" + codigo + ", piso=" + piso + ", venta=" + venta + "]";
	}

	
}
