package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pieza;

public interface IPiezaService {
	// Metodos del CRUD
	public List<Pieza> listAll();

	public Pieza add(Pieza pieza);

	public Pieza getOne(int codigo);

	public Pieza update(Pieza pieza);

	public void eliminar(int codigo);
}
