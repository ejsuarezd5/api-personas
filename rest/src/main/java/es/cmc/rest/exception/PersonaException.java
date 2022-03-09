package es.cmc.rest.exception;

public class PersonaException extends Exception 
{
	private static final long serialVersionUID = 1L;	
	
	public PersonaException(long id) 
	{
        super(String.format("Exception: La persona con el id %s no existe", id));
    }
}