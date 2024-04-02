
import java.io.IOException;
import java.util.ArrayList;
import PersitFile.Persona;
import PersitFile.GenericRWObject;
import PersitFile.ReadWriteObject;
/**
 * Clase principal para la ejecución de los ejemplos
 * @author rmsvdp
 *
 */
public class Persistencia {

	public static final String RUTA ="c:\\rms\\";	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		System.out.println("--------------------------------------");
		System.out.println("Serialización AdHoc    : Usando Clase objetivo");	
		AdhocSerialize();
		System.out.println("--------------------------------------");
		System.out.println("Serialización Generica : Usando Genéricos");
		GenericSerialize() ;
		System.out.println("--------------------------------------");
		System.out.println("Ejecución terminada");
	} // main
	
	public static void AdhocSerialize() throws IOException, ClassNotFoundException {
		
		ReadWriteObject rwo = new ReadWriteObject();	
		try {
			rwo.WriteObject(RUTA+"personas.bin", false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Recupero los objetos persona de un archivo");
		try {
			rwo.ReadObject(RUTA+"personas.bin");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void GenericSerialize() throws IOException, ClassNotFoundException {
		
		System.out.println("Genero objetos persona y los almaceno en un archivo");		
		String nombres[] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andrés","Julio","Antonio","María Jesús"};		   
		int edades[] = {24,35,23,25,26,32,26,24,33};  
		ArrayList<Persona> alp = new ArrayList<Persona>();
		 for (int i=0;i<edades.length; i++){ //recorro los arrays    
		      Persona _p= new Persona(nombres[i],edades[i]); //creo la persona	  
			  alp.add(_p); //escribo la persona en el array
		 }
		GenericRWObject<Persona> grwo = new GenericRWObject<Persona>();			// Manejador
		PintaLista(alp);														// Muestra el resultado 
		grwo.SaveObjects( alp,RUTA+"personasG.bin", false);					// Salva estructura
		System.out.println("Recupero los objetos persona de un archivo");
		ArrayList<Persona> alpr = grwo.RestoreObjects(RUTA+"personasG.bin");// Recupera estructura
		PintaLista(alpr);														// Muestra el resultado	

	}
	
	public static void PintaLista(ArrayList<Persona> list2Print) {
		
		for (int i=0; i<list2Print.size();i++) {			
			System.out.println(i+1 +"=>"+list2Print.get(i));
		}
	}
}
