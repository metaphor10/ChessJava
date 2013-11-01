import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Pawn extends Piece
{
    int xLocation,yLocation;
    boolean firstMove= true;
    public Pawn (boolean colorOfPiece)
    {
    	valueOfPiece=1;
       
        isWhite = colorOfPiece;
        if (isWhite)
        {
            chessPiece = new ImageIcon("wpawn.gif");
        }else
        {
            chessPiece = new ImageIcon("bpawn.gif");
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
        isValid =false;
        if (isWhite)
        {
           
       
            if (y == ((locationY/Chess.sizeOfSquare)-2) && x==locationX/Chess.sizeOfSquare)
            {
                if (firstMove)
                {
                    if (Chess.positions[y][x]==null)
                    {
                       
                            firstMove=false;
                            isValid=true;
                       
                    }
                }
           
            }else if (y == ((locationY/Chess.sizeOfSquare)-1) && x==locationX/Chess.sizeOfSquare)
            {
                if (Chess.positions[y][x]==null)
                {
                   
                        firstMove=false;
                        isValid=true;
                   
                }
            }else if(y == ((locationY/Chess.sizeOfSquare)-1) && Math.abs(x-(locationX/Chess.sizeOfSquare))==1)
                    {
                        if (Chess.positions[y][x]!=null)
                        {
                            if (isWhite!=Chess.positions[y][x].isWhite)
                            {
                                firstMove=false;
                                isValid=true;
                            }
                        }
                    }
        }else
        {
            if (y == ((locationY/Chess.sizeOfSquare)+2) && x==locationX/Chess.sizeOfSquare)
            {
                if (firstMove)
                {
                    if (Chess.positions[y][x]==null)
                    {
                       
                            firstMove=false;
                            isValid=true;
                       
                    }
                }
           
            }else if (y == ((locationY/Chess.sizeOfSquare)+1) && x==locationX/Chess.sizeOfSquare)
            {
                if (Chess.positions[y][x]==null)
                {
                   
                        firstMove=false;
                        isValid=true;
                   
                }
            }else if(y == ((locationY/Chess.sizeOfSquare)+1) && Math.abs(x-(locationX/Chess.sizeOfSquare))==1)
            {
                if (Chess.positions[y][x]!=null)
                {
                   
               
                    if (isWhite!=Chess.positions[y][x].isWhite)
                    {
                        firstMove=false;
                        isValid=true;
                    }
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