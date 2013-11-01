import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Chess {

	public static Piece [][] positions;
	public static ArrayList <ArtificialInteligence> possibleMoves;
	public static boolean whosTurnItIs;
	final static int numberOfSquares = 8, sizeOfSquare = 80 ;
	public static BoardComponent first;
	
	public static void main(String[] args) 
	{
		possibleMoves = new ArrayList<ArtificialInteligence>();
		whosTurnItIs =true;
		positions = new Piece [8][8];
		positions[0][0] = new Rook(false);
		positions[0][1] = new Knight(false);
		positions[0][2] = new Bishop (false);
		positions[0][3] = new Queen(false);
		positions[0][4] = new King(false);
		positions[0][5] = new Bishop (false);
		positions[0][6] = new Knight(false);
		positions[0][7] = new Rook(false);
		for (int i =0; i<8;i++)
		{
			positions[1][i] = new Pawn(false);
		}
		for (int i =0; i<8;i++)
		{
			positions[6][i] = new Pawn(true);
		}
		positions[7][0] = new Rook(true);
		positions[7][1] = new Knight(true);
		positions[7][2] = new Bishop (true);
		positions[7][3] = new Queen(true);
		positions[7][4] = new King(true);
		positions[7][5] = new Bishop (true);
		positions[7][6] = new Knight(true);
		positions[7][7] = new Rook(true);
		
		first = new BoardComponent();
		
		JFrame mywindow = new JFrame();
		mywindow.setSize(655,670);
		mywindow.setTitle("Chess");
		mywindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		first.setSize(900, 900);
		first.addMouseListener(new BoardMouseListener());
		mywindow.add(first);
		
		
		
		
		mywindow.setLayout(null);
		
		mywindow.setVisible(true);
		
		
	}

}
