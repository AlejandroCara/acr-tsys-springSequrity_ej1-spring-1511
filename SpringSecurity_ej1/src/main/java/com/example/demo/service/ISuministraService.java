package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Suministra;

public interface ISuministraService {
	// Metodos del CRUD
		public List<Suministra> listAll();

		public Suministra add(Suministra suminista);

		public Suministra getOne(int codigo);

		public Suministra update(Suministra suministra);

		public void eliminar(int codigo);
}
