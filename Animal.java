public class Animal
{
	String nombre;
  	int vida;
  	int nro_comidas;
  	public Animal(String nombre, int vida)
	{
		this.nombre = nombre;
		this.vida = vida;
		this.nro_comidas = 0;		
	};
	public String getNombre()
	{
		return nombre;
	};
}

