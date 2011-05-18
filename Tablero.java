import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Tablero extends JPanel implements KeyListener
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
		frame.addKeyListener(this);
		frame.setFocusable(true);
	};

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
		this.buf = new BufferedImage(225, 225, BufferedImage.TYPE_INT_RGB);
		Graphics g = buf.createGraphics();
		for (i=0;i<9;i++ )
		{
			for (j=0;j<9;j++) 
			{
				if((i != 4) || (j != 4))
					if(matrix[i][j].a != null)
					{
						matrix[i][j].a.setImg("cow.png");
						matrix[i][j].setImage(matrix[i][j].a.getImg());/*
						if(matrix[i][j].a instanceof Animal)
						{
							matrix[i][j].setImage("lion.png");
							System.out.println("lion");
						}
						if(matrix[i][j].a instanceof Herbivoro)
						{
							matrix[i][j].setImage("cow.png");
							System.out.println("cow");
						}
						*/
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

	public void keyTyped(KeyEvent e)
	{
		//System.out.println("KEY TYPED: ");
	};

	public void keyPressed(KeyEvent e)
	{
		//37=L 38=U 39=R 40=D
		switch(e.getKeyCode())
		{
			case 37:
				applyLeft();
				break;
			case 38:
				//apply up;
				break;
			case 39:
				//apply right;
				break;
			case 40:
				//apply down;
				break;
		}
		this.Iterate();
		this.draw();
		repaint();
		System.out.println("Iterating");
		if(matrix[4][3].a != null)
		{
			System.out.println(matrix[4][3].a.getNombre());
			System.out.println(matrix[4][3].a.getImg());
		}
		System.out.println(matrix[4][3].getImage());
	};

	public void keyReleased(KeyEvent e)
	{
		//System.out.println("KEY RELEASED: ");
	};

	public void applyLeft()
	{
		int i;int j;
		if(matrix[3][4].a == null)
		{
			for (i=0;i<9;i++)
				matrix[8][i].a = null;
			for(i=0;i<9;i++)
			{
				for(j=8;j>0;j--)
				{
					if((i != 4) || (j != 4)) //El animal del jugador (en 4,4) no se mueve.
						matrix[j][i].a = matrix[j-1][i].a;
				}
				matrix[0][i].makeCell();
			}
		}
		else//Hay algo en la celda
		{
			if(Jugador.a instanceof Carnivoro)
			{
				//atacar o comer en matrix[3][4]
			}
			else
			{
				if(matrix[3][4].a instanceof Planta)
				;//eat
			}
		}
	};
}
