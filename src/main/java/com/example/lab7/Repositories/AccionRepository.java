package com.example.lab7.Repositories;

import com.example.lab7.Entities.Accion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccionRepository extends JpaRepository<Accion, Integer > {
}
