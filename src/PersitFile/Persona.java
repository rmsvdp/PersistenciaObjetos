package PersitFile;

import java.io.Serializable;
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int edad;
	private String Dni; // nnnnnnnnA
	
	public Persona(String nombre,int edad)	{
	  this.nombre=nombre;
	  this.edad=edad;
	  this.Dni="nnnnnnnnA";
	 }
	public Persona() {
	  this.nombre=null;
	  this.edad = 0;
      this.Dni="nnnnnnnnA";	  
	 }	
	public void setNombre(String nom){nombre=nom;}
	public void setEdad(int ed){edad=ed;}
	public void setDni(String _dni){Dni = _dni;}	
	
	public String getNombre(){return nombre;}
	public int getEdad(){return edad;}	
	
	public String getDni(){return Dni;}
	
	public String toString() {
		
		return "Nombre: " +nombre+", edad: "+edad;
	}
	
}//fin Persona
