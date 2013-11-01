import java.awt.Graphics;

import javax.swing.ImageIcon;


public abstract class Piece 
{
	int locationX, locationY,valueOfPiece;
	ImageIcon chessPiece;
	boolean isWhite, isValid, isOccupiedByOppsitPiece;
	
	abstract public void drawPiece(Graphics p,int x ,int y);
	abstract public void movePiece(int futureX, int futureY);
	abstract public boolean canMove(int x, int y);
	abstract public int getValueOfPiece();
}
