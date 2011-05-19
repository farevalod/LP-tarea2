public class Animal
{
	String nombre;
	public String img;
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
		return this.nombre;
	};
	public void setImg(String imgName)
	{
		this.img = imgName;
	}
	public String getImg()
	{
		return this.img;
	}
}
