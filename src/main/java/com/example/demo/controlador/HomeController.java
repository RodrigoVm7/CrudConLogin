package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Libro;
import com.example.demo.repositorio.ILibro;

@Controller
public class HomeController {
	
	@Autowired
	private ILibro data;
	
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("libros", data.findAll());
		return "index";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("nuevoLibro", new Libro());
		return "create";
	}
	
	@PostMapping("/save")
	public String guardar(@Validated Libro libriito, Model model) {
		data.save(libriito);
		return "redirect:/";
	}
	
	@GetMapping("/actualizar/{id}")
	public String actualizar(@PathVariable int id, Model model) {
		model.addAttribute("libro", data.findById(id));
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(@Validated Libro libro, Model model) {
		data.save(libro);
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		data.deleteById(id);
		return "redirect:/";
	}
}
