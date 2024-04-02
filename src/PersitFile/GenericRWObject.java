package PersitFile;
import java.io.*;
import java.util.ArrayList;
public class GenericRWObject<T> {

public ArrayList<T> RestoreObjects(String RutaFi)throws IOException, ClassNotFoundException {
		
		ArrayList<T> gobj = new ArrayList<T>();
		File fichero = new File(RutaFi);
		ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));


		try {
			while (true) { // lectura del fichero
				T _p = (T) dataIS.readObject(); // leer un objeto de tipo T
				gobj.add(_p);  // Lo añade a la colección de salida

			}
		} catch (EOFException eo) {
			//System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) { x.printStackTrace(); }

		dataIS.close(); // cerrar stream de entrada
		return gobj;
	} // ReadObject
	
public void SaveObjects(ArrayList<T> gobj,String RutaF,Boolean _mode) throws IOException  {
	
	File fichero = new File(RutaF);//declara el fichero
	FileOutputStream fileout = new FileOutputStream(fichero,_mode);  //crea el flujo de salida
	//conecta el flujo de bytes al flujo de datos
	 ObjectOutputStream dataOS = new ObjectOutputStream(fileout);  
	 for (T _p : gobj){ //recorro los arrays    
		  dataOS.writeObject(_p); //escribo el objeto en el fichero
	 }     
	dataOS.close();  //cerrar stream de salida    
	//System.out.println("FIN DE ESCRITURA.");

} // WriteObject	
	
}
