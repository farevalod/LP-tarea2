public class Carnivoro extends Animal
{
	public Carnivoro(String nombre, int vida, int ataque)
  	{
	  	super(nombre, vida);
	  	this.ataque = ataque;
  	};
  	private int ataque;
  	public int getAtaque()
  	{
		return this.ataque;
  	};
	public void setImg()
	{
		super.setImg("lion.png");
	}
}
