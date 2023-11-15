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

import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraService;

@RestController
@RequestMapping("suministra")
public class SuministraController {
	
	@Autowired(required = true)
	SuministraService suministraService;
	
	@GetMapping("/all")
	public List<Suministra> listarSuministros(){
		return suministraService.listAll();
	}
	
	@PostMapping("/add")
	public Suministra guardarSuministro(@RequestBody Suministra suministra) {
		return suministraService.add(suministra);
	}
	
	@GetMapping("/{id}")
	public Suministra listarUnSuministro(@PathVariable(name="id") int id) {
		return suministraService.getOne(id);
	}
	
	@PutMapping("/update/{id}")
	public Suministra actualizarSuministro(@PathVariable(name="id")int id,@RequestBody Suministra suministra) {
		
		Suministra prevSuministra = new Suministra();
		Suministra newSuministra = new Suministra();
		
		prevSuministra = suministraService.getOne(id);
		
		prevSuministra.setPrecio(suministra.getPrecio());
		
		newSuministra = suministraService.update(prevSuministra);
		
		return newSuministra;
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarSuministro(@PathVariable(name="id")int codigo) {
		suministraService.eliminar(codigo);
	}
}
