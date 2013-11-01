import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Knight extends Piece 
{
	
	int xLocation,yLocation;
	public Knight (boolean colorOfPiece)
	{
		valueOfPiece =4;
		
		isWhite = colorOfPiece;
		if (isWhite)
		{
			chessPiece = new ImageIcon("wknight.gif");
		}else 
		{
			chessPiece = new ImageIcon("bknight.gif");
		}
		
	}

	@Override
	public void drawPiece(Graphics p, int x, int y) 
	{
		locationX=x;
		locationY=y;
		p.drawImage(chessPiece.getImage(), locationX, locationY, Chess.sizeOfSquare, Chess.sizeOfSquare, null);
		// TODO Auto-generated method stub

	}

	@Override
	public void movePiece(int futureX, int futureY) 
	{
		
		
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canMove(int x, int y) 
	{
		isValid = false;
		if (Math.abs(x-(locationX/Chess.sizeOfSquare))==1 && Math.abs(y-(locationY/Chess.sizeOfSquare))==2)
		{
			isValid=true;
			
		}else if (Math.abs(y-(locationY/Chess.sizeOfSquare))==1 && Math.abs(x-(locationX/Chess.sizeOfSquare))==2)
		{
			isValid=true;
		}
		
		if (isValid)
		{
			if (Chess.positions[y][x]!=null)				
			{
				if (isWhite==Chess.positions[y][x].isWhite)
				{
					isValid=false;
				}
				
			}
		}
		// TODO Auto-generated method stub
		return isValid;
	}

	@Override
	public int getValueOfPiece() {
		// TODO Auto-generated method stub
		return valueOfPiece;
	}

}
