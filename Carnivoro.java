public class Carnivoro extends Animal
{
	public Carnivoro(String nombre, int vida, int ataque)
  	{
	  	super(nombre, vida);
		this.setImg("lion.png");
	  	this.ataque = ataque;
  	};
  	private int ataque;
  	public int getAtaque()
  	{
		return this.ataque;
  	};
}
