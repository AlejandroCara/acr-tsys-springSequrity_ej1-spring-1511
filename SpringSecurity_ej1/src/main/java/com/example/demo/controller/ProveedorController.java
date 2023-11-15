package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proveedor;
import com.example.demo.service.ProveedorService;

@RestController
@RequestMapping("proveedor")
public class ProveedorController {
	
	@Autowired(required = true)
	ProveedorService proveedorService;
	
	@GetMapping("/all")
	public List<Proveedor> listarProveedores(){
		return proveedorService.listAll();
	}
	
	@PostMapping("/add")
	public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorService.add(proveedor);
	}
	
	@GetMapping("/{id}")
	public Proveedor listarUnProveedor(@PathVariable(name="id") String id) {
		return proveedorService.getOne(id);
	}
	
	@PutMapping("/update/{id}")
	public Proveedor actualizarSuministro(@PathVariable(name="id")String id,@RequestBody Proveedor proveedor) {
		
		Proveedor prevProvedor = new Proveedor();
		Proveedor newProveedor = new Proveedor();
		
		prevProvedor = proveedorService.getOne(id);
		
		prevProvedor.setNombre(proveedor.getNombre());
		
		newProveedor = proveedorService.update(prevProvedor);
		
		return newProveedor;
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarProveedor(@PathVariable(name="id")String codigo) {
		proveedorService.eliminar(codigo);
	}
}
