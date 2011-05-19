import java.io.*;
import java.util.*;

public class Juego
{
	static List<Carnivoro> listaCarnivoros = new LinkedList<Carnivoro>();
	static List<Herbivoro> listaHerbivoros = new LinkedList<Herbivoro>();
	static List<Planta> listaPlantas = new LinkedList<Planta>();

	public static void main(String[] args) throws IOException
	{
		BufferedReader is = new BufferedReader(new FileReader("entrada.txt"));
		String line;
		int i;
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
			listaPlantas.add(new Planta("a"));
		line = is.readLine();
		int lim = Integer.parseInt(is.readLine());
		Tablero tablero = new Tablero();
		tablero.draw();
		tablero.Iterate();
	};
};
