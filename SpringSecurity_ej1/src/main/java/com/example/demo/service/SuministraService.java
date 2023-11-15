package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISuministraDAO;
import com.example.demo.dto.Suministra;

@Service
public class SuministraService implements ISuministraService{
	
	@Autowired(required = true)
	ISuministraDAO iSuministraDAO;
	
	@Override
	public List<Suministra> listAll() {
		return iSuministraDAO.findAll();
	}

	@Override
	public Suministra add(Suministra suminista) {
		return iSuministraDAO.save(suminista);
	}

	@Override
	public Suministra getOne(int codigo) {
		return iSuministraDAO.findById(codigo).get();
	}

	@Override
	public Suministra update(Suministra suministra) {
		return iSuministraDAO.save(suministra);
	}

	@Override
	public void eliminar(int codigo) {
		iSuministraDAO.deleteById(codigo);
	}

}
