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
@Table(name="cajeros")
public class Cajero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column
	private String nomapels;
	
	@OneToMany
	@JoinColumn(name = "cajero")
	private List<Venta> venta;

	public Cajero() {
	}
	public Cajero(int codigo, String nomapels, List<Venta> venta) {
		this.codigo = codigo;
		this.nomapels = nomapels;
		this.venta = venta;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNomapels() {
		return nomapels;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venta")
	public List<Venta> getVenta() {
		return venta;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}
	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}
	@Override
	public String toString() {
		return "Cajero [codigo=" + codigo + ", nomapels=" + nomapels + ", venta=" + venta + "]";
	}


}
