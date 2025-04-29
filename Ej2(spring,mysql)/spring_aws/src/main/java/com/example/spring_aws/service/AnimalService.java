package com.example.spring_aws.service;

import com.example.spring_aws.entities.Animal;
import com.example.spring_aws.exception.NotFoundException;
import com.example.spring_aws.repositories.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository repository;

    public Animal create(Animal animal){
        return  this.repository.save(animal);
    }
    public Animal findById(Long id){
        Optional<Animal> aniOpt=this.repository.findById(id);
        if(aniOpt.isEmpty()){
            throw new NotFoundException("Not Found Animal id: "+id);
        }
        return  aniOpt.get();
    }
    public List<Animal> findAll(){
        return this.repository.findAll();
    }
    public String delete(Long id){
        Optional<Animal> aniOpt=this.repository.findById(id);
        if(aniOpt.isEmpty()){
            throw new NotFoundException("Not Found Animal id: "+id);
        }
        this.repository.deleteById(id);
        return "Animal delete by id: "+id ;
    }
}
