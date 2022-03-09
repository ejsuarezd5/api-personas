package es.cmc.rest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cmc.rest.domain.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> 
{
}