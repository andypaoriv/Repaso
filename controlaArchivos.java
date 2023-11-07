import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class controlaArchivos {
private String nombreArchivo;
	
	
	public controlaArchivos(String nombreArchivo) {
		
			this.nombreArchivo = nombreArchivo;
	}


	public Clase buscar(String nombreBuscar) {
	    try {
	        BufferedReader in = new BufferedReader(new FileReader("\\Users\\Andypao\\Documents\\tienda.txt"));
	        String linea = in.readLine();

	        while (linea != null) {
	            int indexComaUno = linea.indexOf(",", 1);
	            int indexComaDos = linea.indexOf(",", indexComaUno + 1);

	            String nombre = linea.substring(0, indexComaUno);

	            if (nombre.equals(nombreBuscar)) {
	                String empresa = linea.substring(indexComaUno + 1, indexComaDos);
	                int precio = Integer.parseInt(linea.substring(indexComaDos + 1));
	                Clase contactoLeido = new Clase(nombre, precio, empresa);
	                in.close();
	                return contactoLeido;
	            }

	            linea = in.readLine();
	        }

	        in.close();
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
	    
	    return null; 
	}

	public void escribeEnArchivo(String nombre,String empresa, int precio) {
		
		try {
			BufferedWriter	out = new BufferedWriter(new FileWriter("\\Users\\Andypao\\Documents\\tienda.txt", true));
			String cadena = nombre + "," + empresa + "," + precio+ "," ;
			out.write(cadena);
			out.close();
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
