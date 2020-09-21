package com.example.demo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Libro;

public interface ILibro extends CrudRepository<Libro, Integer>{

}
