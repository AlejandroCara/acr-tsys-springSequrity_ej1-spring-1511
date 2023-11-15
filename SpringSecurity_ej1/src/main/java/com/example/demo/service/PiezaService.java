package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezaDAO;
import com.example.demo.dto.Pieza;

@Service
public class PiezaService implements IPiezaService{

	@Autowired(required = true)
	IPiezaDAO iPiezaDAO;
	
	@Override
	public List<Pieza> listAll() {
		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza add(Pieza pieza) {
		return iPiezaDAO.save(pieza);
	}

	@Override
	public Pieza getOne(int codigo) {
		return iPiezaDAO.findById(codigo).get();
	}

	@Override
	public Pieza update(Pieza pieza) {
		return iPiezaDAO.save(pieza);
	}

	@Override
	public void eliminar(int codigo) {
		iPiezaDAO.deleteById(codigo);
	}
	
	
}
