package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proveedor;

public interface IProveedorService {
	// Metodos del CRUD
	public List<Proveedor> listAll();

	public Proveedor add(Proveedor proveedor);

	public Proveedor getOne(String codigo);

	public Proveedor update(Proveedor proveedor);

	public void eliminar(String codigo);
}
