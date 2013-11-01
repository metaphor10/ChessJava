import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Queen extends Piece {

	int xLocation,yLocation;
	public Queen (boolean colorOfPiece)
	{
		valueOfPiece=5;
		
		isWhite = colorOfPiece;
		if (isWhite)
		{
			chessPiece = new ImageIcon("wqueen.gif");
		}else 
		{
			chessPiece = new ImageIcon("bqueen.gif");
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
	public void movePiece(int futureX, int futureY) {
		
		// TODO Auto-generated method stub

	}
	@Override
	public boolean canMove(int x, int y) 
	{
		int followUp, digonlX, diagnolY, dx=1, dy=1;
		isOccupiedByOppsitPiece = true;
		isValid = false;
		if (Math.abs(x-(locationX/Chess.sizeOfSquare)) == Math.abs(y-(locationY/Chess.sizeOfSquare)))
		{
			isValid=true;
			if (x <= (locationX/Chess.sizeOfSquare))
			{
				
				digonlX = locationX/Chess.sizeOfSquare-1;
				dx=-1;
				
			}else
			{
				
				
				digonlX = (locationX/Chess.sizeOfSquare)+1;
			}
			if (y<=(locationY/Chess.sizeOfSquare))
			{
				
				diagnolY = locationY/Chess.sizeOfSquare-1;
				dy=-1;
			}else
			{
				
				diagnolY= (locationY/Chess.sizeOfSquare)+1;
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
			if (Chess.positions[y][x] != null)
			{
				if (Chess.positions[y][x].isWhite==isWhite)
				{
					isOccupiedByOppsitPiece=false;
				}
			}
		}else if (x!=(locationX/Chess.sizeOfSquare) && y== (locationY/Chess.sizeOfSquare))
				{
			isValid=true;
			if (x<=locationX/Chess.sizeOfSquare)
			{
				followUp=x+1;
			}else
			{
				followUp=(locationX/Chess.sizeOfSquare)+1;
			}
			for (int i=0;i<Math.abs(x-(locationX/Chess.sizeOfSquare))-1;i++)
			{
				if (Chess.positions[y][followUp]!=null)
				{
								
						isValid = false;					
				}
				followUp++;
			}
			if (Chess.positions[y][x] !=null)
			{
				if (Chess.positions[y][x].isWhite== isWhite)
				{
					isOccupiedByOppsitPiece = false;
				}
			}
			
				}else if (y!=(locationY/Chess.sizeOfSquare) && x == (locationX/Chess.sizeOfSquare))
					{
					isValid=true;
					if (y<=locationY/Chess.sizeOfSquare)
					{
						followUp=y+1;
						
					}else
					{
						followUp=(locationY/Chess.sizeOfSquare)+1;
					}
					for (int i=0;i<Math.abs(y-(locationY/Chess.sizeOfSquare))-1;i++)
					{
						if (Chess.positions[followUp][x]!=null)
						{
								isValid = false;											
						}
						followUp++;
					}
					if (Chess.positions[y][x] !=null)
					{
						if (Chess.positions[y][x].isWhite== isWhite)
						{
							isOccupiedByOppsitPiece = false;
						}
					}
					
					}
		
		// TODO Auto-generated method stub
		if(isValid&&isOccupiedByOppsitPiece)
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
