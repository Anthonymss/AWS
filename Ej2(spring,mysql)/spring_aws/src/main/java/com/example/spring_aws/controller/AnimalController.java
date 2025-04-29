package com.example.spring_aws.controller;

import com.example.spring_aws.entities.Animal;
import com.example.spring_aws.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;
    @PostMapping
    public ResponseEntity<Animal> create(@RequestBody Animal animal){
        return new ResponseEntity<>(this.animalService.create(animal),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Animal> findById(@PathVariable Long id){
        return  new ResponseEntity<>(this.animalService.findById(id),HttpStatus.OK);
    }
    @GetMapping
    public  ResponseEntity<List<Animal>> findAll(){
        return  new ResponseEntity<>(this.animalService.findAll(),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteById(@PathVariable Long id){
        return  new ResponseEntity<>(this.animalService.delete(id),HttpStatus.OK);
    }
}
