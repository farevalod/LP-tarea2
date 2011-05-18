public class Jugador
{
	static Animal a;
	public Jugador(char choice)
	{
		if(choice == 'c')
		{
			a = new Carnivoro("Leon",100,10);
		}
		else
		{
			a = new Herbivoro("Zebra",50,10,3);
		}
	}
}
