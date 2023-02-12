package com.example.Ejercicio10_11_12.controller;


import com.example.Ejercicio10_11_12.entities.Laptop;
import com.example.Ejercicio10_11_12.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    //Atributos
    @Value("${app.message}")
    String msj;



    private LaptopRepository laptopRepository;

    // Constructor
    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/laptop")
    public String laptop(){
        System.out.println(msj);
        return "Bienvenidos a Laptops";
    }
    /*
    Método:
    Desde LaptopController crear un método que devuelva una lista de objetos Laptop.
    Probar que funciona desde Postman.
     */
    @GetMapping("api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();

    }



    // Método para buscar una laptop por el id - findOneById()
    @GetMapping("api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptOpt = laptopRepository.findById(id);
        if (laptOpt.isPresent()) {
            return ResponseEntity.ok(laptOpt.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    // Crear un nuevo laptop en la BD.
    @PostMapping("api/laptops")
    public ResponseEntity<Laptop> create (@RequestBody Laptop laptop){
        if (laptop.getId() != null){
            System.out.println("Trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // Update - Actualizar laptop existente en BD.
    @PutMapping("api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            System.out.println("Trying to update non existent book");
            return ResponseEntity.badRequest().build();
        }

        // Comprobar si el laptop existe
        if (!laptopRepository.existsById(laptop.getId())){
            System.out.println("Trying to update a non existent book(Intentando actualizar un libro inexistente)");
            return ResponseEntity.notFound().build();
        }

        // Proceso de actualización
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // Eliminar una laptop en particular por medio del id.
    @DeleteMapping("api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            System.out.println("Trying to delete a non existent book(intentando eliminar un libro inexsistente)");
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Eliminar todos los elementos
    @DeleteMapping("/api/laptopsAll")
    public ResponseEntity<Laptop> deleteAll() {
        laptopRepository.deleteAll();
        return ResponseEntity.ok().build();
    }



}
