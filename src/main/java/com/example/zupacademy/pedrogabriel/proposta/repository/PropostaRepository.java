package com.example.zupacademy.pedrogabriel.proposta.repository;

import com.example.zupacademy.pedrogabriel.proposta.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer> {

}
