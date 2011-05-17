import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Tablero extends JPanel
{
	Cell[][] matrix;
	JFrame frame = new JFrame("Juego");
	BufferedImage buf = new BufferedImage(225, 225, BufferedImage.TYPE_INT_RGB);
	public Tablero()
	{
		matrix = new Cell[9][9]; 
		int i;int j;
		for (i=0;i<9;i++)
			for (j=0;j<9;j++)
				matrix[i][j] = new Cell(i,j);
		matrix[4][4].setImage("lion.png");
	}
	public void draw() 
	{	
		this.frame.add(this);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(225, 250);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
	};
	public void Iterate()
	{
		int i; int j;
		Graphics g = buf.createGraphics();
		for (i=0;i<9;i++ )
		{
			for (j=0;j<9;j++) 
			{
				if((i != 4) || (j != 4))
					if(matrix[i][j].a != null)
					{
						if(matrix[i][j].a instanceof Carnivoro)
							matrix[i][j].setImage("lion.png");
						if(matrix[i][j].a instanceof Herbivoro)
							matrix[i][j].setImage("cow.png");
						//matrix[i][j].a.ai();
					}
					else
					{
						matrix[i][j].setImage("grass.png");
					}
			    g.drawImage(matrix[i][j].getImage(), matrix[i][j]._x, matrix[i][j]._y, null);
			};
		};
	};
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(buf,0, 0, null);
	};
}
