package com.example.lab7.Repositories;

import com.example.lab7.Entities.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Integer> {
}