package com.example.lab7.Repositories;

import com.example.lab7.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Integer> {

}
