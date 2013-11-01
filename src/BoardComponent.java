import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class BoardComponent extends JComponent
{
	
	
	
	
	
	public void paintComponent (Graphics g)//draws the board according to the final sizeof sqaure in the main
	{
		
		
		
				
		
		
		
		
		boolean colorOfSqaure = false;
		
		for(int numberOfRows=0;numberOfRows<Chess.numberOfSquares;numberOfRows++)
	       {
	       	if(numberOfRows%2==0)
	        		{colorOfSqaure=false;}
	       	else if(numberOfRows%2!=0)
	        		{colorOfSqaure=true;}  
	       	
	       		for(int locationInRow=0;locationInRow<Chess.numberOfSquares;locationInRow++)
	        		{                
	       			 if(colorOfSqaure==true)
	        			{
	        				g.setColor(new Color (177,113,24));
	        				g.drawRect(locationInRow*Chess.sizeOfSquare,numberOfRows*Chess.sizeOfSquare,Chess.sizeOfSquare,Chess.sizeOfSquare);
	        				g.fillRect(locationInRow*Chess.sizeOfSquare,numberOfRows*Chess.sizeOfSquare, Chess.sizeOfSquare, Chess.sizeOfSquare);
	        				colorOfSqaure=false;
	        			}
	       			 else
	        			{
	       				 g.setColor(new Color (233,174,95));
	       				 
	       				 g.drawRect(locationInRow*Chess.sizeOfSquare,numberOfRows*Chess.sizeOfSquare,Chess.sizeOfSquare,Chess.sizeOfSquare);
	       				 g.fillRect(locationInRow*Chess.sizeOfSquare,numberOfRows*Chess.sizeOfSquare, Chess.sizeOfSquare, Chess.sizeOfSquare);
	       				 colorOfSqaure=true;
	        			}
	        		if (Chess.positions[numberOfRows][locationInRow]!= null)//draws the pieces on the boardaccording to the positions array
	        		{
	        			Chess.positions[numberOfRows][locationInRow].drawPiece(g, locationInRow*Chess.sizeOfSquare,numberOfRows*Chess.sizeOfSquare );
	        		}
	       			 
	       		}                       
	       		
	       }
		
		
		
	}

}
