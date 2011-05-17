import java.io.*;
import java.util.*;

public class Juego
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader is = new BufferedReader(new FileReader("entrada.txt"));
			System.out.println("Archivo de entrada leido exitosamente.");
			String line;
			int i;
			List<Carnivoro> listaCarnivoros = new LinkedList<Carnivoro>();
			List<Herbivoro> listaHerbivoros = new LinkedList<Herbivoro>();
			List<Planta> listaPlantas = new LinkedList<Planta>();
			line = is.readLine();
			line = is.readLine();
			for (i=0;i<Integer.parseInt(line);i++) 
				listaCarnivoros.add(new Carnivoro("a",1,1));
			line = is.readLine();
			line = is.readLine();
			for (i=0;i<Integer.parseInt(line);i++) 
				listaHerbivoros.add(new Herbivoro("a",1,1,1));
			line = is.readLine();
			line = is.readLine();
			for (i=0;i<Integer.parseInt(line);i++) 
				listaPlantas.add(new Planta("a",1));
			System.out.println("Listas cargadas.");

		}
		catch (IOException e)
		{
			System.err.println("ERROR: No se puede abrir el archivo"); 
		};
	};
};
