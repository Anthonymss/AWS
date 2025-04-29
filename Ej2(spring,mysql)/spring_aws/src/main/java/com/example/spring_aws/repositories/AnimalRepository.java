package com.example.spring_aws.repositories;

import com.example.spring_aws.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository  extends JpaRepository<Animal,Long> {
}
