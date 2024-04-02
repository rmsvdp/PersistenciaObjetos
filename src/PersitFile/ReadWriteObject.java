package PersitFile;
import java.io.*;

public class ReadWriteObject {

	
	public void ReadObject(String RutaFi)throws IOException, ClassNotFoundException {
		
		Persona _p; // defino la variable persona
		File fichero = new File(RutaFi);
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));

		int i = 1;
		try {
			while (true) { // lectura del fichero
				_p = (Persona) dataIS.readObject(); // leer una Persona
				System.out.print(i + "=>");
				i++;
				System.out.printf("Nombre: %s, edad: %d %n",
						_p.getNombre(),_p.getEdad());

			}
		} catch (EOFException eo) {
			System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) { x.printStackTrace(); }

		dataIS.close(); // cerrar stream de entrada
		
	} // ReadObject
	
	public void WriteObject(String RutaF,Boolean _mode) throws IOException  {
		
		Persona _p;//defino variable persona
		String nombres[] = {"Ana",  "Luis Miguel","Alicia","Pedro","Manuel","Andrés",
                            "Julio","Antonio",    "María Jesús"};		   
		int edades[] = {24,35,23,25,26,32,26,24,33};   
		
		File fichero = new File(RutaF);//declara el fichero
		FileOutputStream fileout = new FileOutputStream(fichero,_mode);  //crea el flujo de salida
		//conecta el flujo de bytes al flujo de datos
		 ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
		 for (int i=0;i<edades.length; i++){ //recorro los arrays    
		      _p= new Persona(nombres[i],edades[i]); //creo la persona	  
			  dataOS.writeObject(_p); //escribo la persona en el fichero
		 }     
		dataOS.close();  //cerrar stream de salida    
		System.out.println("FIN DE ESCRITURA.");
	
	} // WriteObject
	
} // ReadWriteObject
	
