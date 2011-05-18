import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Cell extends JPanel
{
	int _x; int _y;
	Animal a = null;
	Image image;
	public Cell(int x, int y)
	{
		_x = x*25;
		_y = y*25;
	};
	public void setImage(String img)
	{
		image = new ImageIcon(img).getImage();
	};
	public Image getImage()
	{
		return image;
	};
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.getImage(), _x, _y, null);
	};
	public void makeCell()
	{
		int pC = 98;int pH = 97; int pP = 95;
		Random roll = new Random();
		int r = roll.nextInt(100);
		if(r > pC)
			this.a = Juego.listaCarnivoros.remove(0);
		if(r > pH)
			this.a = Juego.listaHerbivoros.remove(0);
		if(r > pP)
			this.a = Juego.listaPlantas.remove(0);
		else
			this.a = null;
		System.out.println("r: "+r);
	};
}
