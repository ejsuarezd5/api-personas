package es.cmc.rest.infraestructure.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.cmc.rest.domain.entities.Persona;
import es.cmc.rest.domain.gateways.PersonaGateway;
import es.cmc.rest.domain.repository.PersonaRepository;
import es.cmc.rest.infraestructure.exception.PersonaException;

@RestController
@RequestMapping("/api")
public class PersonaController implements PersonaGateway
{
	
	@Autowired
    PersonaRepository personaRepository;
	
	@GetMapping("/test")
	public @ResponseBody String test() 
	{
		return "Test API persona --> OK";
	}
	
	@PostMapping("/create_personas")
    public Persona createNote(@RequestBody Persona persona) 
	{
        return personaRepository.save(persona);
    }
	
	@GetMapping("/all_personas")
	public List<Persona> findAllPersonas() 
	{
		return personaRepository.findAll();		
	}
	
	@GetMapping("/find_persona/{id}")
	public Persona findPersonaById(@PathVariable(value = "id") Long id) throws PersonaException 
	{
		return personaRepository.findById(id).orElseThrow(() -> new PersonaException(id));
	}
	
	@PutMapping("/update_persona/{id}")
	public Persona updatePersona(@PathVariable(value = "id") Long id, @RequestBody Persona personaNew) throws PersonaException 
	{
		Persona persona = personaRepository.findById(id).orElseThrow(() -> new PersonaException(id));
		persona.setName(personaNew.getName());
		
		Persona updatedPersona = personaRepository.save(persona);

		return updatedPersona;
	}
	
	@DeleteMapping("/delete_persona/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long id) throws PersonaException 
	{
		Persona persona = personaRepository.findById(id).orElseThrow(() -> new PersonaException(id));

		personaRepository.delete(persona);

        return ResponseEntity.ok().build();
    }
}