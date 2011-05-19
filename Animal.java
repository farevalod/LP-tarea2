public class Animal
{
	String nombre;
	public String img;
  	int vida;
  	int nro_comidas;
	int turn;
  	public Animal(String nombre, int vida)
	{
		this.nombre = nombre;
		this.vida = vida;
		this.nro_comidas = 0;
		this.turn = 0;
	};
	public String getNombre()
	{
		return this.nombre;
	};
	public void setImg(String imgName)
	{
		this.img = imgName;
	};
	public String getImg()
	{
		return this.img;
	};
	public int toggle()
	{
		if(this.turn == 0)
			this.turn = 1;
		else
			this.turn = 0;
		return turn;
	}
}
