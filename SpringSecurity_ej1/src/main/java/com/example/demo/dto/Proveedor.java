package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedor")
public class Proveedor {
	
	@Id
	private String id;
	private String nombre;
	
	@OneToMany
    @JoinColumn(name = "id_proveedor")
	@JsonIgnore
	private List<Suministra> suministros;
	
	public Proveedor() {
		
	}

	public Proveedor(String id, String nombre, List<Suministra> suministros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.suministros = suministros;
	}

	public String getId() {
		return id;
	}

	public void setId(String codigo) {
		this.id =  codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Suministra> getSuministros() {
		return suministros;
	}

	public void setSuministros(List<Suministra> suministros) {
		this.suministros = suministros;
	}
	
}
