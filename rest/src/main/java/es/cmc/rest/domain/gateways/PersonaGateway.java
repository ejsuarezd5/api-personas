package es.cmc.rest.domain.gateways;

import java.util.List;
import org.springframework.http.ResponseEntity;

import es.cmc.rest.domain.entities.Persona;
import es.cmc.rest.infraestructure.exception.PersonaException;

public interface PersonaGateway
{	
	public String test();	
    public Persona createNote(Persona persona);	
	public List<Persona> findAllPersonas();	
	public Persona findPersonaById(Long id) throws PersonaException;	
	public Persona updatePersona(Long id, Persona personaNew) throws PersonaException;
    public ResponseEntity<?> deleteBook(Long id) throws PersonaException;	
}