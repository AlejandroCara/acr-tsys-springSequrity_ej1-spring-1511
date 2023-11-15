package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedorDAO;
import com.example.demo.dto.Proveedor;

@Service
public class ProveedorService implements IProveedorService{

	@Autowired(required = true)
	IProveedorDAO iProveedorDAO;
	
	@Override
	public List<Proveedor> listAll() {
		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor add(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public Proveedor getOne(String codigo) {
		return iProveedorDAO.findById(codigo).get();
	}

	@Override
	public Proveedor update(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public void eliminar(String codigo) {
		iProveedorDAO.deleteById(codigo);
	}

}
