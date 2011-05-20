import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Cell extends JPanel
{
	int _x; int _y;
	int cx; int cy;
	Animal a = null;
	Image image;

	public Cell(int x, int y)
	{
		_x = x*25;
		_y = y*25;
		cx = x;
		cy = y;
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

	public void switchCell(int dx, int dy)
	{
		if(this.a.toggle() == 0)
		{
			if(((cx+dx) != 4) || ((cx+dy) != 4))
			{
				if(Tablero.matrix[cx+dx][cy+dy].a == null)
				{
					Tablero.matrix[cx+dx][cy+dy].a = this.a;
					Tablero.matrix[cx+dx][cy+dy].setImage(this.a.getImg());
					this.a = null;
					this.setImage("grass.png");
					repaint();
				};
			};
		}
		else
			repaint();
	};
	
	public void chaseAI()
	{
		if((cx < 3) && (cy < 3))
			switchCell(1,1);
		else if((cx > 5) && (cy < 3))
			switchCell(-1,1);
		else if((cx < 3) && (cy > 5))
			switchCell(1,-1);
		else if((cx > 5) && (cy > 5))
			switchCell(-1,-1);
		else if(((cx == 3)||(cx == 4)||(cx == 5)) && (cy < 3))
			switchCell(0,1);
		else if(((cx == 3)||(cx == 4)||(cx == 5)) && (cy > 5))
			switchCell(0,-1);
		else if((cx < 3) && ((cy == 3)||(cy == 4)||(cy == 5)))
			switchCell(1,0);
		else if((cx < 5) && ((cy == 3)||(cy == 4)||(cy == 5)))
			switchCell(-1,0);
	}
	public void fleeAI()
	{
		Random roll = new Random();
		int mov = 1;
		if(roll.nextInt(100) > 65)
		{
			mov = 2;
		};
		if(this.cx == 3)
			switchCell(-mov,0);
		if(this.cx == 5)
			switchCell(mov,0);
		if(this.cy == 3)
			switchCell(0,-mov);
		if(this.cy == 5)
			switchCell(0,mov);
	};
	public void makeCell()
	{
		int pC = 98; int pH = 97; int pP = 95;
		Random roll = new Random();
		int r = roll.nextInt(100);
		if((r > pC) && (!Juego.listaCarnivoros.isEmpty()))
		{
			this.a = Juego.listaCarnivoros.remove(0);
			return;
		};
		if((r > pH) && (!Juego.listaHerbivoros.isEmpty()))
		{
			this.a = Juego.listaHerbivoros.remove(0);
			return;
		}
		if((r > pP) && (!Juego.listaPlantas.isEmpty()))
		{
			this.a = Juego.listaPlantas.remove(0);
			return;
		}
		else
			this.a = null;
	};
}
