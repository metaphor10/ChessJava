import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Bishop extends Piece 
{
	public Bishop (boolean colorOfPiece)
	{
		valueOfPiece=3;
		
		isWhite = colorOfPiece;
		if (isWhite)
		{
			chessPiece = new ImageIcon("wbishop.gif");
			
		}else 
		{
			chessPiece = new ImageIcon("bbishop.gif");
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
		int diagnolY = 0, digonlX = 0,dx=1,dy=1;
		isValid = false;
		isOccupiedByOppsitPiece=true;
		
		if (Math.abs(x-(locationX/Chess.sizeOfSquare)) == Math.abs(y-(locationY/Chess.sizeOfSquare)))
		{
			isValid=true;
		
		
		if (x < (locationX/Chess.sizeOfSquare))
		{
			
			digonlX = locationX/Chess.sizeOfSquare-1;
			dx=-1;
			
		}else
		{
			
			
			digonlX = (locationX/Chess.sizeOfSquare)+1;
			dx=1;
		}
		if (y< (locationY/Chess.sizeOfSquare))
		{
			
			diagnolY = locationY/Chess.sizeOfSquare-1;
			dy=-1;
		}else
		{
			
			diagnolY= (locationY/Chess.sizeOfSquare)+1;
			dy=1;
		}
		for (int i=0;i<Math.abs(x-(locationX/Chess.sizeOfSquare))-1;i++)
		{
			
			if (Chess.positions[diagnolY][digonlX]!=null)
			{					
					isValid=false;				
			}
			
			digonlX+=dx;
			diagnolY+=dy;
			
		}
		}
		if (Chess.positions[y][x] != null)
		{
			if (Chess.positions[y][x].isWhite==isWhite)
			{
				isOccupiedByOppsitPiece=false;
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