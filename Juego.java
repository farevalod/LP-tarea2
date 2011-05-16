import java.io.*;

public class Juego
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader is = new BufferedReader(new FileReader("entrada.txt"));
			System.out.println("Archivo de entrada leido exitosamente.");
			String line;
			while((line = is.readLine()) != null)
				System.out.println(line);

		}
		catch (IOException e)
		{
			System.err.println("ERROR: No se puede abrir el archivo"); 
		};
	};
};
