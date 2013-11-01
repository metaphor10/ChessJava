import java.awt.Graphics;

import javax.swing.ImageIcon;


public class King extends Piece 
{
	int location,yLocation;
	public King (boolean colorOfPiece)
	{
		valueOfPiece=6;
		isWhite = colorOfPiece;
		if (isWhite)
		{
			chessPiece = new ImageIcon("wking.gif");
		}else 
		{
			chessPiece = new ImageIcon("bking.gif");
		}
		
	}
	@Override
	public void drawPiece(Graphics p, int x, int y) 
	{
		locationX=x;
		locationY=y;
		System.out.println("draw");
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
		isOccupiedByOppsitPiece=true;
	
		if (Math.abs(y-(locationY/Chess.sizeOfSquare))==0 && Math.abs(x-(locationX/Chess.sizeOfSquare))==1)
		{
			isValid = true;
		}else if (Math.abs(y-(locationY/Chess.sizeOfSquare))==1 && Math.abs(x-(locationX/Chess.sizeOfSquare))==0)
			{
				isValid = true;
			}else if (Math.abs(y-(locationY/Chess.sizeOfSquare))==1 && Math.abs(x-(locationX/Chess.sizeOfSquare))==1)
				{
					isValid = true;
				}
		
		if (Chess.positions[y][x] !=null)
		{
			if(Chess.positions[y][x].isWhite==isWhite)
			{
				isOccupiedByOppsitPiece = false;
			}
		}
		
		
		
		// TODO Auto-generated method stub
		if (isValid&&isOccupiedByOppsitPiece)
		{
			return true;
		}else
		{
			return false;
		}
	}
	@Override
	public int getValueOfPiece() {
		// TODO Auto-generated method stub
		return valueOfPiece;
	}

}
