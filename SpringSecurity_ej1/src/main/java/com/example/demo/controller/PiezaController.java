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

import com.example.demo.dto.Pieza;
import com.example.demo.service.PiezaService;

@RestController
@RequestMapping("/pieza")
public class PiezaController {
	
	@Autowired(required = true)
	PiezaService piezaService;
	
	@GetMapping("/all")
	public List<Pieza> listarPiezas(){
		return piezaService.listAll();
	}
	
	@PostMapping("/add")
	public Pieza guardarPieza(@RequestBody Pieza pieza) {
		return piezaService.add(pieza);
	}
	
	@GetMapping("/{codigo}")
	public Pieza listarUnaPieza(@PathVariable(name="codigo") int codigo) {
		return piezaService.getOne(codigo);
	}
	
	@PutMapping("/update/{codigo}")
	public Pieza actualizarPieza(@PathVariable(name="codigo")int codigo,@RequestBody Pieza pieza) {
		
		Pieza prevPieza = new Pieza();
		Pieza newArticulo = new Pieza();
		
		prevPieza = piezaService.getOne(codigo);
		
		prevPieza.setNombre(pieza.getNombre());
		
		newArticulo = piezaService.update(prevPieza);
		
		return newArticulo;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public void eliminarPieza(@PathVariable(name="codigo")int codigo) {
		piezaService.eliminar(codigo);
	}
}
