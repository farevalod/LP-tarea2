public class Herbivoro extends Animal
{
	public Herbivoro(String nombre, int vida, int defensa, int rand_mov)
  	{
		super(nombre, vida);
		this.defensa = defensa;
		this.rand_mov = rand_mov;
	};
	private int defensa;
	private int rand_mov;
	public int getDefensa()
	{		
		return this.defensa;
	};
	public int getMov()
	{
		return this.rand_mov;
	};
}

